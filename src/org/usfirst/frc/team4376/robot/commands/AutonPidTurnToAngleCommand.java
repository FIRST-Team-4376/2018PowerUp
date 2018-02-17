package org.usfirst.frc.team4376.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4376.robot.Robot;

/**
 *
 */
public class AutonPidTurnToAngleCommand extends Command {
	double speed; 
	double targetAngle; 
	double marginOfError = 1.0;
	public AutonPidTurnToAngleCommand(double angleA) {
		targetAngle = angleA; 
		// Use requires() here to declare subsystem dependencies
		requires(Robot.chassis);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.gyro.reset();
		Robot.pidTurnToAngle.setOutputRange(-.8, .8);
		Robot.pidTurnToAngle.setSetpoint(targetAngle);
		Robot.pidTurnToAngle.setAbsoluteTolerance(marginOfError);
		Robot.pidTurnToAngle.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
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
		Robot.pidTurnToAngle.disable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.pidTurnToAngle.disable();
	}
}
