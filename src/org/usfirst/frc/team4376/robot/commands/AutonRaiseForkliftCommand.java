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
  public Timer timer;

  public AutonRaiseForkliftCommand(double speedA, double numberOfSeconds) {
    speed = speedA;  
    duration = numberOfSeconds;
    timer = new Timer();
    // Use requires() here to declare subsystem dependencies
    requires(Robot.chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    timer.reset();
    timer.start();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if( timer.get() <= duration){
      Robot.forkLiftSubsystem.liftArms(speed);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected  boolean isFinished() {
    return timer.get() >= duration;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    timer.stop();
    timer.reset();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    timer.stop();
    timer.reset();
  }
}
