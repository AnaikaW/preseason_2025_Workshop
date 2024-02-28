package frc.robot.subsystems;

// import com.ctre.phoenix.motorcontrol.can.TalonFX;
// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.ControlModeValue;
import com.ctre.phoenix6.controls.DutyCycleOut;

import frc.robot.Constants;
 

public class ShooterSubsystem {
    
    private final DutyCycleOut dutyCycleOut = new DutyCycleOut(0);
    
    private TalonFX high; 
    private TalonFX mid;
    private TalonFX low;

    private final double AMP_SPEED = 0.3; // DO NOT TOUCH THIS VALUE!!
    private final double LOW_SHOOTING_SPEED = 0.7;
    private final double HIGH_SPEAKER_SPEED = 0.8;
    private final double MID_SPEAKER_SPEED = 0.8;
    private final double LOW_INTAKING_SPEED = 0.18;
    
    public static enum ShooterStates {
        OFF,
        INTAKING,
        WARMUP, //for auto only
        AMP_HOLDING,
        SPEAKER_HOLDING,
        AMP,
        SPEAKER; 
    }

    private ShooterStates currentShooterState; //REVIEW: previously initialized to ShooterStates.AMP

    public ShooterSubsystem() {
        high = new TalonFX(Constants.SHOOTER_HIGH_CAN_ID);
        mid = new TalonFX(Constants.SHOOTER_MID_CAN_ID);
        low = new TalonFX(Constants.AMP_MOTOR_CAN_ID);
        
        init();
    }

    public void init(){
        high.setInverted(false); 
        mid.setInverted(false); 
        low.setInverted(true);
        high.setNeutralMode(NeutralModeValue.Brake);
        mid.setNeutralMode(NeutralModeValue.Brake);
        low.setNeutralMode(NeutralModeValue.Brake);
        currentShooterState = ShooterStates.OFF;
    }

    public void periodic(){
        System.out.println("CURRENT SHOOTER STATE: " + currentShooterState);
        if (currentShooterState == ShooterStates.INTAKING){
            high.setControl(dutyCycleOut.withOutput(0));
            mid.setControl(dutyCycleOut.withOutput(0));
            low.setControl(dutyCycleOut.withOutput(LOW_INTAKING_SPEED)); 
            //low.set(ControlMode.PercentOutput, AMP_SPEED);
        }else if (currentShooterState == ShooterStates.WARMUP){ //same as speaking holding but doesnt assume we have a note
            high.setControl(dutyCycleOut.withOutput(HIGH_SPEAKER_SPEED));
            mid.setControl(dutyCycleOut.withOutput(-MID_SPEAKER_SPEED)); //negative
            low.setControl(dutyCycleOut.withOutput(LOW_INTAKING_SPEED));  
        }else if (currentShooterState == ShooterStates.AMP_HOLDING) { // DO NOT TOUCH THESE VALUES!!
            high.setControl(dutyCycleOut.withOutput(-AMP_SPEED)); //negative
            mid.setControl(dutyCycleOut.withOutput(0));
            low.setControl(dutyCycleOut.withOutput(0));
        } else if(currentShooterState == ShooterStates.SPEAKER_HOLDING){
            high.setControl(dutyCycleOut.withOutput(HIGH_SPEAKER_SPEED));
            mid.setControl(dutyCycleOut.withOutput(-MID_SPEAKER_SPEED)); //negative
            low.setControl(dutyCycleOut.withOutput(0));
        }else if(currentShooterState == ShooterStates.AMP){ // DO NOT TOUCH THESE VALUES!!
            System.out.println("==========WE ARE SHOOTING IN AMP==========");
            high.setControl(dutyCycleOut.withOutput(-AMP_SPEED)); //negative
            mid.setControl(dutyCycleOut.withOutput(0)); // TODO: check if this is correct
            low.setControl(dutyCycleOut.withOutput(AMP_SPEED)); // TODO: might need a different value for amp shooting
        }else if(currentShooterState == ShooterStates.SPEAKER){
            System.out.println("==========WE ARE SHOOTING IN SPEAKER==========");
            high.setControl(dutyCycleOut.withOutput(HIGH_SPEAKER_SPEED));//TODO walk through logic
            mid.setControl(dutyCycleOut.withOutput(-MID_SPEAKER_SPEED)); //negative
            low.setControl(dutyCycleOut.withOutput(LOW_SHOOTING_SPEED));
        }else if(currentShooterState == ShooterStates.OFF){
            high.setControl(dutyCycleOut.withOutput(0));
            mid.setControl(dutyCycleOut.withOutput(0));
            low.setControl(dutyCycleOut.withOutput(0));
        }else{
            high.setControl(dutyCycleOut.withOutput(0));
            mid.setControl(dutyCycleOut.withOutput(0));
            low.setControl(dutyCycleOut.withOutput(0));
            System.out.println("====UNRECOGNIZED SHOOTER STATE!!!!!==== current shooter state: " + currentShooterState);
        }
    }

    public void setState(ShooterStates newState) {
        currentShooterState = newState;
    }
}