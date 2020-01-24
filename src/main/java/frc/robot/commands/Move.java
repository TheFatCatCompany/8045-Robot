package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotContainer;

public class Move extends Command {
  public Move() {
    requires(RobotContainer.m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.m_drivetrain.m_myRobot.arcadeDrive(RobotContainer.j.getX(),RobotContainer.j.getY());    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end() {
    RobotContainer.m_drivetrain.m_myRobot.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
    
  


}