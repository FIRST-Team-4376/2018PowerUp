package org.usfirst.frc.team4376.robot.commands;
import org.usfirst.frc.team4376.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
public class TestAuton extends CommandGroup{
	public TestAuton() {
//		addSequential(new AutonDriveStraightCommand(0.4,688));
//		addSequential(new AutonTurnToAngleCommand(0.4,90));
		//addSequential(new AutonPidTurnToAngleCommand(90));
		addSequential(new AutonPidDriveStraightCommand(160.5));
//		addSequential(new AutonPidTurnToAngleCommand(-90.0));
		addSequential(new AutonRaiseForkliftCommand(.5, 2.5));
//		addParallel(new AutonRaiseForkliftCommand(.5, 2));
		addSequential(new AutonOpenForkliftCommand(RobotMap.clawOpenSpeed, 1));
		addSequential(new AutonLowerForkliftCommand(-.5, 2));
		addSequential(new AutonCloseForkLiftCommand(RobotMap.clawCloseSpeed, 1));
//		this.addParallel(command);
	}
}
