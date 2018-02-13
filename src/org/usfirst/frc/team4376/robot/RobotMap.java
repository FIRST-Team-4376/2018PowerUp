package org.usfirst.frc.team4376.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	public static int frontLeftMotor = 0;
	public static int backLeftMotor = 1;
	public static int frontRightMotor = 2;
	public static int backRightMotor = 3;
    
	public static int liftBotMotor = 8;
	public static int armLiftMotor = 7;
    public static int cameraport = 23; 
	public static int liftAntennaMotor = 6;
	public static int forkliftArmsMotionMotor = 9;

	public static int driveStick = 0;

public static int ballDoorServoPort = 5;

public static int forkliftEncoderA = 3; 
public static int forkliftEncoderB = 4; 

public static int driveLeftEncoderA = 0; 
public static int driveLeftEncoderB = 1; 


public static int driveRightEncoderA = 5; 
public static int driveRightEncoderB = 6; 

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
