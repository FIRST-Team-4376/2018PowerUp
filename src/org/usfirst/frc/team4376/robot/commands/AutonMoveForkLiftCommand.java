package org.usfirst.frc.team4376.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4376.robot.Robot;

/**
 *
 */
public class AutonMoveForkLiftCommand extends Command {
	double inches; 
	double targetAngle; 
	double marginOfError = 0.5;
	public AutonMoveForkLiftCommand(double inchesA) {
		inches = inchesA;   
		// Use requires() here to declare subsystem dependencies
		requires(Robot.chassis);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
//		double gyroAngle = Robot.gyro.getAngleZ();
//		double leftSpeed = 0.0;
//		
//		System.out.println("TURNING IN PLACE GYRO ANGLE: " + gyroAngle);
//		System.out.println("TURNING IN PLACE TARGET ANGLE: " + targetAngle);
//		
//		
//		if(gyroAngle > (targetAngle + marginOfError)) {
//			leftSpeed = -speed;
//		} else {
//			leftSpeed = speed;
//		}
//		Robot.chassis.tankDrive(leftSpeed, -leftSpeed);
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		double gyroAngle = Robot.gyro.getAngleZ();
		if(gyroAngle <= (targetAngle + marginOfError) && gyroAngle >= (targetAngle - marginOfError)){
			return true;
		} else {
			return false;
		}
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