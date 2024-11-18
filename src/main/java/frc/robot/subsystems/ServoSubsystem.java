// Package declaration.
package frc.robot.subsystems;

// Import necessary libraries. 
import edu.wpi.first.wpilibj.Servo; 
import edu.wpi.first.wpilibj2.command.SubsystemBase; 

// Import your constants file. 
import frc.robot.Constants;

// note: ServoSubsystem is responsible for controlling a servo motor. 
public class ServoSubsystem extends SubsystemBase {

    // Declare a Servo object.
    // your code

    // Define minimum and maximum angles for the servo (for our purposes these can be whatever you want)
    // your code
    // your code
    
    // note: Constructor for ServoSubsystem. Initializes the servo and sets its default angle. 
    public ServoSubsystem() {
        // Initialize the Servo object.
        // your code

        // Set the servo to its initial position (0.0).
        // your code
    }

    // Sets the angle of the servo, with optional inversion.
    // @param angle  The desired angle for the servo (within min and max angles).
    // @param invert If true, inverts the angle before setting it on the servo. 
    public void setAngle(double angle, boolean invert) {
        // Clamp the angle within the defined limits.
        if /*your code*/ {
            // your code
        } else if /* your code */ {
            // your code
        }
        
        // Invert the angle if the invert parameter is true.
        if (invert) {
            // your code
        }

        // Set the clamped (and optionally inverted) angle on the servo.
        // your code
    }

    // Gets the current angle of the servo, with optional inversion.
    // @param inverted If true, returns the inverted angle.
    // @return The current angle of the servo.
    // write this full method
 
    // your code
}
