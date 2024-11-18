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
    private static Servo pen;

    // Define minimum and maximum angles for the servo (for our purposes these can be whatever you want)
    private static final double MIN_ANGLE = -48.0; 
    private static final double MAX_ANGLE = 8.0; 
    
    // note: Constructor for ServoSubsystem. Initializes the servo and sets its default angle. 
    public ServoSubsystem() {
        // Initialize the Servo object.
        pen = new Servo(Constants.SERVO_PWM_PORT);

        // Set the servo to its initial position (0.0).
        setAngle(0.0, false);
    }

    // Sets the angle of the servo, with optional inversion.
    // @param angle  The desired angle for the servo (within min and max angles).
    // @param invert If true, inverts the angle before setting it on the servo. 
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

    // Gets the current angle of the servo, with optional inversion.
    // @param inverted If true, returns the inverted angle.
    // @return The current angle of the servo.
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
