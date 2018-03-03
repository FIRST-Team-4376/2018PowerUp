package org.usfirst.frc.team4376.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4376.robot.Robot;

/**
 *
 */
public class AutonRaiseForkliftCommand extends Command {
  public double speed; 
  public double duration;
  private Timer timer;

  public AutonRaiseForkliftCommand(double speedA, double numberOfSeconds) {
    speed = speedA;  
    duration = numberOfSeconds;
    // Use requires() here to declare subsystem dependencies
    requires(Robot.chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
	timer = new Timer();
    timer.reset();
    timer.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
	  System.out.println("duration " + duration);
	  System.out.println("forklift raise  auton timer " + timer.get());
    if( timer.get() > 0.0 && timer.get() < duration){
      Robot.forkLiftSubsystem.liftArms(speed);
    } else {
    	Robot.forkLiftSubsystem.restUpDownArms();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected  boolean isFinished() {
    return timer.get() > duration;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
	  Robot.forkLiftSubsystem.restUpDownArms();

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
	  end();

  }
}
