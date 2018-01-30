package org.usfirst.frc.team4376.robot.commands;
import org.usfirst.frc.team4376.robot.Robot;

import edu.wpi.first.wpilibj.AnalogGyro; 
import edu.wpi.first.wpilibj.RobotDrive; 
import edu.wpi.first.wpilibj.SampleRobot; 
import  edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.interfaces.Gyro;
public class Auto_Op{   
private RobotDrive myRobot;
private Gyro gyro;  
public static final double speed = 0.2; 
double Kp = 0.03; 

public void  Gyroop(){
	gyro = new AnalogGyro(1); 
	myRobot = new RobotDrive(1,2); 
	myRobot.setExpiration(0.1); 
}
 boolean autocondition = false; 
private boolean isAutonomous() {
	// TODO Auto-generated method stub
	boolean autocondition = true;  
	return autocondition;
}

Timer time = new Timer(); 

public void autonomousstraight(){
	time.start();
	gyro.reset(); 
	while(autocondition){
		double leftspeed = speed; 
		double rightspeed = speed;
		
	double angle = gyro.getAngle(); 
	
    if(angle < -2 && angle > -90){
	leftspeed = speed + (0.1*speed); 
    } 
    else{ leftspeed = speed; } 
    
    if( angle > 2 && angle < 90 ){ 
        rightspeed = speed + (0.1*speed); 
    }
    else{ rightspeed = speed; }
    
	    myRobot.tankDrive(leftspeed,rightspeed); 
	    Timer.delay(0.004);
	   double timer =  time.getFPGATimestamp(); 
	    if( timer >= 7.0){ 
	    	autocondition = false; 
	    	time.stop(); 
	    }
}
	myRobot.tankDrive(0.0, 0.0);
}

public void autonomousleft(){ 
	double leftspeed = 0.0;  
	double angle = gyro.getAngle(); 
	
	if( angle > -90 ){leftspeed = -1; }
	else if( angle < - 90){leftspeed = 1;}
	else{ leftspeed = 0; }
	myRobot.tankDrive(leftspeed,-leftspeed);  
}

	protected void execute() {

		if (time.get() > 0 && time.get() < 7) {
			autonomousstraight();
		} else {
			autonomousleft();
		}
	}

}
