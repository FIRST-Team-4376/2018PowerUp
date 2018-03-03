package org.usfirst.frc.team4376.robot.commands;
import org.usfirst.frc.team4376.robot.Robot;
import org.usfirst.frc.team4376.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class AutonLeft extends CommandGroup{
  public AutonLeft(String gameData) {
//	String gameData = Robot.gameData;
	//String gameData = SmartDashboard.getData("autonGameData");
    addSequential(new AutonPidDriveStraightCommand(160.5));
    addSequential(new AutonPidTurnToAngleCommand(90.0));
    addSequential(new AutonRaiseForkliftCommand(1.0, 2.0));
    if(gameData.length() > 0){
      if(gameData.charAt(0) == 'L'){
        addSequential(new AutonPidDriveStraightCommand(18.5, .6));
        addSequential(new AutonOpenForkliftCommand(RobotMap.clawOpenSpeed, 2));
      }
    }
  }
}
