package org.usfirst.frc.team4376.robot.commands;
import org.usfirst.frc.team4376.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
public class TestAuton extends CommandGroup{
	public TestAuton(String gameMessage) {
		// This starts from center and puts it in the right switch
		addSequential(new AutonPidDriveStraightCommand(48));
		addSequential(new AutonPidTurnToAngleCommand(45.0, 1.0));
		addSequential(new AutonPidDriveStraightCommand(54));
		addSequential(new AutonPidMoveForkliftUpDownCommand(2342, RobotMap.forkLiftUpSpeed));
		addSequential(new AutonPidTurnToAngleCommand(-45.0, 1.0));
		addSequential(new AutonPidDriveStraightCommand(25));
		addSequential(new AutonOpenForkliftCommand(RobotMap.clawOpenSpeed, 2));
//		this.addParallel(command);
	}
}
