package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.SPI;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;

public class swerveDrive extends SubsystemBase {

    public swerveDrive() {
        //Declare chassis objects
        private AHRS m_ahrs;

        private WPI_TalonFX m_angleMotorFrontRight;
        private WPI_TalonFX m_speedMotorFrontRight;
  
        private WPI_TalonFX m_angleMotorFrontLeft;
        private WPI_TalonFX m_speedMotorFrontLeft;

        private WPI_TalonFX m_angleMotorBackLeft;
        private WPI_TalonFX m_speedMotorBackLeft;

        private WPI_TalonFX m_angleMotorBackRight;
        private WPI_TalonFX m_speedMotorBackRight;
    }

    // This method will be called once per scheduler run
    @Override
    public void periodic() {
        
    }

    // This method will be called once per scheduler run when in simulation
    @Override
    public void simulationPeriodic() {
        
    }
}

