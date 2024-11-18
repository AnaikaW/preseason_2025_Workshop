// Package declaration.
package frc.robot.commands;

// Import necessary libraries.
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.ServoSubsystem;

// note: ServoControlCommand is a command that sets a specific angle on a servo subsystem.
public class ServoCommand extends InstantCommand {

    // Reference to the ServoSubsystem
    // your code

    // make a variable for the angle to set the servo to (should be private and final).
    // your code

    // note: Constructor for ServoControlCommand.
    // @param servoSubsystem The ServoSubsystem to control.
    // @param servoAngle The angle to set on the servo when the command is executed.
    public ServoCommand(ServoSubsystem servoSubsystem, double servoAngle) {
        // Assign the provided ServoSubsystem and servoAngle to class variables.
        // your code
        // your code

        // Declare that this command requires the ServoSubsystem, using the addRequirements() method.
        // your code
    }

    // note: Called when the command is executed. 
    // This method contains the logic for controlling the servo.
    @Override
    public void execute() {
        // Set the servo to a specific angle. 
        // your code
    }
}
