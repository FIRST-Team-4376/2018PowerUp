package org.usfirst.frc.team4376.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
public class TestAutonRightScale extends CommandGroup{
	public TestAutonRightScale() {
		
		addSequential(new AutonDriveStraightCommand(0.4,36));

		// open and close arms 
	}
}