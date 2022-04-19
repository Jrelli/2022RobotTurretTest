package frc.robot.subsystems;

import frc.robot.OI;
import frc.robot.RobotContainer;
import frc.robot.commands.TurretLock;
import frc.robot.Constants;

import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenix.sensors.CANCoderConfiguration;
import com.ctre.phoenix.sensors.SensorTimeBase;

import java.nio.charset.CharsetEncoder;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class turretAim extends SubsystemBase {
    private WPI_TalonFX m_turretAimMotor;
    private double degrees;
    private double angleOffset = Limelight.getTargetOffsetX();
    private CANCoderConfiguration m_canCoder;

    public turretAim() {
        m_turretAimMotor = new WPI_TalonFX(Constants.TURRET_ROTATION_ID);
        RobotContainer.configureTalonFX(m_turretAimMotor, false, false, Constants.TURRET_ROTATION_F, Constants.TURRET_ROTATION_P, 
        Constants.TURRET_ROTATION_I, Constants.TURRET_ROTATION_D);

        m_canCoder = new CANCoderConfiguration();
        
        // set units of the CANCoder to radians, with velocity being radians per second
        m_canCoder.sensorCoefficient = 2 * Math.PI / 4096.0;
        m_canCoder.unitString = "rad";
        m_canCoder.sensorTimeBase = SensorTimeBase.PerSecond;
        // CharsetEncoder.configAllSettings(m_canCoder);

        if(TurretLock.lockedTarget){
            if(angleOffset > .5){
                m_turretAimMotor.set(ControlMode.PercentOutput, Constants.TURRET_ACCEL_POWER);
            }else if (angleOffset < -.5){
                m_turretAimMotor.set(ControlMode.PercentOutput, -Constants.TURRET_ACCEL_POWER);
            }
        }else{
            aimWithJoystick(OI.getOperatorJoystick().getRawAxis(0));;
        }
    }

    public void aimWithJoystick(double xRotate){
        m_turretAimMotor.set(ControlMode.PercentOutput, Constants.TURRET_ACCEL_POWER * xRotate);
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

    public double getTurretRotationAngleDegrees(){
        return degrees;
    }

    //Get motors for use in commands
    public WPI_TalonFX getTurretRotation(){
        return m_turretAimMotor;
    }
}