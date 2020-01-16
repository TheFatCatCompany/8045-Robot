package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

public class Move extends Command
{
    public Move() {
          Joystick j;
          // requires(Robot.m_drivetrain);

    }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    DriveTrain.m_myRobot.tankDrive(j.getX(),j.getY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end() {
  DriveTrain.m_myRobot.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
    
  


}