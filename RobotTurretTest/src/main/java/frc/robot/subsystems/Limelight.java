package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * The limelight camera emits a green light to track reflective tape 
 * for alignment. This class contains all the necessary objects and
 * methods to retrieve data from the limelight.
 */
public class Limelight{
    //#region Declare limelight objects
    private static Limelight instance = null;

    private static NetworkTable table;
    private static NetworkTableEntry tX;
    private static NetworkTableEntry tY;
    private static NetworkTableEntry tV;
    private static NetworkTableEntry tA;
    private static NetworkTableEntry camMode;
    private static NetworkTableEntry ledMode;

    //In Degrees
    private static double limelightAngle = 0.0;
    //In Inches
    private static double limelightHeight = 0.0;
    private static double hubHeight = 104.0;

    /**
     * Enums allow for values to have labels that describe what a passed in value does. 
     * Usefule when param takes value that performs a function.
     * Example: ledMode blinks green light if param int is "2."
     * Instead of passing in "2," pass in "LEDMode.BLINK.", still has the value of "2", 
     * just describing what the param does.
     */
    private enum LEDMode{
        PIPELINE(0),
        OFF(1),
        BLINK(2),
        ON(3);

        private int modeValue;
        private LEDMode(int modeVal){
            this.modeValue = modeVal;
        }
    }

    private enum CamMode{
        VISION(0),
        DRIVER(1);

        private int modeValue;
        private CamMode(int modeVal){
            this.modeValue = modeVal;
        }
    }
    //#endregion

    //#region Get limelight info
    /**
     * Gets limelight for use in other classes
     * @return the limelight instance object.
     */
    public static Limelight getInstance(){
        if (instance == null){
            instance = new Limelight();
        }
        return instance;
    }

    //Get limelight info from network table
    public Limelight(){
        table = NetworkTableInstance.getDefault().getTable("limelight");
        tX = table.getEntry("tx"); // Horizontal offset 
        tY = table.getEntry("ty"); // Vertical offset
        tV = table.getEntry("tv"); // Whether limelight has valid targets (0 or 1)
        tA = table.getEntry("ta"); // Target area (% of image)
        ledMode = table.getEntry("ledMode"); // Limelight's LED state (0-3)
        camMode = table.getEntry("camMode"); // Limelight's operation mode (0-1)
    }

    /**
     * Horizontal offset from crosshair to target.
     * @return offset from -29.8 to 29.8 degrees.
     */
    public static double getTargetOffsetX(){
        return tX.getDouble(0.0);
    }

    /**
     * Vertical offset from crosshair to target.
     * @return offset from -24.85 to 24.85 degrees.
     */
    public double getTargetOffsetY(){
        return tY.getDouble(0.0);
    }

    /**
     * Get whether or not a target is detected.
     * @return true if target found, false if target not found.
     */
    public boolean isTargetAvailable(){
        return tV.getNumber(0).intValue() == 1 ? true : false;
    }

    /**
     * Get area of detected target.                                                                                                                        
     * @return target area 0% to 100%.
     */
    public double getTargetArea(){
        return tA.getDouble(0.0);
    }
    //#endregion

    //#region Set/change limelight status & LED
    //Change limelight status
    public void turnOnLED(){
        ledMode.setNumber(LEDMode.ON.modeValue);
    }                 
    public void turnOffLED(){
        ledMode.setNumber(LEDMode.OFF.modeValue);
    }
    public void blinkLED(){
        ledMode.setNumber(LEDMode.BLINK.modeValue);
    }

    /**
     * Set video feed in driver mode.
     * Turns off green light and switches camera mode to driver.
     */
    public void setModeDriver(){
        ledMode.setNumber(LEDMode.OFF.modeValue);
        camMode.setNumber(CamMode.DRIVER.modeValue);
    }

    /**
     * Set video feed in vision mode.
     * Turns on green light and switches camera mode to vision.
     */
    public void setModeVision(){
        ledMode.setNumber(LEDMode.ON.modeValue);
        camMode.setNumber(CamMode.VISION.modeValue);
    }

    /**
     * Tell whether the limelight is in driver or vision mode.
     * Driver mode: LEDs off & the camera in color.
     * Vision mode: LEDs on & the camera in black and white.
     */
    private boolean isModeDriver(){
        return ledMode.getDouble(0.0) == LEDMode.OFF.modeValue && camMode.getDouble(0.0) == CamMode.DRIVER.modeValue;
    }
    private boolean isModeVision(){
        return ledMode.getDouble(0.0) == LEDMode.ON.modeValue && camMode.getDouble(0.0) == CamMode.VISION.modeValue;
    }
  
    //Toggle video feed type
    public void toggleMode(){
        if (this.isModeDriver()){
        this.setModeVision();
        }else if (this.isModeVision()){
        this.setModeDriver();
        }else{
        this.blinkLED();
        }
    }
    //#endregion

    //#region Find values for limelight calculation
    // Finds the current distance of the robot from the hub
    public double findDistance(double verticalOffset){
        /* Get the angle the center of the limelight is at relative to the reflective tape */
        double angleToGoalDegrees = limelightAngle + verticalOffset;
        /* Convert that angle into radians */
        double angleToGoalRadians = angleToGoalDegrees * (Math.PI / 180);
        /* Calculate current distance */
        double distanceToGoal = (hubHeight - limelightHeight) / Math.tan(angleToGoalRadians);

        return distanceToGoal;
    }

    // Finds the desired velocity for the launch motor
    public double calculateDesiredRPM(){
        double [] limelightDistance = {0.0};
        double [] launcherRPM = {0.0};
        double lowerDistance = 0.0;
        double higherDistance = 0.0;
        int lowerInstance = 0;
        int higherInstance = 0;
        double rpmDivider;
        double desiredRPM;

        double currentDistance = this.findDistance(getTargetOffsetY());
        
        //Loops through the limelightdistance array to find the highest and lowest values to later calculate RPM from
        for(int i = 0; i < limelightDistance.length; i++){
            if(currentDistance < limelightDistance[i]){
                lowerDistance = limelightDistance[i];
                lowerInstance = i;
            }
            
            if(currentDistance > limelightDistance[i]){
                higherDistance = limelightDistance[i];
                higherInstance = i;
                break;
            }
        }
        //Find the divider for finding the desired RPM
        rpmDivider = (lowerDistance + higherDistance) / currentDistance;

        //Calculate the RPM
        desiredRPM = (launcherRPM[lowerInstance] + launcherRPM[higherInstance]) / rpmDivider;

        return desiredRPM;
    }
    //#endregion
}