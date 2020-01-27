package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

public class Move extends CommandBase {
  public Move() {
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.myRobot.arcadeDrive(RobotContainer.joystick.getX(),RobotContainer.joystick.getY());    
  }

  // Called once the command ends or is interrupted.
  public void end() {
    RobotContainer.myRobot.arcadeDrive(0, 0);
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
    
  


}