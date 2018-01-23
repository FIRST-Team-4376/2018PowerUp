package org.usfirst.frc.team4376.robot.subsystems;

import org.usfirst.frc.team4376.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *//////THIS IS WHAT WE'RE USING FOR DRIVE
 //*/
public class ExampleSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public RobotDrive chassis;  
	
	Joystick stick = new Joystick(RobotMap.driveStick);
	
	public ExampleSubsystem(){
		chassis = new RobotDrive(RobotMap.frontLeftMotor, RobotMap.backLeftMotor, RobotMap.frontRightMotor, RobotMap.backRightMotor);
	}
	
public void driveMe(){
		
		// .5 is multiplying the axis value by half so it doesn't to go too fast
		chassis.tankDrive(.5 *1, .5 * 3);
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
