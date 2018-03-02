package org.usfirst.frc.team4376.robot.commands;
import org.usfirst.frc.team4376.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
public class AutonLeft extends CommandGroup{
  public AutonLeft() {
//    if(Robot.gameData.length() > 0){
//      if(gameData.charAt(0) == 'L'){
//        addSequential(new AutonPidDriveStraightCommand(160.5));
//        addSequential(new AutonPidTurnToAngleCommand(90.0));
//        addSequential(new AutonPidDriveStraightCommand(13.5));
//      } else {
//        addSequential(new AutonPidDriveStraightCommand(220));
//      }
//    }
	  addSequential(new AutonPidDriveStraightCommand(160));
  }
}
