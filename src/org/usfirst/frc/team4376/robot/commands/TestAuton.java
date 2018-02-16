package org.usfirst.frc.team4376.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
public class TestAuton extends CommandGroup{
	public TestAuton() {
		
		addSequential(new AutonDriveStraightCommand(0.4,688));
		addSequential(new AutonTurnToAngleCommand(0.4,90)); 
		
	}
}