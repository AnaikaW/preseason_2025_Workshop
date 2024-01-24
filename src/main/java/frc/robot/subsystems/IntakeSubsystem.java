package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import frc.robot.Constants;
import frc.robot.subsystems.TransitionSubsystem.TransitionStates;

public class IntakeSubsystem {

    public TalonFX intakeMotor;
    public TalonFX preTransitionMotor;
    private static double motorSpeed = 0.2; 

    public static enum IntakeStates {
        INTAKING,
        OFF;
    }

    public static IntakeStates intakeStates = IntakeStates.OFF;

    public IntakeSubsystem() {
        intakeMotor = new TalonFX(Constants.INTAKE_MOTOR_CAN_ID);
        preTransitionMotor = new TalonFX(Constants.PRE_TRANSITION_CAN_ID);
        init();

    }

    public void init() {
        System.out.println("Intake Init!");
        intakeMotor.setInverted(false); //sets it to default sending a piece up (counterclockwise)
        intakeMotor.setNeutralMode(NeutralModeValue.Brake); //brake mode so nothing slips = locks in place when not getting power
        preTransitionMotor.setInverted(false);
        preTransitionMotor.setNeutralMode(NeutralModeValue.Brake); //TODO check what direction we want motors to run
        setState(IntakeStates.OFF);
    }

    public void setState(IntakeStates newState){
        intakeStates = newState;
    }

    public void periodic() {
        if(intakeStates == IntakeStates.INTAKING) {
            intakeMotor.set(motorSpeed);
            preTransitionMotor.set(motorSpeed);

        } else {
            intakeMotor.set(0);
            preTransitionMotor.set(0);
        }

    }

}
