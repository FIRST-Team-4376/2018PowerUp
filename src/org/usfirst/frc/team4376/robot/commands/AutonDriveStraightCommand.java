package org.usfirst.frc.team4376.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4376.robot.Robot;

/**
 *
 */
public class AutonDriveStraightCommand extends Command {
	double speed; 
	double targetAngle; 
	double targetDistance;
	double encoderCountsPerInch = 19.1;
	public AutonDriveStraightCommand(double speedA, double distanceInches) {
		speed = speedA;  
		targetDistance = distanceInches * encoderCountsPerInch; 
		// Use requires() here to declare subsystem dependencies
		requires(Robot.chassis);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.driveMotorL.reset();
		targetAngle = Robot.gyro.getAngleZ();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		System.out.println("Drive Straight Auton Encoder Value: " + Robot.driveMotorL.get());
		double gyroAngle = Robot.gyro.getAngleZ();
		System.out.println("DRIVE STRAIGHT GYRO ANGLE: " + gyroAngle);
		System.out.println("DRIVE STRAIGHT TARGET ANGLE: " + targetAngle);
		double turnFactor = 1.3;
		double marginOfError = 0.5;
        
		if(gyroAngle <= (targetAngle+marginOfError) && gyroAngle >= (targetAngle-marginOfError)){
			Robot.chassis.tankDrive(speed, speed); //Bot drives straight
		} else if(gyroAngle > (targetAngle+marginOfError)) {
			Robot.chassis.tankDrive(speed, speed * turnFactor); //Turn bot to the left
		} else {
			Robot.chassis.tankDrive(speed * turnFactor, speed); //Turn bot to the right
		}
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected  boolean isFinished() {
		return Robot.driveMotorL.get() >= targetDistance;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}