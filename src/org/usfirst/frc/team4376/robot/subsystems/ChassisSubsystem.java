package org.usfirst.frc.team4376.robot.subsystems;

import org.usfirst.frc.team4376.robot.Robot;
import org.usfirst.frc.team4376.robot.RobotMap;
import org.usfirst.frc.team4376.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *//////THIS IS WHAT WE'RE USING FOR DRIVE
 //*/
public class ChassisSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public RobotDrive chassis;  
	
	Joystick stick = new Joystick(RobotMap.driveStick);
	public boolean lastEncoderDirection = false;
	public int testCounter = 0;
	public int lastEncoderValue = 0;
	
	public ChassisSubsystem(){

		chassis = new RobotDrive(RobotMap.frontLeftMotor, RobotMap.backLeftMotor, RobotMap.frontRightMotor, RobotMap.backRightMotor);
//		lastEncoderValue = Robot.testEncoder.get();
//		lastEncoderDirection = Robot.testEncoder.getDirection();
	}
	
	public void driveMe(){
		
		// .5 is multiplying the axis value by half so it doesn't go too fast
		chassis.tankDrive(.5 *1, .5 * 3);
		System.out.println("get; " + Robot.testEncoder.get());
		System.out.println("getDistance; " + Robot.testEncoder.getDistance());
		System.out.println("getRaw; " + Robot.testEncoder.getRaw());
		System.out.println("getDirection; " + Robot.testEncoder.getDirection());
		System.out.println("GRYO Z: " + Robot.gyro.getAngleZ());
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new DriveCommand());
		
	}
}