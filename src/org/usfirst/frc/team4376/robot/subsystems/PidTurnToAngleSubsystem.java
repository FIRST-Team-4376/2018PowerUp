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
public class PidTurnToAngleSubsystem extends PIDSubsystem {	

	public PidTurnToAngleSubsystem(){
		super("PidTurnToAngleSubsystem", 0.0060, 0.0003, 0.0020);
//		super("PidTurnToAngleSubsystem", 0.007, 0.0002, 0.002);
	}

	protected double returnPIDInput(){
		return Robot.gyro.getAngleZ();
	}
	
	protected void usePIDOutput(double output){
		System.out.println("PID target: " + this.getSetpoint());
		System.out.println("PID position: " + this.getPosition());
		System.out.println("PID output: " + output);
		Robot.chassis.tankDrive(output + .2, -(output+ .2));
		
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
//		setDefaultCommand(new DriveCommand());

	}
}
