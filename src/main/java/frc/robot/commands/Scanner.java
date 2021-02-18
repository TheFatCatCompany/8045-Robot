/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.MedianFilter;

public class Scanner extends CommandBase {
  /**
   * Creates a new Scanner.
   */
  private AnalogInput m_ultrasonic;
  private int kUltrasonicPort;
  private MedianFilter m_filter;
  private static double kHoldDistance;
  public Scanner() {
    // Use addRequirements() here to declare subsystem dependencies.
    kUltrasonicPort = 0;
    m_ultrasonic= new AnalogInput(kUltrasonicPort);
    m_filter = new MedianFilter(10);
    kHoldDistance = 12.0;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    double currentDistance =  m_filter.calculate(m_ultrasonic.getValue()) * 0.125;
    System.out.println(currentDistance);
    double currentSpeed = (kHoldDistance - currentDistance) * 0.125;
    if (currentDistance <= 30)
    {
      RobotContainer.myRobot.arcadeDrive(0, 0);
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
