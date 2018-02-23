package org.usfirst.frc.team4376.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import org.usfirst.frc.team4376.robot.RobotMap;


/**
 *
 */
public class LiftSubsystem extends Subsystem {

	Talon liftBotMotor;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public LiftSubsystem() {
		liftBotMotor = new Talon(RobotMap.liftBotMotor);

	}



	public void liftBot(){

		liftBotMotor.set(.5);
	}

	public void lowerBot(){

		liftBotMotor.set(-.5);
	}

	public void restBot(){

		liftBotMotor.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
