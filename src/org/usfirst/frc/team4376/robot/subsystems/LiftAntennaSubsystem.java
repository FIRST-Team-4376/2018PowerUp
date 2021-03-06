package org.usfirst.frc.team4376.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import org.usfirst.frc.team4376.robot.RobotMap;

 
/**
 *
 */ 
public class LiftAntennaSubsystem extends Subsystem {
	
	Talon liftAntennaMotor;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public LiftAntennaSubsystem() {
		
		liftAntennaMotor = new Talon(RobotMap.liftAntennaMotor);
		
	}
	
	public void liftAntenna(){
		
		liftAntennaMotor.set(11.0);
	}
	
	public void lowerAntenna(){
		
		liftAntennaMotor.set(-11.0);
	}
	
	public void restAntenna(){
		
		liftAntennaMotor.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

