package org.usfirst.frc.team4376.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4376.robot.Robot;

/**
 *
 */
public class AutonPidMoveForkliftUpDownCommand extends Command {
	double speed; 
	double targetDistance; 
	double marginOfError = 7;
	public AutonPidMoveForkliftUpDownCommand(double distanceInches) {
		targetDistance = distanceInches * 19.1;
		speed = .5;
		// Use requires() here to declare subsystem dependencies
		requires(Robot.chassis);
	}
	
	public AutonPidMoveForkliftUpDownCommand(double distance, double maxSpeed) {
		targetDistance = distance;
		speed = maxSpeed;
		// Use requires() here to declare subsystem dependencies
		requires(Robot.chassis);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.forkliftPositionEncoder.reset();
		Robot.driveMotorR.reset();
		Robot.gyro.reset();
		Robot.pidForklift.setOutputRange(-speed, speed);
		Robot.pidForklift.setSetpoint(targetDistance);
		Robot.pidForklift.setAbsoluteTolerance(marginOfError);
		Robot.pidForklift.enable();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if ((targetDistance - marginOfError) < Robot.forkliftPositionEncoder.get() &&
				Robot.forkliftPositionEncoder.get() < (targetDistance + marginOfError)){
			return true;
		} else { return false; }
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.pidForklift.disable();
		Robot.pidForklift.free();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
