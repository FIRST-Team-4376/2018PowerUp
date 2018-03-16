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

	// limit/pressure switch == analog port 3

	public static int frontLeftMotor = 0;
	public static int frontRightMotor = 1;

	public static int liftBotMotor = 4;
	public static int forkLiftUpDownMotorPort = 2;
	public static int cameraport = 23;
	public static int liftAntennaMotor = 5;
	public static int forkLiftOpenCloseMotorPort = 3;

	public static int gameControllerUsbDeviceNumber = 0;
	public static int leftDriveStickUsbDeviceNumber = 3;
	public static int rightDriveStickUsbDeviceNumber = 4;
	
	public static int ericDriveStick = 2;

	public static int gameControllerLeftStickYAxis = 1;
	public static int gameControllerRightStickYAxis = 3;

//	public static int ballDoorServoPort = 5;

	public static int clawEncoderA = 6;
	public static int clawEncoderB = 7;

	public static int forkliftMotionEncoderA = 4;
	public static int forkliftMotionEncoderB = 5;

	public static int driveLeftEncoderA = 0;
	public static int driveLeftEncoderB = 1;

	public static int driveRightEncoderA = 2;
	public static int driveRightEncoderB = 3;

	// analog PORTS //////////////////////////////////

	public static int clawLimitSwitchPort = 2;

	////////////// SPEEDS ////////////////
	public static double clawOpenSpeed = 1.0;
	public static double clawCloseSpeed = -1.0;
	public static double forkLiftUpSpeed = 1.0;
	public static double forkLiftDownSpeed = -1.0;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
