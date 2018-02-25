package org.usfirst.frc.team4376.robot.commands;
import org.usfirst.frc.team4376.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
public class TestAutonLeftSwitch extends CommandGroup{
	public TestAutonLeftSwitch() {
		
//addSequential( new AutonDriveStraightCommand(0.4, (5816/4))); 
//addSequential( new AutonDriveStraightCommand(0.4, 90));
////////////////////////////////////////////////////////
addSequential( new AutonDriveStraightCommand(0.4, (5816/4))); 
addSequential( new AutonDriveStraightCommand(0.4, -90));
addSequential( new AutonDriveStraightCommand(0.4, (-1492/4))); 
// raise arms 
addSequential( new AutonDriveStraightCommand(0.4, (1160/4))); 
//  open arms 
addSequential( new AutonDriveStraightCommand(0.4, (-34.4/4))); 
// lower arms 

	}
}