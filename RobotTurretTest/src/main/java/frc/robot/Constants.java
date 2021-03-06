package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;

public class Constants
{
  /*
  ██████   ██████  ██████  ████████     ██ ██████   █  ███████ 
  ██   ██ ██    ██ ██   ██    ██        ██ ██   ██     ██      
  ██████  ██    ██ ██████     ██        ██ ██   ██     ███████ 
  ██      ██    ██ ██   ██    ██        ██ ██   ██          ██ 
  ██       ██████  ██   ██    ██        ██ ██████      ███████ 
  */

  // Swerve
  public static final int FRONT_RIGHT_ANGLE_MOTOR_ID                      = 2;
  public static final int FRONT_RIGHT_SPEED_MOTOR_ID                      = 3;

  public static final int FRONT_LEFT_ANGLE_MOTOR_ID                       = 15; 
  public static final int FRONT_LEFT_SPEED_MOTOR_ID                       = 12;

  public static final int BACK_LEFT_ANGLE_MOTOR_ID                        = 14;
  public static final int BACK_LEFT_SPEED_MOTOR_ID                        = 13;

  public static final int BACK_RIGHT_ANGLE_MOTOR_ID                       = 0;
  public static final int BACK_RIGHT_SPEED_MOTOR_ID                       = 1;
  
  public static final int ABS_ENCODER_FR_ID                               = 1;
  public static final int ABS_ENCODER_FL_ID                               = 4;
  public static final int ABS_ENCODER_BL_ID                               = 3;
  public static final int ABS_ENCODER_BR_ID                               = 2;

  // Climber
  public static final int CLIMB_LEFT_ID                                   = 18;
  public static final int CLIMB_RIGHT_ID                                  = 17;   

  // Intake 
  public static final int INTAKE_MOTOR_ID                                 = 20;

  // Turret
  public static final int TURRET_LAUNCH_ID                                = 5;
  public static final int TURRET_ACCEL_ID                                 = 6;
  public static final int TURRET_INDEX_ID                                 = 21;
  public static final int TURRET_ROTATION_ID                              = 19;
  public static final int TURRET_CANCODER_ID                              = 0;

  /*
  ███████ ██    ██ ██████  ███████ ██    ██ ███████ ████████ ███████ ███    ███ 
  ██      ██    ██ ██   ██ ██       ██  ██  ██         ██    ██      ████  ████   
  ███████ ██    ██ ██████  ███████   ████   ███████    ██    █████   ██ ████ ██ 
       ██ ██    ██ ██   ██      ██    ██         ██    ██    ██      ██  ██  ██ 
  ███████  ██████  ██████  ███████    ██    ███████    ██    ███████ ██      ██ 
                                                                                
                                                                                
  ██    ██  █████  ██      ██    ██ ███████ ███████                             
  ██    ██ ██   ██ ██      ██    ██ ██      ██                                  
  ██    ██ ███████ ██      ██    ██ █████   ███████                             
   ██  ██  ██   ██ ██      ██    ██ ██           ██                             
    ████   ██   ██ ███████  ██████  ███████ ███████ 
  */

  // Swerve
  public static final double CHASSIS_MAX_POWER                            = 0.7;
  public static final double K_CHASSIS_TURN_P                             = 0;
  public static final double K_CHASSIS_TURN_I                             = 0;
  public static final double K_CHASSIS_TURN_D                             = 0;

  public static final double K_TURN_TOLERANCE_DEG                         = 0;
  public static final double K_TURN_RATE_TOLERANCE_DEG_PER_SEC            = 0;

  public static final double K_CHASSIS_TURN_VISION_P                      = 0.02;
  public static final double K_CHASSIS_TURN_VISION_MIN                    = 0.1;
  public static final double CHASSIS_TURN_ERROR_THRESHOLD                 = 0.5;
  
  public static final double K_CHASSIS_LEFT_ANGLE_P                       = 0.2245;     //previous: 0.225
  public static final double K_CHASSIS_LEFT_ANGLE_I                       = 0.0000185;  //previous: 0.0002
  public static final double K_CHASSIS_LEFT_ANGLE_D                       = 0.000001;   //previous: 0.0000001

  public static final double K_CHASSIS_RIGHT_ANGLE_P                      = 0.2245;    //previous: 0.225
  public static final double K_CHASSIS_RIGHT_ANGLE_I                      = 0.0000185; //previous: 0.0002
  public static final double K_CHASSIS_RIGHT_ANGLE_D                      = 0.000003;  //previous: 0.000005

  // Climber
  public static final double CLIMB_POWER                                  = -0.67;

  // Intake
  public static final double INTAKE_P                                     = 0.3; //0.4
  public static final double INTAKE_I                                     = 0.00015; //0.0003
  public static final double INTAKE_D                                     = 0;
  public static final double INTAKE_F                                     = 0;

  public static final double INTAKE_WHEEL_POWER                           = 0.8;
  public static final int    INTAKE_WHEEL_RPM                             = 8000;
  public static final int    AUTO_INTAKE_WHEEL_POS                        = 3000;

  // Turret
  public static final double TURRET_LAUNCH_P                            = 0.008; //0.0085
  public static final double TURRET_LAUNCH_I                            = 0.000111;  //0.000115
  public static final double TURRET_LAUNCH_D                            = 0.000005;  
  public static final double TURRET_LAUNCH_F                            = 0;  

  public static final double TURRET_ROTATION_P                          =0;
  public static final double TURRET_ROTATION_I                          =0;
  public static final double TURRET_ROTATION_D                          =0;
  public static final double TURRET_ROTATION_F                          =0;
  
  public static final double TURRET_ACCEL_P                             = 0.009;  //0.0105
  public static final double TURRET_ACCEL_I                             = 0.000108;  //0.000105
  public static final double TURRET_ACCEL_D                             = 0.000005;  
  public static final double TURRET_ACCEL_F                             = 0;  

  public static final double TURRET_INDEX_P                             = 0.01;  
  public static final double TURRET_INDEX_I                             = 0.0001;  
  public static final double TURRET_INDEX_D                             = 0;  
  public static final double TURRET_INDEX_F                             = 0;  

  public static final double TURRET_LAUNCH_POWER                        = 0.7;
  public static final double TURRET_ACCEL_POWER                         = 0.38;
  public static final double TURRET_INDEX_POWER                         = -0.5;

  public static final int TURRET_LAUNCH_RPM                             = 4400; //4100
  public static final int TURRET_ACCEL_RPM                              = 3300; //3500
  public static final int TURRET_AUTO_RPM                               = 4800; //4400

  // LEDs
  public static final int TOTAL_LEDS_COUNT                                = 0;
  public static final int SWIRL_LEDS_COUNT                                = 0;
  public static final int TOP_LEDS_COUNT                                  = 0;
  public static final int LEDS_ID                                         = 0;
  public static final int LEDS_BUFFER_ID                                  = 0;
  public static final int LEDS_LENGTH                                     = 0;

  /*
       ██  ██████  ██    ██ ███████ ████████ ██  ██████ ██   ██ 
       ██ ██    ██  ██  ██  ██         ██    ██ ██      ██  ██  
       ██ ██    ██   ████   ███████    ██    ██ ██      █████   
  ██   ██ ██    ██    ██         ██    ██    ██ ██      ██  ██ 
   █████   ██████     ██    ███████    ██    ██  ██████ ██   ██ 
                                                                
  ██████  ██    ██ ████████ ████████  ██████  ███    ██ ███████ 
  ██   ██ ██    ██    ██       ██    ██    ██ ████   ██ ██      
  ██████  ██    ██    ██       ██    ██    ██ ██ ██  ██ ███████ 
  ██   ██ ██    ██    ██       ██    ██    ██ ██  ██ ██      ██ 
  ██████   ██████     ██       ██     ██████  ██   ████ ███████
  */

  // Controllers
  public static final int DRIVER_CONTROLLER_PORT                            = 0;
  public static final int OPERATOR_CONTROLLER_PORT                          = 1;

  // Buttons
  public static final int LEFT_CLIMB_BTN_ID                               = 4;
  public static final int RIGHT_CLIMB_BTN_ID                              = 2;
  public static final int TOGGLE_CLIMB_BTN_ID                             = 7;

  public static final int INTAKE_BTN_ID                                   = 1;
  public static final int REVERSE_INTAKE_BTN_ID                           = 0;

  public static final int LAUNCH_BTN_ID                                   = 6;

  public static final int TOGGLE_TURRET_LOCK_BTN_ID                       = 213;

  /*
  ███████ ██      ███████  ██████ ████████ ██████   ██████  ███    ██ ██  ██████ ███████ 
  ██      ██      ██      ██         ██    ██   ██ ██    ██ ████   ██ ██ ██      ██      
  █████   ██      █████   ██         ██    ██████  ██    ██ ██ ██  ██ ██ ██      ███████ 
  ██      ██      ██      ██         ██    ██   ██ ██    ██ ██  ██ ██ ██ ██           ██ 
  ███████ ███████ ███████  ██████    ██    ██   ██  ██████  ██   ████ ██  ██████ ███████ 
                                                                                        
                                                                                        
  ███████ ██████  ███████  ██████ ███████                                                
  ██      ██   ██ ██      ██      ██                                                     
  ███████ ██████  █████   ██      ███████                                                
       ██ ██      ██      ██           ██                                                  
  ███████ ██      ███████  ██████ ███████                                              
  */

  // Motor Configuration
  public static final int K_PID_LOOP_IDX                                  = 0;
  public static final int K_SLOT_IDX                                      = 0;
  public static final int K_TIMEOUT_MS                                    = 30;
  public static final int TALON_FX_TPR                                    = 2048; //motor ticks per revolution for Talon FX (no gear)
  public static final int INTAKE_TPR                                      = 4200; //talonSRX + gearbox

  // Swerve
  public static final double SWERVE_DRIVE_MAX_VOLTAGE                     = 4.95;
  public static final double SWERVE_GEAR_RATIO                            = 0.0833333; //wheel spins per angle motor spin    
  public static final double SWERVE_TPR                                   = 2048 / SWERVE_GEAR_RATIO; //motors ticks per revolution of wheel

  public static final double K_MAX_VELOCITY                               = 3.0; // m/s
  public static final double K_MODULE_MAX_ANGULAR_VELOCITY                = Math.PI; // 0.5 rotations/sec
  public static final double K_MODULE_MAX_ANGULAR_ACCELERATION            = 2 * Math.PI; //radians/sec^2
  public static final double K_MAX_ACCELERATION_METERS_PER_SECOND_SQUARED = 3.0; 
 
  public static final int K_ABSOLUTE_ENCODER_UPR                          = 4096; //units per rotation

  // Swerve Specs
  public static final Translation2d BACK_LEFT_WHEEL_LOCATION              = new Translation2d(-12.5 , 10.75);
  public static final Translation2d BACK_RIGHT_WHEEL_LOCATION             = new Translation2d(-12.5 , -10.75);
  public static final Translation2d FRONT_LEFT_WHEEL_LOCATION             = new Translation2d(12.5 , 10.75);        
  public static final Translation2d FRONT_RIGHT_WHEEL_LOCATION            = new Translation2d(12.5 , -10.75);

  public static final double K_WHEEL_DIAMETER_METERS                      = 0.1524;
  public static final double SWERVE_DRIVE_WHEEL_AXLE_LENGTH               = 36;
  public static final double SWERVE_DRIVE_WHEEL_AXLE_WIDTH                = 48;
  public static final double SWERVE_DRIVE_WHEEL_AXLE_DIAGONAL             = 60;

  public static final boolean K_GYRO_REVERSED                             = true;

  public static final double WHEEL_MOTOR_TICKS_PER_REVOLUTION             = 2048 * 12; //kSensorUnitsPerRotation / kGearRatio;

  public static final int K_ENCODER_TICKS_PER_REVOLUTION                  = 28300;
  public static final double K_ENCODER_DISTANCE_PER_PULSE                 = (K_WHEEL_DIAMETER_METERS * Math.PI) / (double) K_ENCODER_TICKS_PER_REVOLUTION;

  // Use robot characterization tool for these values.
  public static final double K_STATIC_VOLT                                = 0.372; // volts
  public static final double K_VELOCITY_VOLT                              = 3.09; // volt seconds / meter
  public static final double K_ACCELERATION_VOLT                          = 0.154; // volt seconds ^2/meter
}