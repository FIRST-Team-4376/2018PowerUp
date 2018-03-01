package org.usfirst.frc.team4376.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
public class AutonRightStartRightSwitch extends CommandGroup{
  public AutonRightStartRightSwitch() {
//    addSequential(new AutonDriveStraightCommand(0.4,688));
//    addSequential(new AutonTurnToAngleCommand(0.4,90));
    //addSequential(new AutonPidTurnToAngleCommand(90));
    addSequential(new AutonPidDriveStraightCommand(160.5));
    addSequential(new AutonPidTurnToAngleCommand(-90.0));
    addSequential(new AutonPidDriveStraightCommand(13.5));
  }
}
