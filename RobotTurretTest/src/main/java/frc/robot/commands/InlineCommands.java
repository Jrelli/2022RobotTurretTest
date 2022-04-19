package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.RobotContainer;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;

/* 
 * Inline commands allow the creation of new commands without a new CommandBase file.
 * Usage: single/double commands (Example: extending a piston)
 * Can be used in other files (other commands or OI.java for binding commands to buttons).
 * For chains of commands (Example: ten-ball autonomous command sequence), create a separate CommandBase/CommandGroup file.
 */
public class InlineCommands {

    /*
    ██████  ███████  ██████ ██       █████  ██████  ███████    ██████  ██████  ███    ███ ███    ███  █████  ███    ██ ██████  ███████         
    ██   ██ ██      ██      ██      ██   ██ ██   ██ ██         ██      ██   ██ ████  ████ ████  ████ ██   ██ ████   ██ ██   ██ ██                 
    ██   ██ █████   ██      ██      ███████ ██████  █████      ██      ██   ██ ██ ████ ██ ██ ████ ██ ███████ ██ ██  ██ ██   ██ ███████          
    ██   ██ ██      ██      ██      ██   ██ ██   ██ ██         ██      ██   ██ ██  ██  ██ ██  ██  ██ ██   ██ ██  ██ ██ ██   ██      ██             
    ██████  ███████  ██████ ███████ ██   ██ ██   ██ ███████    ██████  ██████  ██      ██ ██      ██ ██   ██ ██   ████ ██████  ███████                                                                          
    */

    // Chassis
    public final Command m_driveWithJoystick;

    // Climb
    // public final Command m_moveLeftClimb;
    // public final Command m_moveRightClimb;

    // public final Command m_stopLeftClimb;
    // public final Command m_stopRightClimb;

    // public final Command m_toggleClimb;

    // Intake
    // public final Command m_startIntake;
    // public final Command m_stopIntake;
    // public final Command m_reverseIntakeMotor;
   
    // Turret Launcher
    public final Command m_startLaunchSequence;
    public final Command m_stopLaunchSequence;
    public final Command m_startLaunchIndex;
    public final Command m_stopLaunchIndex;
    public final Command m_toggleTurretLock;
    //public final Command m_aimWithJoystick;

    // Turret Aim
    //public final Command m_toggleTurretLock;

    /* Limelight */
    public final Command m_toggleLimelight;
  
    public InlineCommands(){
        /**
        ██ ███    ██ ███████ ████████  █████  ███    ██ ████████ ██  █████  ████████ ███████ 
        ██ ████   ██ ██         ██    ██   ██ ████   ██    ██    ██ ██   ██    ██    ██      
        ██ ██ ██  ██ ███████    ██    ███████ ██ ██  ██    ██    ██ ███████    ██    █████   
        ██ ██  ██ ██      ██    ██    ██   ██ ██  ██ ██    ██    ██ ██   ██    ██    ██      
        ██ ██   ████ ███████    ██    ██   ██ ██   ████    ██    ██ ██   ██    ██    ██████
        */

        // SwerveDrive
        m_driveWithJoystick   = new RunCommand(() -> RobotContainer.m_chassis.driveWithJoystick(
                                                     OI.getDriverJoystick().getRawAxis(0), 
                                                     OI.getDriverJoystick().getRawAxis(1), 
                                                     OI.getDriverJoystick().getRawAxis(4), 
                                                     false), RobotContainer.m_chassis);

        // Turret Launcher
        m_startLaunchSequence = new InstantCommand(() -> RobotContainer.m_turretLauncher.setLauncherVelocity(Constants.TURRET_LAUNCH_RPM)).alongWith(
                                new InstantCommand(() -> RobotContainer.m_turretLauncher.setAcceleratorVelocity(Constants.TURRET_ACCEL_RPM)));
        m_stopLaunchSequence  = new InstantCommand(() -> this.m_startLaunchSequence.cancel()).alongWith(
                                new InstantCommand(() -> RobotContainer.m_turretLauncher.setLauncherVelocity(0)).alongWith(
                                new InstantCommand(() -> RobotContainer.m_turretLauncher.setAcceleratorVelocity(0))));
        m_startLaunchIndex    = new InstantCommand(() -> RobotContainer.m_turretLauncher.setIndexPower(Constants.TURRET_INDEX_POWER));
        m_stopLaunchIndex     = new InstantCommand(() -> RobotContainer.m_turretLauncher.setIndexPower(0));
        m_toggleTurretLock    = new TurretLock().andThen(new InstantCommand(() -> RobotContainer.m_limelight.setModeDriver()));

        // m_aimWithJoystick     = new RunCommand(() -> RobotContainer.m_turretAim.aimWithJoystick(
        //                                              RobotContainer.m_OI.getOperatorJoystick().getRawAxis(1)),
        //                                              RobotContainer.m_turretAim);

        // Limelight
        m_toggleLimelight     = new InstantCommand(() -> RobotContainer.m_limelight.toggleMode());

    }
}
