/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotContainer;
import frc.robot.commands.Colorswitch;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Colorwheel extends SubsystemBase {
  public static WPI_VictorSPX wheelspinner;
  private Colorswitch m_colorswitch;
  public Colorwheel() {
     m_colorswitch = new Colorswitch();
    wheelspinner = new WPI_VictorSPX(0);
  }

  @Override
  public void periodic() {
    RobotContainer.eight.toggleWhenActive(m_colorswitch);
    // This method will be called once per scheduler run
    
  }

  
}