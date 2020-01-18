package frc.robot.commands;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.util.Color;

public class Colorswitch extends Command {
    Joystick j = new Joystick(Constants.joystick);
    I2C.Port i2cPort = I2C.Port.kOnboard;
    ColorSensorV3 colorsensor = new ColorSensorV3(i2cPort);
  
    public Colorswitch() {
        requires(Robot.m_colorsensor);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        Shuffleboard.getTab("Color Sensor Data");
    }

    // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Robot.m_drivetrain.m_myRobot.arcadeDrive(j.getX(),j.getY());
    Color c = colorsensor.getColor();
    


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
    