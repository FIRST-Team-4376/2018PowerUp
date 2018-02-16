package org.usfirst.frc.team4376.robot.subsystems;
import org.usfirst.frc.team4376.robot.OI;

import org.usfirst.frc.team4376.robot.Robot;
import org.usfirst.frc.team4376.robot.RobotMap;
import org.usfirst.frc.team4376.robot.commands.DriveCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

 //////THIS IS WHAT WE'RE USING FOR DRIVE
 //*/
public class ChassisSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public RobotDrive chassis;
	public int lastEncoderValue = 0;
	Joystick stick = new Joystick(RobotMap.driveStick);
	public boolean lastEncoderDirection = false;
	public int testCounter = 0;
	public ChassisSubsystem(){
         
		chassis = new RobotDrive(RobotMap.frontLeftMotor, RobotMap.frontRightMotor);
//		chassis = new RobotDrive(RobotMap.leftMotor, RobotMap.rightMotor);
//		lastEncoderValue = Robot.testEncoder.get();
//		lastEncoderDirection = Robot.testEncoder.getDirection(); 
	}

	public void driveMe(){
		double leftjoystickY = stick.getRawAxis(RobotMap.driveStickAxis1);
		double rightjoystickY = stick.getRawAxis(RobotMap.driveStickAxis2);   
		// .5 is multiplying the axis value by half so it doesn't go too fast
		chassis.tankDrive(-.75 * leftjoystickY, -.75 * rightjoystickY);
		System.out.println("get; " + Robot.forkliftEncoder.get());
		System.out.println("getDistance; " + Robot.forkliftEncoder.getDistance());
		System.out.println("getRaw; " + Robot.forkliftEncoder.getRaw());
		System.out.println("getDirection; " + Robot.forkliftEncoder.getDirection());
		System.out.println("GRYO Z: " + Robot.gyro.getAngleZ());
		}
	public void tankDrive(double leftSpeed, double rightSpeed){
		chassis.tankDrive(leftSpeed, rightSpeed);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new DriveCommand());

	}
}
