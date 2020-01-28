/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.Shootball;

public class Balllauncher extends SubsystemBase {
  public static WPI_VictorSPX shooter;
  private JoystickButton two;
  private Shootball test;

  public Balllauncher() {
    shooter = new WPI_VictorSPX(Constants.shooter);
    two = new JoystickButton(RobotContainer.joystick, 2);
    Shootball test = new Shootball();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    two.whenPressed(test);
  }
}
