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
	Joystick gameController = new Joystick(RobotMap.gameControllerUsbDeviceNumber);
	Joystick leftDriveStick = new Joystick(RobotMap.leftDriveStickUsbDeviceNumber);
	Joystick rightDriveStick = new Joystick(RobotMap.rightDriveStickUsbDeviceNumber);
	Joystick ericDriveStick = new Joystick(RobotMap.ericDriveStick);
	public boolean lastEncoderDirection = false;
	public int testCounter = 0;
	public ChassisSubsystem(){

		chassis = new RobotDrive(RobotMap.frontLeftMotor, RobotMap.frontRightMotor);
//		chassis = new RobotDrive(RobotMap.leftMotor, RobotMap.rightMotor);
//		lastEncoderValue = Robot.testEncoder.get();
//		lastEncoderDirection = Robot.testEncoder.getDirection();
	}

	public void driveStraightAtAngle(double targetAngle, double speed){
		double turnFactor = 1.3;
		double gyroAngle = Robot.gyro.getAngleZ();
		if(gyroAngle <= (targetAngle+1) && gyroAngle >= (targetAngle-1)){
			Robot.chassis.tankDrive(speed, speed); //Bot drives straight
		} else if(gyroAngle > (targetAngle+1.0)) {
			Robot.chassis.tankDrive(speed, speed * turnFactor); //Turn bot to the left
		} else {
			Robot.chassis.tankDrive(speed * turnFactor, speed); //Turn bot to the right
		}
	}
	
	public void driveMe(){
		
		//////////////////// ONLY 1 OF THE FOLLOWING TWO SECTIONS CAN BE UN-COMMENTED ///////////////////////////////////////////
		
		 // Section 1 -> Use the two sticks on the Logitech game controller as tank drive inputs
		 // double leftjoystickY = gameController.getRawAxis(RobotMap.gameControllerLeftStickYAxis);
		 // double rightjoystickY = gameController.getRawAxis(RobotMap.gameControllerRightStickYAxis);

		
		// Section 2 -> Use dual separate full-sized joysticks as tank drive inputs
		double leftjoystickY = ericDriveStick.getRawAxis(1);
		double rightjoystickY = ericDriveStick.getRawAxis(5);

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



		// .5 is multiplying the axis value by half so it doesn't go too fast
		chassis.tankDrive(-.75 * leftjoystickY, -.75 * rightjoystickY);
//		System.out.println("Fork Lift Position: " + Robot.forkliftPositionEncoder.get());
//		System.out.println("Fork Lift Position RAW: " + Robot.forkliftPositionEncoder.getRaw());
//		System.out.println("Fork Lift Position GET DISTANCE: " + Robot.forkliftPositionEncoder.getDistance());
//		System.out.println("Claw Pressure Sensor Voltage: " + Robot.clawPressureSensor.getVoltage());
//		System.out.println("Claw Pressure Sensor Value: " + Robot.clawPressureSensor.getValue());
//		if (Robot.clawPressureSensor.get()){
//			System.out.println("Claw Pressure Sensor Digital: TRUE" );
//		} else { System.out.println("Claw Pressure Sensor Digital: FALSE" ); }
		
		System.out.println("LEFT Drive Motor Position: " + Robot.driveMotorL.get());
		System.out.println("RIGHT Drive Motor Position: " + Robot.driveMotorR.get());
		System.out.println("FORKLIFT Position: " + Robot.forkliftPositionEncoder.get());
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
