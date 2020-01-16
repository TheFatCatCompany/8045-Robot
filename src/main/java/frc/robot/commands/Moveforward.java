package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Moveforward extends CommandBase
{
    private Joystick j;
    private WPI_VictorSPX leftSlave = new WPI_VictorSPX(1);
    private WPI_VictorSPX rightSlave = new WPI_VictorSPX(3);

// Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
move();  
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
    
  public void move()
    {
        Drivetrain.m_myRobot.tankDrive(j.getX(),j.getY());
    }


}