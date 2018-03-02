package org.usfirst.frc.team4376.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4376.robot.Robot;

/**
 *
 */
public class AutonPidDriveStraightCommand extends Command {
	double speed; 
	double targetDistance; 
	double marginOfError = 10;
	public AutonPidDriveStraightCommand(double distanceInches) {
		targetDistance = distanceInches * 19.1;
		// Use requires() here to declare subsystem dependencies
		requires(Robot.chassis);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.driveMotorR.reset();
		Robot.gyro.reset();
		Robot.pidDriveStraight.setOutputRange(-.5, .5);
		Robot.pidDriveStraight.setSetpoint(targetDistance);
		Robot.pidDriveStraight.setAbsoluteTolerance(marginOfError);
		Robot.pidDriveStraight.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if ((targetDistance - marginOfError) < Robot.driveMotorR.get() &&
				Robot.driveMotorR.get() < (targetDistance + marginOfError)){
			return true;
		} else { return false; }
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.pidDriveStraight.disable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.pidDriveStraight.disable();
	}
}
