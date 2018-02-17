package org.usfirst.frc.team4376.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
public class TestAuton extends CommandGroup{
	public TestAuton() {
		
		// 19.11 inches per EC tick
		addSequential(new AutonDriveStraightCommand(0.7,976));
		addSequential(new AutonDriveStraightCommand(0.4,400));

		addSequential(new AutonTurnToAngleCommand(0.4,90));
		addSequential(new AutonTurnToAngleCommand(0.4,-270));
		addSequential(new AutonDriveStraightCommand(0.4, 925));
		addSequential(new AutonDriveStraightCommand(0.2,400));
		addSequential(new AutonTurnToAngleCommand(0.4,180));
		
	}
}