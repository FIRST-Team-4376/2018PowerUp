package org.usfirst.frc.team4376.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import org.usfirst.frc.team4376.robot.RobotMap;

 
/**
 *
 */ 
public class ForkliftArmsMotionSubsystem extends Subsystem {
	
	Talon forkliftArmsMotionMotor;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public ForkliftArmsMotionSubsystem() {
		
		forkliftArmsMotionMotor = new Talon(RobotMap.forkliftArmsMotionMotor);
		
	}
	
	public void liftBot(){
		
		forkliftArmsMotionMotor.set(.5);
	}
	
	public void lowerBot(){
		
		forkliftArmsMotionMotor.set(-.5);
	}
	
	public void restBot(){
		
		forkliftArmsMotionMotor.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

