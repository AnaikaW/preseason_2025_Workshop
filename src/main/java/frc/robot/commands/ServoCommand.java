// Package declaration. Replace "frc.robot.commands" with the appropriate package path for your project.
package frc.robot.commands;

// Import necessary libraries. Add or remove imports depending on your specific needs.
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.ServoSubsystem;

/**
 * ServoControlCommand is a command that sets a specific angle on a servo subsystem.
 * Customize this class to suit the functionality you require.
 */
public class ServoCommand extends InstantCommand {

    // Reference to the ServoSubsystem. Replace with the appropriate subsystem if needed.
    private final ServoSubsystem servoSubsystem;

    // The angle to set the servo to. Adjust its use or make it configurable as per your needs.
    private final double servoAngle;

    /**
     * Constructor for ServoControlCommand.
     * @param servoSubsystem The ServoSubsystem to control.
     * @param servoAngle The angle to set on the servo when the command is executed.
     */
    public ServoCommand(ServoSubsystem servoSubsystem, double servoAngle) {
        // Assign the provided ServoSubsystem and servoAngle to class variables.
        this.servoSubsystem = servoSubsystem;
        this.servoAngle = servoAngle;

        // Declare that this command requires the ServoSubsystem.
        addRequirements(servoSubsystem);
    }

    /**
     * Called when the command is executed.
     * This method contains the logic for controlling the servo.
     */
    @Override
    public void execute() {
        // Set the servo to a specific angle. Replace "20" and "false" with the desired logic.
        servoSubsystem.setAngle(servoAngle, false);

        // Print a message to the console for debugging or testing purposes.
        System.out.println("Servo angle set to: " + servoAngle);
    }
}
