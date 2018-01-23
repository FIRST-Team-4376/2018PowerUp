package org.usfirst.frc.team4376.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import org.usfirst.frc.team4376.robot.RobotMap;

 
/**
 *
 */ 
public class LowerAntennaSubsystem extends Subsystem {
	
	Talon lowerAntennaMotor;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public LowerAntennaSubsystem() {
		
		lowerAntennaMotor = new Talon(RobotMap.lowerAntennaMotor);
		
	}
	
	public void liftBot(){
		
		lowerAntennaMotor.set(.5);
	}
	
	public void lowerBot(){
		
		lowerAntennaMotor.set(-.5);
	}
	
	public void restBot(){
		
		lowerAntennaMotor.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

