package org.usfirst.frc.team4376.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;

import org.usfirst.frc.team4376.robot.Robot;
import org.usfirst.frc.team4376.robot.RobotMap;

 
/**
 *
 */ 
public class ForkLiftSubsystem extends Subsystem {
	
	Talon forkLiftOpenCloseMotor;
	Talon forkLiftUpDownMotor;
	boolean armsOpen = true;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public ForkLiftSubsystem() {
		
		forkLiftOpenCloseMotor = new Talon(RobotMap.forkLiftOpenCloseMotorPort);
		forkLiftUpDownMotor = new Talon(RobotMap.forkLiftUpDownMotorPort);
		
	}
	public void openArmsToLimit(){
		if(Robot.clawEncoder.get() > -50000){
			forkLiftOpenCloseMotor.set(RobotMap.clawOpenSpeed);
		} else {
			forkLiftOpenCloseMotor.set(0);
		}
	}
	
	public  void closeArmsToLimit(){
		if(Robot.clawEncoder.get() < 50000){
			forkLiftOpenCloseMotor.set(RobotMap.clawCloseSpeed);
		} else {
			forkLiftOpenCloseMotor.set(0);
		}
	}
	
	public void recordArmsPosition(){
		if(armsOpen == true ){
			armsOpen = false;
		} else {
			armsOpen = true;
		}
	}
	
//	public void moveArms(){
//		if (Robot.clawPressureSensor.getVoltage() < 3){
//			recordArmsPosition();
//		}
//		if (armsOpen == true){
//			openArms();
//		} else {
//			closeArms();
//		}
//	}
	
	
	
	public void openArms(double speed){
		speed = Math.abs(speed);
		if (RobotMap.clawOpenSpeed < 0){
			speed = Math.abs(speed) * -1;
		}
		if(Robot.clawPressureSensor.getVoltage() > .2){
			forkLiftOpenCloseMotor.set(speed);
		}
	}
	
	public void closeArms(double speed){
		speed = Math.abs(speed);
		if (RobotMap.clawCloseSpeed < 0){
			speed = Math.abs(speed) * -1;
		}
		forkLiftOpenCloseMotor.set(speed);
	}
	
	public void openArms(){
		openArms(RobotMap.clawOpenSpeed);
	}
	
	public void closeArms(){
		closeArms(RobotMap.clawCloseSpeed);
	}
	
	public void restOpenCloseArms(){
		
		forkLiftOpenCloseMotor.set(0);
	}

	public void restUpDownArms(){
		
		forkLiftUpDownMotor.set(0);
	}

	public void brakeUpDownArms(){
		forkLiftUpDownMotor.set(.3);
	}

	public void liftArms(double speed){
		forkLiftUpDownMotor.set(speed);
	}

	public void lowerArms(double speed){
		forkLiftUpDownMotor.set(speed);
	}
	
	public void moveUpDownArms(double speed){
		forkLiftUpDownMotor.set(speed);
	}

	public void liftArms(){
		
		forkLiftUpDownMotor.set(RobotMap.forkLiftUpSpeed);
	}
	
	public void lowerArms(){
		
		forkLiftUpDownMotor.set(RobotMap.forkLiftDownSpeed);
	}

	public void liftArmsToLimit(){
		if(Robot.forkliftPositionEncoder.get() > -4450){
			liftArms();
		} else {
			restUpDownArms();
		}
	}
	
	public void lowerArmsToLimit(){
		if(Robot.forkliftPositionEncoder.get() <= -60){
			lowerArms();
		} else {
			restUpDownArms();
		}
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

