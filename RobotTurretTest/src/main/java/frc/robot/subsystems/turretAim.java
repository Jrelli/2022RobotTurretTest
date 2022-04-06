package frc.robot.subsystems;

import frc.robot.RobotContainer;
import frc.robot.commands.TurretLock;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class turretAim extends SubsystemBase {
    private WPI_TalonFX m_turretAimMotor;

    public turretAim() {
        m_turretAimMotor = new WPI_TalonFX(Constants.TURRET_ROTATION_ID);
        RobotContainer.configureTalonFX(m_turretAimMotor, false, false, Constants.TURRET_ROTATION_F, Constants.TURRET_ROTATION_P, 
        Constants.TURRET_ROTATION_I, Constants.TURRET_ROTATION_D);
    }

    //set power of rotation motor
    public void setTurretAimPower(double power){
        m_turretAimMotor.set(ControlMode.PercentOutput, power);
    }

    //set velocity of rotation motor
    public void setTurretAimVelocity(int rpm){
        m_turretAimMotor.set(ControlMode.Velocity, RobotContainer.convertRPMToVelocity(rpm, Constants.TALON_FX_TPR));
        SmartDashboard.putNumber("Turret rotatoion Desired Vel", RobotContainer.convertRPMToVelocity(rpm, Constants.TALON_FX_TPR));
    }

    //Get motors for use in commands
    public WPI_TalonFX getTurretRotation(){
        return m_turretAimMotor;
    }
}