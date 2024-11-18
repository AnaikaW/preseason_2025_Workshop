// Package declaration. Replace "frc.robot.subsystems" with the appropriate package path for your project.
package frc.robot.subsystems;

// Import necessary libraries. Add or remove imports depending on your specific needs.
import edu.wpi.first.wpilibj.Servo; 
import edu.wpi.first.wpilibj2.command.SubsystemBase; 

// Import your constants file. Ensure it contains relevant constants such as SERVO_PWM_PORT.
import frc.robot.Constants;

/**
 * ServoSubsystem is responsible for controlling a servo motor. 
 * Customize this class based on your project's requirements.
 */
public class ServoSubsystem extends SubsystemBase {

    // Declare a Servo object. Replace "pen" with a name meaningful to your use case.
    private static Servo pen;

    // Define minimum and maximum angles for the servo. Adjust these values as needed.
    private static final double MIN_ANGLE = -48.0; // Replace with your minimum angle.
    private static final double MAX_ANGLE = 8.0;  // Replace with your maximum angle.
    
    /**
     * Constructor for ServoSubsystem.
     * Initializes the servo and sets its default angle. Update initialization logic as required.
     */
    public ServoSubsystem() {
        // Initialize the Servo object. Ensure Constants.SERVO_PWM_PORT is set correctly.
        pen = new Servo(Constants.SERVO_PWM_PORT);

        // Set the servo to its initial position (e.g., angle 0.0). Modify the default angle if needed.
        setAngle(0.0, false);
    }

    /**
     * Sets the angle of the servo, with optional inversion.
     * @param angle  The desired angle for the servo (within MIN_ANGLE and MAX_ANGLE).
     * @param invert If true, inverts the angle before setting it on the servo.
     */
    public void setAngle(double angle, boolean invert) {
        // Clamp the angle within the defined limits.
        if (angle > MAX_ANGLE) {
            angle = MAX_ANGLE;
        } else if (angle < MIN_ANGLE) {
            angle = MIN_ANGLE;
        }
        
        // Invert the angle if the invert parameter is true.
        if (invert) {
            angle = MAX_ANGLE - angle;
        }

        // Set the clamped (and optionally inverted) angle on the servo.
        pen.setAngle(angle);
    }

    /**
     * Gets the current angle of the servo, with optional inversion.
     * @param inverted If true, returns the inverted angle.
     * @return The current angle of the servo.
     */
    public double getAngle(boolean inverted) {
        // Retrieve the current angle of the servo.
        double angle = pen.getAngle();

        // Invert the angle if the inverted parameter is true.
        if (inverted) {
            angle = -angle + MAX_ANGLE;
        }

        // Return the adjusted angle.
        return angle;
    }
}
