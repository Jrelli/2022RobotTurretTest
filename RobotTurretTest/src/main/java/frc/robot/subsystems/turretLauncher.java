package frc.robot.subsystems;

import frc.robot.RobotContainer;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class turretLauncher extends SubsystemBase {
    private WPI_TalonFX m_turretLauncher;
    private WPI_TalonFX m_turretAccel;
    private WPI_TalonSRX m_turretIndex;
    private WPI_TalonSRX m_launcherIndexTop;
    private WPI_TalonSRX m_launcherIndexBottom;
    private int m_toggleLaunch;

    public turretLauncher() {
        m_turretLauncher = new WPI_TalonFX(Constants.TURRET_LAUNCH_ID);
        RobotContainer.configureTalonFX(m_turretLauncher, false, false, Constants.TURRET_LAUNCH_F, Constants.TURRET_LAUNCH_P, 
        Constants.TURRET_LAUNCH_I, Constants.TURRET_LAUNCH_D);
    
        m_turretAccel = new WPI_TalonFX(Constants.TURRET_ACCEL_ID);
        RobotContainer.configureTalonFX(m_turretAccel, false, false, Constants.TURRET_ACCEL_F, Constants.TURRET_ACCEL_P, 
        Constants.TURRET_ACCEL_I, Constants.TURRET_ACCEL_D);

        m_turretIndex = new WPI_TalonSRX(Constants.TURRET_INDEX_ID);
        RobotContainer.configureTalonSRX(m_turretIndex, false, FeedbackDevice.CTRE_MagEncoder_Relative, false, false, 
        Constants.TURRET_INDEX_F, Constants.TURRET_INDEX_P, Constants.TURRET_INDEX_I, Constants.TURRET_INDEX_D, 0, 0, false);
    }
    
    public double getLaunchVel(){
        return m_turretLauncher.getSelectedSensorVelocity();
    }
    public double getAcceleratorVel(){
        return m_turretAccel.getSelectedSensorVelocity();
    }
    public void setLauncherVelocity(int rpm){
        m_turretLauncher.set(ControlMode.Velocity, RobotContainer.convertRPMToVelocity(rpm * m_toggleLaunch , Constants.TALON_FX_TPR));
        SmartDashboard.putNumber("Launch Desired Vel", RobotContainer.convertRPMToVelocity(rpm * m_toggleLaunch, Constants.TALON_FX_TPR));
    }
    public void setAcceleratorVelocity(int rpm){
        m_turretAccel.set(ControlMode.Velocity,  RobotContainer.convertRPMToVelocity(rpm * m_toggleLaunch, Constants.TALON_FX_TPR));
        SmartDashboard.putNumber("Accelerator Desired Vel", RobotContainer.convertRPMToVelocity(rpm * m_toggleLaunch, Constants.TALON_FX_TPR));
    }
    public void setIndexPower(double power){
        m_launcherIndexTop.set(ControlMode.PercentOutput, power);
        m_launcherIndexBottom.set(ControlMode.PercentOutput, -power);
    }
}