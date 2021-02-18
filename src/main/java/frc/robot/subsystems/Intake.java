/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import frc.robot.Constants;
import frc.robot.commands.Pickup;

public class Intake extends SubsystemBase {
  public static WPI_VictorSPX catcher1;
  public static WPI_VictorSPX catcher2;
  public static WPI_VictorSPX conveyerBelt;
  public static Servo intakeServo;
  public static SpeedControllerGroup catcher;

  public Intake() {
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
