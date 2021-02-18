/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.Balllauncher;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Shootball extends CommandBase {
  private static Boolean IS_RUNNING = false;
  public Shootball() {
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double angle = IS_RUNNING ? 0.0: 180;
    double speed = IS_RUNNING ? 0.0: 127.0;
    Balllauncher.shooter.set(speed);
    Balllauncher.gate.setAngle(angle);
    IS_RUNNING = !IS_RUNNING;
  }

  // Called once the command ends or is interrupted.
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}


