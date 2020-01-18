package frc.robot.commands;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class Move extends Command {
          Joystick j = new Joystick(Constants.joystick);

  public Move() {
          requires(Robot.m_drivetrain);


    }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.m_drivetrain.m_myRobot.arcadeDrive(j.getX(),j.getY());    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end() {
  Robot.m_drivetrain.m_myRobot.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
    
  


}