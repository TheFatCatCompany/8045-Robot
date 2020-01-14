/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  private Joystick j;
  private VictorSPX v1, v2, v3, v4;
  public Drivetrain(DifferentialDrive m_myRobot, Joystick J, VictorSPX V1, VictorSPX V2, VictorSPX V3, VictorSPX V4) 
  {
   j = J;
   v1 = V1;
   v2 = V2;
   v3 = V3;
   v4 = V4;
   m_myRobot = new DifferentialDrive(V1, V2, V3, V4);   

  }
  @Override
  public void periodic() {


    // This method will be called once per scheduler run
  }
}
