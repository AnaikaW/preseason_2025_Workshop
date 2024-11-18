// Package declaration
package frc.robot;

// Import necessary libraries.
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.ServoCommand;
import frc.robot.subsystems.ServoSubsystem;

// note: The RobotContainer class is responsible for initializing subsystems and commands, as well as mapping user inputs to command execution.
public class RobotContainer {

    // Declare the ServoSubsystem. Replace with additional subsystems as needed.
    private static final ServoSubsystem m_servosub = new ServoSubsystem();

    // note: This is the constructor for RobotContainer. Use this to initialize subsystems, configure button bindings, and set default commands.
    public RobotContainer() {
        // leave blank, but normally this is where you add button bindings or default command setups
    }

    // note: Provides the command to be executed during Teleop.
    // return The command to be run in teleop.
    public Command getTeleopCommand() {
        // Create and return a new instance of ServoControlCommand, setting the servo to 90 degrees.
        return new ServoCommand(m_servosub, 50);
    }
}
