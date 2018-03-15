package org.usfirst.frc.team4376.robot.commands;
import org.usfirst.frc.team4376.robot.Robot;
import org.usfirst.frc.team4376.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class AutonRightPrioritizeScale extends CommandGroup{
  public AutonRightPrioritizeScale(String gameData) {
	    
	    
	    //addSequential(new AutonRaiseForkliftCommand(1.0, 2.0));
	    
	    if(gameData.length() > 0){
	      if(gameData.charAt(1) == 'R'){
	      	// go for scale
	    	  addSequential(new AutonPidDriveStraightCommand(289.0));
	    	  addSequential(new AutonPidMoveForkliftUpDownCommand(4500, RobotMap.forkLiftUpSpeed));
	    	  addSequential(new AutonPidTurnToAngleCommand(-90.0, 1.0));
//	    	  addSequential(new AutonPidDriveStraightCommand(-12.0, .6));
	    	  
	    	  addSequential(new AutonPidDriveStraightCommand(15.5, .6));
	    	  addSequential(new AutonOpenForkliftCommand(RobotMap.clawOpenSpeed, 2));
	      } else if (gameData.charAt(0) == 'R') {
		    	addSequential(new AutonPidDriveStraightCommand(166.5));
		    	addSequential(new AutonPidTurnToAngleCommand(-90.0, 1.5));
		    	addSequential(new AutonPidMoveForkliftUpDownCommand(2342, RobotMap.forkLiftUpSpeed));
	        addSequential(new AutonPidDriveStraightCommand(24.5, .6));
	        addSequential(new AutonOpenForkliftCommand(RobotMap.clawOpenSpeed, 2));
	      } else {
	      	addSequential(new AutonPidDriveStraightCommand(166.5));
	      }
	    } else {
	    	addSequential(new AutonPidDriveStraightCommand(166.5));
	    }
  }
}