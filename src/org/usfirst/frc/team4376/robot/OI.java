package org.usfirst.frc.team4376.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4376.robot.commands.ExampleCommand;
import org.usfirst.frc.team4376.robot.commands.LiftArmsCommand;
import org.usfirst.frc.team4376.robot.commands.LiftBotCommand;
import org.usfirst.frc.team4376.robot.commands.LowerArmsCommand;
import org.usfirst.frc.team4376.robot.commands.LowerBotCommand;
import org.usfirst.frc.team4376.robot.commands.RestArmsCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	
	public Joystick driveStick;
	public Button armsUp;
	public Button armsDown;
	public Button liftBot;
	public Button lowerBot;
	
	public OI() {
		
		driveStick = new Joystick(RobotMap.driveStick);
		
		JoystickButton armsUp = new JoystickButton(driveStick, 0);
		JoystickButton armsDown = new JoystickButton(driveStick, 1);
		JoystickButton liftBot = new JoystickButton(driveStick, 2);
		JoystickButton lowerBot = new JoystickButton(driveStick, 3);
		
		
		armsUp.whenPressed(new LiftArmsCommand());
		armsUp.whenReleased(new RestArmsCommand());
		
		armsDown.whenPressed(new LowerArmsCommand());
		armsDown.whenReleased(new RestArmsCommand());
		
		liftBot.whenPressed(new LiftBotCommand());
		liftBot.whenReleased(new RestArmsCommand());
		
		lowerBot.whenPressed(new LowerBotCommand());
		lowerBot.whenReleased(new RestArmsCommand());
		
		
		
		

		
	}
	
}
