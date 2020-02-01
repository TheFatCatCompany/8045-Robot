/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Joystick;

public class Pickup extends CommandBase {
  private static Boolean IS_RUNNING = false;
  // A specific button or action on the joystick will control the mechanism (motors) and eventually pick up the ball 
  public Pickup() {
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }
//Allows you to set the speed of the Intake motor
  private double setSpeed(){
    return -RobotContainer.joystick.getThrottle() * 100 + 100;
}
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    setSpeed();
    double speed = IS_RUNNING ? 0.0: setSpeed(); 
    Intake.catcher.set(speed);
    IS_RUNNING = ! IS_RUNNING;
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Intake.catcher.set(0.0);
    return true;
  }
}


