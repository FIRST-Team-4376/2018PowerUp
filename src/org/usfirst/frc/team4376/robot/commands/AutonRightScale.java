package org.usfirst.frc.team4376.robot.commands;
import org.usfirst.frc.team4376.robot.Robot;
import org.usfirst.frc.team4376.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class AutonRightScale extends CommandGroup{
  public AutonRightScale(String gameData) {
//	    addSequential(new AutonPidDriveStraightCommand(220.5));
//	    addSequential(new AutonRaiseForkliftCommand(1.0, 3.6));
	    addSequential(new AutonPidMoveForkliftUpDownCommand(4442, 1.0));
//	    addSequential(new AutonPidMoveForkliftUpDownCommand(-2442, 1.0));
	    if(gameData.length() > 0){
	      if(gameData.charAt(0) == 'R'){
	        addSequential(new AutonPidDriveStraightCommand(18.5, .6));
//	        addSequential(new AutonOpenForkliftCommand(RobotMap.clawOpenSpeed, 2));
	      }
	    }
  }
}
