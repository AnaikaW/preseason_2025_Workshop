// Package declaration. Replace "frc.robot" with the appropriate package path for your project.
package frc.robot;

// Import necessary libraries. Add or remove imports depending on your specific needs.
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.ServoCommand;
import frc.robot.subsystems.ServoSubsystem;

/**
 * The RobotContainer class is responsible for initializing subsystems and commands, 
 * as well as mapping user inputs to command execution.
 */
public class RobotContainer {

    // Declare the ServoSubsystem. Replace with additional subsystems as needed.
    private static final ServoSubsystem m_servosub = new ServoSubsystem();

    /**
     * Constructor for RobotContainer.
     * Use this to initialize subsystems, configure button bindings, and set default commands.
     */
    public RobotContainer() {
        // Add button bindings or default command setups here if required.
    }

    /**
     * Provides the command to be executed during the Teleop mode.
     * Customize this method to return the desired teleop command.
     * @return The command to be run in teleop.
     */
    public Command getTeleopCommand() {
        // Create and return a new instance of ServoControlCommand, setting the servo to 50 degrees.
        // Replace "50" with the desired default angle or logic for your application.
        return new ServoCommand(m_servosub, 50);
    }
}
