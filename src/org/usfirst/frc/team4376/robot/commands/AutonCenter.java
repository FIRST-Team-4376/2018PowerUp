package org.usfirst.frc.team4376.robot.commands;
import org.usfirst.frc.team4376.robot.Robot;
import org.usfirst.frc.team4376.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class AutonCenter extends CommandGroup{
  public AutonCenter(String gameData) {
//	String gameData = Robot.gameData;
	//String gameData = SmartDashboard.getData("autonGameData");
	  addSequential(new AutonRaiseForkliftCommand(.75, 1.5));
    addSequential(new AutonPidDriveStraightCommand(50.5));
    
    if(gameData.length() > 0){
      if(gameData.charAt(0) == 'L'){
    	  addSequential(new AutonPidTurnToAngleCommand(-20.0));
    	  addSequential(new AutonPidDriveStraightCommand(110.5));
    	  addSequential(new AutonPidTurnToAngleCommand(20.0));
//        addSequential(new AutonOpenForkliftCommand(RobotMap.clawOpenSpeed, 2));
      } else if (gameData.charAt(0) == 'R'){
    	  addSequential(new AutonPidDriveStraightCommand(110.5));
    	  addSequential(new AutonOpenForkliftCommand(RobotMap.clawOpenSpeed, 2));
      }
    }
  }
}
