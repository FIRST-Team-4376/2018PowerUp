package org.usfirst.frc.team4376.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
public class TestAutonRightScale extends CommandGroup{
	public TestAutonRightScale() {
		
		addSequential(new AutonDriveStraightCommand(0.4,304.5));
		addSequential(new AutonTurnToAngleCommand(0.4,-90));
		addSequential(new AutonDriveStraightCommand(0.4,-25.75));
		//addSequential(new RaiseArmsCommand());
		addSequential(new AutonDriveStraightCommand(0.4,60.75));
		//addSequential(new OpenArmsCommand());
		addSequential(new AutonDriveStraightCommand(0.4,18));
		addSequential(new LowerArmsCommand());
	}
}