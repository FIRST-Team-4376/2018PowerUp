package org.usfirst.frc.team4376.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
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
		
		armLiftMotor.set(.5);
	}
	
	public void lowerArms(){
		
		armLiftMotor.set(-.5);
	}
	
	public void restArms(){
		
		armLiftMotor.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
