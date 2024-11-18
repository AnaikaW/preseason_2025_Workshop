// Package declaration. Replace "frc.robot" with the appropriate package path for your project.
package frc.robot;

// Import necessary libraries. Add or remove imports depending on your specific needs.
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The Robot class serves as the main entry point for the robot program.
 * It manages the lifecycle of the robot and coordinates subsystems and commands.
 */
public class Robot extends TimedRobot {

    // Declare commands to manage during different robot states. Add or remove as needed.
    private Command m_teleopCommand; // Primary teleop command.
    private Command m_teleopCommand1; // Additional command placeholder. Customize or remove if unused.
    private Command m_teleopCommand2; // Additional command placeholder. Customize or remove if unused.

    // Declare the RobotContainer, which sets up subsystems and commands.
    private RobotContainer m_robotContainer;

    /**
     * This method is called when the robot is first started up.
     * Initialize subsystems, commands, and other robot-wide components here.
     */
    @Override
    public void robotInit() {
        // Instantiate the RobotContainer, which handles subsystem and command initialization.
        m_robotContainer = new RobotContainer();
    }

    /**
     * This method is called every robot packet, no matter the mode.
     * Use this for items like diagnostics that should run during all modes.
     */
    @Override
    public void robotPeriodic() {
        // Run the CommandScheduler to execute scheduled commands.
        CommandScheduler.getInstance().run();
    }

    /**
     * This method is called once each time the robot enters Teleop mode.
     * Initialize and schedule teleop-specific commands here.
     */
    @Override
    public void teleopInit() {
        // Retrieve the primary teleop command from RobotContainer.
        m_teleopCommand = m_robotContainer.getTeleopCommand();

        // Schedule the command if it is not null.
        if (m_teleopCommand != null) {
            m_teleopCommand.schedule();
        }
    }

    /**
     * This method is called periodically during Teleop mode.
     * Add periodic logic for Teleop here if needed.
     */
    @Override
    public void teleopPeriodic() {
        // Add periodic teleop-specific logic here if required.
    }

    /**
     * This method is called once each time the robot enters Autonomous mode.
     * Initialize and schedule autonomous-specific commands here.
     */
    @Override
    public void autonomousInit() {
        // Add autonomous initialization logic here if needed.
    }

    /**
     * This method is called periodically during Autonomous mode.
     * Add periodic logic for Autonomous here if needed.
     */
    @Override
    public void autonomousPeriodic() {
        // Add periodic autonomous-specific logic here if required.
    }

    /**
     * This method is called once each time the robot enters Test mode.
     * Use this to initialize test-specific logic.
     */
    @Override
    public void testInit() {
        // Add test initialization logic here if needed.
    }

    /**
     * This method is called periodically during Test mode.
     * Add periodic logic for Test here if needed.
     */
    @Override
    public void testPeriodic() {
        // Add periodic test-specific logic here if required.
    }
}
