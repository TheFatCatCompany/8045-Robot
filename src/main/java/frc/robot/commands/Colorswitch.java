package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Colorsensor;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.util.Color;

public class Colorswitch extends Command {  
  public Colorswitch() {
    requires(RobotContainer.m_colorsensor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Shuffleboard.getTab("Color Sensor Data");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Color c = RobotContainer.m_colorsensor.getColor();
    Shuffleboard.putNumber("Color Sensor Data", c.hashCode());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end() {
  }
 
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}