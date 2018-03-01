package org.usfirst.frc.team4376.robot.commands;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
public class AutonLeft extends CommandGroup{
  public AutonLeft() {
    String gameData;
    gameData = DriverStation.getInstance().getGameSpecificMessage();
    if(gameData.length() > 0){
      if(gameData.charAt(0) == 'L'){
        addSequential(new AutonPidDriveStraightCommand(160.5));
        addSequential(new AutonPidTurnToAngleCommand(90.0));
        addSequential(new AutonPidDriveStraightCommand(13.5));
      } else {
        addSequential(new AutonPidDriveStraightCommand(220));
      }
    }
  }
}
