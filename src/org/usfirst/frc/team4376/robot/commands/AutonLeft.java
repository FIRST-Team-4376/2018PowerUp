package org.usfirst.frc.team4376.robot.commands;
import org.usfirst.frc.team4376.robot.Robot;
import org.usfirst.frc.team4376.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class AutonLeft extends CommandGroup{
  public AutonLeft() {
//	String gameData = Robot.gameData;
	//String gameData = SmartDashboard.getData("autonGameData");
	String gameData = SmartDashboard.getString("autonGameData", "");
    addSequential(new AutonPidDriveStraightCommand(160.5));
    addSequential(new AutonPidTurnToAngleCommand(90.0));
    addSequential(new AutonRaiseForkliftCommand(.75, 1.5));
    if(gameData.length() > 0){
      if(gameData.charAt(0) == 'L'){
        addSequential(new AutonPidDriveStraightCommand(13.5));
        addSequential(new AutonOpenForkliftCommand(RobotMap.clawOpenSpeed, 2));
      }
    }
  }
}
