package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class OI {
    private static Joystick m_driverJoystick;
    private static Joystick m_operatorJoystick;

    public static JoystickButton m_leftClimbBtn;
    public static JoystickButton m_rightClimbBtn;
    public static JoystickButton m_toggleClimbBtn;

    private static JoystickButton m_intakeBtn;
    private static JoystickButton m_reverseIntakeBtn;

    private static JoystickButton m_launchSequenceBtn;
    private static JoystickButton m_toggleTurretLockBtn;

    public OI(){
        // Instantiate joysticks
        m_driverJoystick       = new Joystick(Constants.DRIVER_CONTROLLER_PORT);
        m_operatorJoystick     = new Joystick(Constants.OPERATOR_CONTROLLER_PORT);

        // Climb 
        m_leftClimbBtn         = new JoystickButton(m_operatorJoystick, Constants.LEFT_CLIMB_BTN_ID);
        m_rightClimbBtn        = new JoystickButton(m_operatorJoystick, Constants.RIGHT_CLIMB_BTN_ID);
        m_toggleClimbBtn       = new JoystickButton(m_operatorJoystick, Constants.TOGGLE_CLIMB_BTN_ID);  

        // Intake
        m_intakeBtn            = new JoystickButton(m_operatorJoystick, Constants.INTAKE_BTN_ID);
        m_reverseIntakeBtn     = new JoystickButton(m_operatorJoystick, Constants.REVERSE_INTAKE_BTN_ID);

        // Turret
        m_launchSequenceBtn    = new JoystickButton(m_operatorJoystick, Constants.LAUNCH_BTN_ID);
        m_toggleTurretLockBtn  = new JoystickButton(m_operatorJoystick, Constants.TOGGLE_TURRET_LOCK_BTN_ID);
    }

    // Get driver joystick for use in commands
    public Joystick getDriverJoystick(){
        return m_driverJoystick;
    }
    // Bind commands to buttons
    public void configureButtonBindings(){
        // Climb
        m_leftClimbBtn.whenPressed(RobotContainer.m_inlineCommands.m_moveLeftClimb);
        m_leftClimbBtn.whenReleased(RobotContainer.m_inlineCommands.m_stopLeftClimb);
        m_rightClimbBtn.whenPressed(RobotContainer.m_inlineCommands.m_moveRightClimb);
        m_rightClimbBtn.whenReleased(RobotContainer.m_inlineCommands.m_stopRightClimb);
        m_toggleClimbBtn.whenPressed(RobotContainer.m_inlineCommands.m_toggleClimb);

        // Intake
        m_intakeBtn.whenPressed(RobotContainer.m_inlineCommands.m_startIntake);
        m_intakeBtn.whenReleased(RobotContainer.m_inlineCommands.m_stopIntake);
        m_reverseIntakeBtn.whenPressed(RobotContainer.m_inlineCommands.m_reverseIntakeMotor);

        // Turret
        m_toggleTurretLockBtn.whenPressed(RobotContainer.m_inlineCommands.m_toggleTurretLock);

        m_launchSequenceBtn.whenPressed(RobotContainer.m_inlineCommands.m_startLaunchSequence);
        m_launchSequenceBtn.whenReleased(RobotContainer.m_inlineCommands.m_stopLaunchSequence);
    }
}
