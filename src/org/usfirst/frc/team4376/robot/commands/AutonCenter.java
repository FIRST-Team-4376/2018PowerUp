package org.usfirst.frc.team4376.robot.commands;
import org.usfirst.frc.team4376.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
public class AutonCenter extends CommandGroup{
  public AutonCenter(String gameData) {
    if(gameData.length() > 0){
      if(gameData.charAt(0) == 'R'){
        // This starts from center and puts it in the right switch
        addSequential(new AutonPidDriveStraightCommand(43));
        addSequential(new AutonPidTurnToAngleCommand(45.0, 1.0));
        addSequential(new AutonPidDriveStraightCommand(54));
        addSequential(new AutonPidMoveForkliftUpDownCommand(2342, RobotMap.forkLiftUpSpeed));
        addSequential(new AutonPidTurnToAngleCommand(-45.0, 1.0));
        addSequential(new AutonPidDriveStraightCommand(30));
        addSequential(new AutonOpenForkliftCommand(RobotMap.clawOpenSpeed, 2));
      } else {
        // This starts from center and puts it in the right switch
        addSequential(new AutonPidDriveStraightCommand(43));
        addSequential(new AutonPidTurnToAngleCommand(-45.0, 1.0));
        addSequential(new AutonPidDriveStraightCommand(54));
        addSequential(new AutonPidMoveForkliftUpDownCommand(2342, RobotMap.forkLiftUpSpeed));
        addSequential(new AutonPidTurnToAngleCommand(45.0, 1.0));
        addSequential(new AutonPidDriveStraightCommand(30));
        addSequential(new AutonOpenForkliftCommand(RobotMap.clawOpenSpeed, 2));
      }
    } else {
        addSequential(new AutonPidDriveStraightCommand(48));
    }
//    this.addParallel(command);
  }
}
