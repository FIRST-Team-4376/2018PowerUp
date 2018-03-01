package org.usfirst.frc.team4376.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
public class TestAuton extends CommandGroup{
	public TestAuton() {
    // 19.11 inches per EC tick for AutonDriveStraightCommand
		addSequential(new AutonDriveStraightCommand(0.4,2291.81963));
		addSequential(new AutonTurnToAngleCommand(0.4,-90));
		// open and close arms 
	}
}