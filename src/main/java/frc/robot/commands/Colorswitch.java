package frc.robot.commands;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Colorsensor;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Colorswitch extends Command {
    Joystick j = new Joystick(Constants.joystick);
    I2C.Port i2cPort = I2C.Port.kOnboard;
    ColorSensorV3 m_colorsensor = new ColorSensorV3(i2cPort);
    ColorMatch m_colorMatcher = new ColorMatch();

    // Colorsensor color = new Colorsensor(); THis was giving us problems
      private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);
  
    public Colorswitch() {
        requires(Robot.m_colorsensor);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
      m_colorMatcher.addColorMatch(kBlueTarget);
      m_colorMatcher.addColorMatch(kGreenTarget);
      m_colorMatcher.addColorMatch(kRedTarget);
      m_colorMatcher.addColorMatch(kYellowTarget); 
    }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Color detectedColor = m_colorsensor.getColor();
    String colorString;
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
    if (match.color == kBlueTarget) {
      colorString = "Blue";
    } else if (match.color == kRedTarget) {
      colorString = "Red";
    } else if (match.color == kGreenTarget) {
      colorString = "Green";
    } else if (match.color == kYellowTarget) {
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }
    SmartDashboard.putString("Color:", colorString);
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