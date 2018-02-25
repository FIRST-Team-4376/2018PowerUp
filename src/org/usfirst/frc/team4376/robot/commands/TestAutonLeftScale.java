package org.usfirst.frc.team4376.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
public class TestAutonLeftScale extends CommandGroup{
	public TestAutonLeftScale() {
		
		addSequential(new AutonDriveStraightCommand(0.4,191.5));
		addSequential(new AutonTurnToAngleCommand(0.4,-90));
		addSequential(new AutonDriveStraightCommand(0.4,198.75));
		addSequential(new AutonTurnToAngleCommand(0.4,-90));
		addSequential(new AutonDriveStraightCommand(0.4,43));
		addSequential(new AutonTurnToAngleCommand(0.4,-90));
		addSequential(new AutonDriveStraightCommand(0.4,18.25));
		//addSequential(new OpenArmsCommand());
		}
}