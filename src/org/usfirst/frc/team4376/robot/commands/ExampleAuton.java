package org.usfirst.frc.team4376.robot.commands;

import org.usfirst.frc.team4376.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;


public class ExampleAuton extends Command {
	private Timer timer;
	
    public ExampleAuton() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer = new Timer();
    	Robot.gyro.calibrate();
    	timer.reset();
    	Robot.gyro.reset();
    	timer.start();
    }

		public void driveStraightAtAngle(double speed, double targetAngle){
			double gyroAngle = Robot.gyro.getAngleZ();
			System.out.println("DRIVE STRAIGHT GYRO ANGLE: " + gyroAngle);
			double turnFactor = 10;
            
			if(gyroAngle <= (targetAngle+2) && gyroAngle >= (targetAngle-2)){
				Robot.chassis.tankDrive(speed, speed); //Bot drives straight
			} else if(gyroAngle > (targetAngle+2.0)) {
				Robot.chassis.tankDrive(speed, speed * turnFactor); //Turn bot to the left
			} else {
				Robot.chassis.tankDrive(speed * turnFactor, speed); //Turn bot to the right
			}
		}

		public void turnLeft(double speed, double targetAngle){
			double gyroAngle = Robot.gyro.getAngleZ();
			double leftspeed = 0.0;
			System.out.println("TURNING LEFT GYRO ANGLE: " + gyroAngle);
			
		  if( gyroAngle > targetAngle ){leftspeed = -speed; }
			else if( gyroAngle < targetAngle){leftspeed = speed;}
			else{ leftspeed = 0.0; }
			Robot.chassis.tankDrive(leftspeed, -leftspeed);
		}
		
		public void turnRight(double speed, double targetAngle){
			double rightspeed = 0.0;  
			double angle = Robot.gyro.getAngleZ();
			System.out.println("TURNING RIGHT GYRO ANGLE: " + angle);
			
			if( angle < targetAngle ){rightspeed = -speed; }
			else if( angle >  targetAngle){rightspeed = speed;}
			else{ rightspeed = 0.0; }
			Robot.chassis.tankDrive(-rightspeed, rightspeed);
		}

		protected void execute() {
//			driveStraightAtAngle(.25, 0.0); 
//			turnRight(.50,90); 
			turnLeft(.50,-90.0);
//			if (timer.get() > 0.0 && timer.get() < 7.0) {
//				driveStraightAtAngle(.75, 0.0);
//			} else {
//				turnLeft(.75, 90.0);
//			}
		}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	Robot.chassis.tankDrive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

}
