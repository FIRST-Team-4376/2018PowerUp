package org.usfirst.frc.team4376.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;

import org.usfirst.frc.team4376.robot.Robot;
import org.usfirst.frc.team4376.robot.RobotMap;


/**
 *
 */
public class ForkliftArmsSubsystem extends Subsystem {
	
	Talon armLiftMotor;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public ForkliftArmsSubsystem() {
		
		armLiftMotor = new Talon(RobotMap.armLiftMotor);
		
	}
	
	public void liftArms(){
		
		armLiftMotor.set(1.0);
	}
	
	public void liftArmsToLimit(){
		if(Robot.forkliftPositionEncoder.get() > -4450){
			liftArms();
		} else {
			restArms();
		}
	}
	
	public void lowerArmsToLimit(){
		if(Robot.forkliftPositionEncoder.get() <= -60){
			lowerArms();
		} else {
			restArms();
		}
	} 
	
	public void lowerArms(){
		
		armLiftMotor.set(-1.0);
	}
	
	public void restArms(){
		
		armLiftMotor.set(0);
	}
	
	public void brakeArms(){
		armLiftMotor.set(.3);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

