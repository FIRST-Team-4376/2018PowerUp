package org.usfirst.frc.team4376.robot.subsystems;
import org.usfirst.frc.team4376.robot.OI;

import org.usfirst.frc.team4376.robot.Robot;
import org.usfirst.frc.team4376.robot.RobotMap;
import org.usfirst.frc.team4376.robot.commands.DriveCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

 //////THIS IS WHAT WE'RE USING FOR DRIVE
 //*/
public class PidDriveStraightSubsystem extends PIDSubsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public double motorBreakFactor = 0.05;
	public double targetAngle = 0.0;
	public double turnFactor = 1.3;
	

	public PidDriveStraightSubsystem(){
		super("PidDriveStraightSubsystem", 0.004, 0.0001, 0.010);
	}

	protected double returnPIDInput(){
		return Robot.driveMotorL.get();
	}
	
	protected void usePIDOutput(double output){
		double gyroAngle = Robot.gyro.getAngleZ();

		
		System.out.println("PID target: " + this.getSetpoint());
		System.out.println("PID position: " + this.getPosition());
		System.out.println("PID output: " + output);
		if (output < 0){
			output = output - motorBreakFactor;
		} else {
			output = output + motorBreakFactor;
		}
		
		if(gyroAngle <= (targetAngle+1) && gyroAngle >= (targetAngle-1)){
			Robot.chassis.tankDrive(output, output); //Bot drives straight
		} else if(gyroAngle > (targetAngle+1.0)) {
			Robot.chassis.tankDrive(output, output * turnFactor); //Turn bot to the left
		} else {
			Robot.chassis.tankDrive(output * turnFactor, output); //Turn bot to the right
		}
		
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
//		setDefaultCommand(new DriveCommand());

	}
}
