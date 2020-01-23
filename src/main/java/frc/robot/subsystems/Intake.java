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
import frc.robot.Constants;

public class Intake extends SubsystemBase {
 
private Joystick j;
private WPI_VictorSPX conveyerBelt;
private WPI_VictorSPX catcher1;
private WPI_VictorSPX catcher2;
private SpeedControllerGroup catcher;



public Intake() {
  j = new Joystick(Constants.joystick);
  conveyerBelt = new WPI_VictorSPX(Constants.conveyerBelt);
  catcher1 = new WPI_VictorSPX (Constants.catcher1);
  catcher2 = new WPI_VictorSPX (Constants.catcher2);
  catcher = new SpeedControllerGroup(catcher1, catcher2);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
