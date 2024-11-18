// Package declaration. 
package frc.robot;

// Import necessary libraries.
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

// note: The Robot class serves as the main entry point for the robot program. It manages the cycle of the robot and coordinates subsystems and commands.
public class Robot extends TimedRobot {

    // Declare commands (just teleopcommand) to manage during different robot states. 
    // your code

    // Declare the RobotContainer, which sets up subsystems and commands.
    // your code

    //note: This method is called when the robot is first started up.
    //Initialize subsystems, commands, and other robot-wide components here.
    @Override
    public void robotInit() {
        // Instantiate the RobotContainer, which handles subsystem and command initialization.
        // your code
    }

    // note: This method is called every robot packet, no matter the mode. Use this for items like diagnostics that should run during all modes.
    @Override
    public void robotPeriodic() {
        // Run the CommandScheduler to execute scheduled commands.
        // your code
    }

    // note: This method is called once each time the robot enters Teleop mode.
    // Initialize and schedule teleop-specific commands here.
    @Override
    public void teleopInit() {
        // Retrieve the primary teleop command from RobotContainer.
        // your code

        // Schedule the command if it is not null.
        if ( /* your code */) {
            // your code
        }
    }

    // note: This method is called periodically during Teleop mode.
    @Override
    public void teleopPeriodic() {
        // leave blank, but this is where periodic teleop-specific logic would go.
    }

    // note: This method is called once each time the robot enters Autonomous mode.
    //Initialize and schedule autonomous-specific commands here.
    @Override
    public void autonomousInit() {
        // leave blank, but this is where autonomous initialization logic would go 
    }
    
    // note: This method is called periodically during Auto.
    @Override
    public void autonomousPeriodic() {
        // leave blank, but periodic autonomous-specific logic would go here.
    }


    @Override
    public void testInit() {}
    
    @Override
    public void testPeriodic() {}
}
