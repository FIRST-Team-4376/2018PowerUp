package org.usfirst.frc.team4376.robot.commands;

import org.usfirst.frc.team4376.robot.Robot;
import org.usfirst.frc.team4376.robot.RobotMap;
import org.usfirst.frc.team4376.robot.subsystems.ChassisSubsystem;
import org.usfirst.frc.team4376.robot.subsystems.ForkLiftSubsystem;

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

		public void turnInPlace(double speed, double targetAngle){
			double gyroAngle = Robot.gyro.getAngleZ();
			double leftSpeed = 0.0;
			double marginOfError = 1.0;
			System.out.println("TURNING IN PLACE GYRO ANGLE: " + gyroAngle);
			
			
			if(gyroAngle <= (targetAngle + marginOfError) && gyroAngle >= (targetAngle - marginOfError)){
				leftSpeed = 0.0;
			} else if(gyroAngle > (targetAngle + marginOfError)) {
				leftSpeed = -speed;
			} else {
				leftSpeed = speed;
			}
			Robot.chassis.tankDrive(leftSpeed, -leftSpeed);
		}
		
		public void leftSwitch(){	
		if( Robot.driveMotorL.get() < 50000 && Robot.driveMotorR.get() < 50000 ){
			driveStraightAtAngle(2,0.0); 
		}
		else if( Robot.driveMotorL.get() >50000 && Robot.driveMotorR.get() >50000 ){
			turnInPlace(.50,90); 
		}
		else if( Robot.gyro.getAngleZ() >= 90 ){ 
		driveStraightAtAngle(2,0.0); 
		}
		else if( Robot.driveMotorL.get() >50000 && Robot.driveMotorR.get() >50000 ){
			turnInPlace(.50,90); 
		}
		else if( Robot.gyro.getAngleZ() >= 90 ){
//			ForkLiftSubsystem.openArmsToLimit(); 
//			ForkLiftSubsystem.closeArmsToLimit(); 
	        
		}
		else if( Robot.clawEncoder.get() <= -50000 ){ 
              driveStraightAtAngle(-2.0,0.0); 
		}
		else if( Robot.driveMotorL.get() <= -50000 && Robot.driveMotorR.get() <= -50000 ){ 
			turnInPlace(.50,90); 
		}
		else if( Robot.gyro.getAngleZ() <= -90 ){
			driveStraightAtAngle(2,0.0); 
		} 
		else if( Robot.driveMotorL.get() > 50000 && Robot.driveMotorR.get() > 50000 ){
			turnInPlace(.50,-90); 
		}
		else if( Robot.gyro.getAngleZ() <= -90 ){
			driveStraightAtAngle(2,0.0); 
		} 
		else if( Robot.driveMotorL.get() > 50000 && Robot.driveMotorR.get() > 50000 ){
			turnInPlace(.50,90); 
		}
		}
		
		public void rightSwitch(){
			if( Robot.driveMotorL.get() < 262.021){
				driveStraightAtAngle(.5,0.0); 
			}
			else if( Robot.driveMotorL.get() >50000 && Robot.driveMotorR.get() >50000 ){
				turnInPlace(.50,-90); 
			}
			else if( Robot.gyro.getAngleZ() <=-90){
			driveStraightAtAngle(2,0.0); 
			}
			else if( Robot.driveMotorL.get() >50000 && Robot.driveMotorR.get() >50000 ){
				turnInPlace(.50,90); 
			}
			else if(  Robot.gyro.getAngleZ() >= 90){
//				ForkLiftSubsystem.openArmsToLimit(); 
//				ForkLiftSubsystem.closeArmsToLimit(); 
		        
			}
			else if( Robot.clawEncoder.get() <= -50000 ){ 
	              driveStraightAtAngle(-2.0,0.0); 
			}
			else if( Robot.driveMotorL.get() <= -50000 && Robot.driveMotorR.get() <= -50000 ){ 
				turnInPlace(.50,90); 
			}
			else if( Robot.gyro.getAngleZ() >= 90 ){
				driveStraightAtAngle(2,0.0); 
			} 
			else if( Robot.driveMotorL.get() > 50000 && Robot.driveMotorR.get() > 50000 ){
				turnInPlace(.50,-90); 
			}
			else if( Robot.gyro.getAngleZ() <= 90){
				driveStraightAtAngle(2,0.0); 
			} 
			else if( Robot.driveMotorL.get() > 50000 && Robot.driveMotorR.get() > 50000 ){
				turnInPlace(.50,-90); 
			}
			
		}
		
		public void leftScale(){
			
		}
		
		public void rightScale(){
			
		}

		protected void execute() {
			System.out.println("AUTON RIGHT MOTOR ENCODER: " + Robot.driveMotorR.get());
			System.out.println("AUTON LEFT MOTOR ENCODER: " + Robot.driveMotorL.get());
			if( Robot.driveMotorL.get() < 262.021){
				driveStraightAtAngle(.5,0.0); 
			} else if (Robot.gyro.getAngleZ() > -89){
				turnInPlace(.50,-90);
			} else {
				driveStraightAtAngle(.3,-90);
			}
			// driveMotorL
			// driveMotorR
		
	
			
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
