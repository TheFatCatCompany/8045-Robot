/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.RobotContainer;

import edu.wpi.first.wpilibj.MedianFilter;

import edu.wpi.first.wpilibj.AnalogInput;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Ultrasound extends SubsystemBase {
  /**
   * Creates a new Ultrasound.
   */

  private static double kHoldDistance;

 
  private static double kValueToInches;

  private static double kP;
  private static int kUltrasonicPort;
  private MedianFilter m_filter;

  private final AnalogInput m_ultrasonic = new AnalogInput(kUltrasonicPort);
  public Ultrasound() 
  {
    kHoldDistance = 12.0;
    kValueToInches = 0.125;
    kP = 0.05;
    kUltrasonicPort = 0;
    m_filter = new MedianFilter(10);
  }

  @Override
  public void periodic() 
  {
    double currentDistance = m_filter.calculate(m_ultrasonic.getValue()) * kValueToInches;
    System.out.println(currentDistance);
    double currentSpeed = (kHoldDistance - currentDistance) * kP;
    if (currentDistance <= 30) {
    
      RobotContainer.myRobot.arcadeDrive(0, 0);
    }
    else{
  
    RobotContainer.myRobot.arcadeDrive(currentSpeed, 0);
    }
  }
}
