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
public class PidForkliftSubsystem extends PIDSubsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public double motorBreakFactor = 0.05;
	public double targetAngle = 0.0;
	public double turnFactor = 1.3;
	

	public PidForkliftSubsystem(){
		super("PidDriveStraightSubsystem", 0.004, 0.0001, 0.010);
	}

	protected double returnPIDInput(){
		return Robot.forkliftPositionEncoder.get();
	}
	
	protected void usePIDOutput(double output){
		System.out.println("PID FORKLIFT OUTPUT: " + output);
		System.out.println("PID FORKLIFT POSITIONS: " + this.getPosition());
		System.out.println("PID FORKLIFT TARGET: " + this.getSetpoint());
		Robot.forkLiftSubsystem.moveUpDownArms(output);
		
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
//		setDefaultCommand(new DriveCommand());

	}
}
