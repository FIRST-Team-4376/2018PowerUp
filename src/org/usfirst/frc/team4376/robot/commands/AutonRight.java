package org.usfirst.frc.team4376.robot.commands;
import org.usfirst.frc.team4376.robot.Robot;
import org.usfirst.frc.team4376.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
public class AutonRight extends CommandGroup{
  public AutonRight() {
    addSequential(new AutonPidDriveStraightCommand(160.5));
    addSequential(new AutonPidTurnToAngleCommand(-90.0));
    addSequential(new AutonRaiseForkliftCommand(.75, 1.5));
    if(Robot.gameData.length() > 0){
      if(Robot.gameData.charAt(0) == 'R'){
        addSequential(new AutonPidDriveStraightCommand(13.5));
        addSequential(new AutonOpenForkliftCommand(RobotMap.clawOpenSpeed, 2));
      }
    }
  }
}
