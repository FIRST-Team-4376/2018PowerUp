package org.usfirst.frc.team4376.robot.commands;
import org.usfirst.frc.team4376.robot.Robot;
import org.usfirst.frc.team4376.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class AutonLeft extends CommandGroup{
  public AutonLeft(String gameData) {
    if(gameData.length() > 0){
      if(gameData.charAt(0) == 'L'){
        addSequential(new AutonPidDriveStraightCommand(150.5));
        addSequential(new AutonPidTurnToAngleCommand(90.0, 2.0));
        addSequential(new AutonPidMoveForkliftUpDownCommand(2700, RobotMap.forkLiftUpSpeed));
        addSequential(new AutonPidDriveStraightCommand(24.5, .6));
        addSequential(new AutonOpenForkliftCommand(RobotMap.clawOpenSpeed, 2));
      } else if (gameData.charAt(1) == 'L') {
        // go for scale
        addSequential(new AutonPidDriveStraightCommand(289.0));
        addSequential(new AutonPidMoveForkliftUpDownCommand(4600, RobotMap.forkLiftUpSpeed));
        //addSequential(new AutonPidTurnToAngleCommand(90.0, 2.0));
        addSequential(new AutonTurnToAngleCommand(.6, 90));
//          addSequential(new AutonPidDriveStraightCommand(-12.0, .6));
        
        addSequential(new AutonPidDriveStraightCommand(15.5, .6));
        addSequential(new AutonOpenForkliftCommand(RobotMap.clawOpenSpeed, 2));
      } else {
        addSequential(new AutonPidDriveStraightCommand(166.5));
      }
    } else {
      addSequential(new AutonPidDriveStraightCommand(166.5));
    }
  }
}
