package org.usfirst.frc.team4376.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4376.robot.Robot;

/**
 *
 */
public class AutonDriveStraightTimeBased extends Command {
	
	private Timer timer;
	public double startingGyroAngle;
	public double startingTimerValue;
	
	public AutonDriveStraightTimeBased() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.chassis);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		timer = new Timer();
		timer.reset();
		timer.start();
		startingTimerValue = timer.get();
		Robot.gyro.calibrate();
		Robot.gyro.reset();
		startingGyroAngle = Robot.gyro.getAngleZ();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double timerValue = Math.abs(timer.get()) - Math.abs(startingTimerValue) ;
		System.out.println("AUTON - " + timerValue);
		if(timerValue > 0.0 && timerValue <= 6.0){
			Robot.chassis.driveStraightAtAngle(startingGyroAngle, .5);
		}
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
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
