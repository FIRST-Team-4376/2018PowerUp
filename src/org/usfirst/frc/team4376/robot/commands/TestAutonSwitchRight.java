package org.usfirst.frc.team4376.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
public class TestAutonSwitchRight extends CommandGroup{
	public TestAutonSwitchRight() {
		
		addSequential(new AutonDriveStraightCommand(0.4,2291.81963));
		addSequential(new AutonTurnToAngleCommand(0.4,-90));
		addSequential( new AutonDriveStraightCommand(0.4,229.181963));
        addSequential( new OpenForkliftArmsCommand());	
        addSequential( new CloseForkliftArmsCommand());
		addSequential(new AutonTurnToAngleCommand(0.4,-90));
        addSequential( new  AutonDriveStraightCommand(0.4, (229.181963*2)));
		addSequential(new AutonTurnToAngleCommand(0.4,-90));
		addSequential( new AutonDriveStraightCommand(0.4,(229.181963*9)));
		addSequential(new AutonTurnToAngleCommand(0.4,-90));
		addSequential( new AutonDriveStraightCommand(0.4,(229.181963*4)));
		addSequential(new AutonTurnToAngleCommand(0.4,-90));
        addSequential( new LiftArmsCommand());
        addSequential( new OpenForkliftArmsCommand());	
		addSequential( new AutonDriveStraightCommand(0.4,-229.181963));
        addSequential( new LowerArmsCommand());
	}
}