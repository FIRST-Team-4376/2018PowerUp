package org.usfirst.frc.team4376.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
public class TestAutonScaleRight extends CommandGroup{
	public TestAutonScaleRight() {
		
		addSequential(new AutonDriveStraightCommand(0.4,2291.81963)); 
		addSequential(new AutonTurnToAngleCommand(0.4,-90));
		addSequential( new AutonDriveStraightCommand(0.4,229.181963));
		 addSequential( new OpenForkliftArmsCommand());	
	    addSequential( new CloseForkliftArmsCommand());
		addSequential(new AutonTurnToAngleCommand(0.4,-90));
        addSequential( new  AutonDriveStraightCommand(0.4, (229.181963*2)));
		addSequential(new AutonTurnToAngleCommand(0.4,-90));
		addSequential(new AutonDriveStraightCommand(0.4,(229.181963*10)));
		addSequential(new AutonTurnToAngleCommand(0.4,-90));
		addSequential(new AutonDriveStraightCommand(0.4,(229.81963*22)));
		addSequential(new AutonTurnToAngleCommand(0.4,-90));
        addSequential( new LiftArmsCommand());
		addSequential(new AutonDriveStraightCommand(0.4,(0.5*229.181963)));
		addSequential( new OpenForkliftArmsCommand());
		addSequential(new AutonDriveStraightCommand(0.4,-(0.5*229.181963)));	
        addSequential( new LowerArmsCommand());

		// open and close arms 
	}
}