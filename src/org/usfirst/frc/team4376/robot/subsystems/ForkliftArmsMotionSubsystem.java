package org.usfirst.frc.team4376.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;

import org.usfirst.frc.team4376.robot.Robot;
import org.usfirst.frc.team4376.robot.RobotMap;

 
/**
 *
 */ 
public class ForkliftArmsMotionSubsystem extends Subsystem {
	
	Talon forkliftArmsMotionMotor;
	boolean armsOpen = true;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public ForkliftArmsMotionSubsystem() {
		
		forkliftArmsMotionMotor = new Talon(RobotMap.forkliftArmsMotionMotor);
		
	}
	public void openArmsToLimit(){
		if(Robot.clawEncoder.get() > -50000){
			forkliftArmsMotionMotor.set(RobotMap.clawOpenSpeed);
		} else {
			forkliftArmsMotionMotor.set(0);
		}
	}
	
	public  void closeArmsToLimit(){
		if(Robot.clawEncoder.get() < 50000){
			forkliftArmsMotionMotor.set(RobotMap.clawCloseSpeed);
		} else {
			forkliftArmsMotionMotor.set(0);
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
	
	
	
	
	public void openArms(){
		if(Robot.clawPressureSensor.getVoltage() > .2){
			forkliftArmsMotionMotor.set(RobotMap.clawOpenSpeed);
		}
	}
	
	public void closeArms(){
		
		forkliftArmsMotionMotor.set(RobotMap.clawCloseSpeed);
	}
	
	public void restArms(){
		
		forkliftArmsMotionMotor.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

