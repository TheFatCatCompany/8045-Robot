/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Colorwheel extends SubsystemBase {
  private boolean toggleOn;
  private boolean togglePressed;
  public Colorwheel() {
     toggleOn = false;
     togglePressed = false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
}
}