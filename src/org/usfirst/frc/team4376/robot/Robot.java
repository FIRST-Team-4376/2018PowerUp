
package org.usfirst.frc.team4376.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team4376.robot.commands.AutonDriveStraightTimeBased;
import org.usfirst.frc.team4376.robot.commands.AutonLeft;
import org.usfirst.frc.team4376.robot.commands.AutonRight;
import org.usfirst.frc.team4376.robot.commands.BasicAutonCommand;
import org.usfirst.frc.team4376.robot.commands.ExampleAuton;
import org.usfirst.frc.team4376.robot.commands.TestAuton;
import org.usfirst.frc.team4376.robot.commands.TestAutonRightScale;
import org.usfirst.frc.team4376.robot.subsystems.ChassisSubsystem;
import org.usfirst.frc.team4376.robot.subsystems.LiftAntennaSubsystem;
import org.usfirst.frc.team4376.robot.subsystems.LiftSubsystem;
import org.usfirst.frc.team4376.robot.subsystems.PidTurnToAngleSubsystem;
import org.usfirst.frc.team4376.robot.subsystems.PidDriveStraightSubsystem;
import org.usfirst.frc.team4376.robot.subsystems.ForkLiftSubsystem;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team4376.sensorlib.ADIS16448_IMU;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ChassisSubsystem chassis = new ChassisSubsystem();
	public static final PidTurnToAngleSubsystem pidTurnToAngle = new PidTurnToAngleSubsystem();
	public static final PidDriveStraightSubsystem pidDriveStraight = new PidDriveStraightSubsystem();
	public static OI oi;
	public static final LiftSubsystem liftBot = new LiftSubsystem();
	public static final LiftAntennaSubsystem liftAntenna = new LiftAntennaSubsystem();
	public static final ForkLiftSubsystem forkLiftSubsystem = new ForkLiftSubsystem();
	public static Encoder clawEncoder = new Encoder(RobotMap.clawEncoderA, RobotMap.clawEncoderB, true, Encoder.EncodingType.k4X);
	public static Encoder driveMotorL = new Encoder(RobotMap.driveLeftEncoderA, RobotMap.driveLeftEncoderB, true, Encoder.EncodingType.k4X);
	public static Encoder driveMotorR = new Encoder(RobotMap.driveRightEncoderA, RobotMap.driveRightEncoderB, true, Encoder.EncodingType.k4X);
    public static Encoder forkliftPositionEncoder =  new Encoder(RobotMap.forkliftMotionEncoderA, RobotMap.forkliftMotionEncoderB, true, Encoder.EncodingType.k4X);
//    public static DigitalInput clawPressureSensor = new DigitalInput(RobotMap.clawLimitSwitchPort);
    public static AnalogInput clawPressureSensor = new AnalogInput(RobotMap.clawLimitSwitchPort);
	public static ADIS16448_IMU gyro;

	public static String gameData;
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
//		chooser.addDefault("Cross Grey Line Time Based", new AutonDriveStraightTimeBased());
		chooser.addDefault("Cross Grey Line Time Based", new AutonDriveStraightTimeBased());
		
		chooser.addDefault("Left Starting Position", new AutonLeft());
		chooser.addObject("Right Starting Position", new AutonRight());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
		gyro = new ADIS16448_IMU();
		gyro.reset();
		gyro.calibrate();
		Timer timer = new Timer();
		forkliftPositionEncoder.reset();
		timer.reset();
		// some sort of way timing the cameras functionality
		// Disabled mode.
		// * You can use it to reset any subsystem information you want to
	}

	/**
	 * This function is called once each time the robot enters clear when the
	 * robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		SmartDashboard.putString("autonGameData", DriverStation.getInstance().getGameSpecificMessage());
//		gameData = DriverStation.getInstance().getGameSpecificMessage();
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
