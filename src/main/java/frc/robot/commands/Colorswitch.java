package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.commands.Colorswitch.WheelColors;
public class Colorswitch extends CommandBase implements IColorswitch {
  ColorMatch m_colorMatcher = new ColorMatch();
  private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private Color storedColor;
  private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);
  public Colorswitch( ) {
  }

  private WheelColors defaultcolor = WheelColors.Yellow;
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    defaultcolor = WheelColors.Yellow;
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Motorcontrol();
  }

  public WheelColors ColorChooser(){
  
  
  
    if (RobotContainer.xController.getAButtonPressed()){
      defaultcolor = WheelColors.Yellow;
      return WheelColors.Yellow;
    }
    else if (RobotContainer.xController.getBButtonPressed()){
      defaultcolor = WheelColors.Blue;
      return WheelColors.Blue;
    }
    else if (RobotContainer.xController.getXButtonPressed()){
      defaultcolor = WheelColors.Red;
      return WheelColors.Red;
    } 
    else if (RobotContainer.xController.getYButtonPressed()){
      defaultcolor = WheelColors.Green;
      return WheelColors.Green;
    }
    return defaultcolor;
  }

  public void Motorcontrol(){
    WheelColors[] colors = WheelColors.values();
    if(Colorreading() == colors[ColorTargeting()]){
        RobotContainer.wheelspinner.set(ControlMode.PercentOutput, 5);
    }

    

    else if (Colorreading() == ColorChooser()){
      RobotContainer.wheelspinner.set(ControlMode.PercentOutput, 0); 
    } 
    else {
      RobotContainer.wheelspinner.set(ControlMode.PercentOutput, 25); 
    }
  }

  public enum WheelColors {
    Black,
    Green,
    Blue,
    Yellow,
    Red
  }

  public WheelColors Colorreading() {
    Color detectedColor = RobotContainer.colorsensor.getColor();
    WheelColors colorString;
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
    if (match.color == kBlueTarget) {
      colorString = WheelColors.Blue;
    } else if (match.color == kRedTarget) {
      colorString = WheelColors.Red;
    } else if (match.color == kGreenTarget) {
      colorString = WheelColors.Green;
    } else if (match.color == kYellowTarget) {
      colorString = WheelColors.Yellow;

    } else {
      colorString = WheelColors.Black;
    }
    return(colorString);
  }
  public int ColorTargeting(){
    int target;
    if (ColorChooser() == WheelColors.Blue){
      target = 4;
    }
    else if(ColorChooser() == WheelColors.Red){
      target = 2;
    }
    else if(ColorChooser() == WheelColors.Green){
      target = 3;
    }
  else{
    target = 1;
  }
  return target;  
}



  public double countSpin()
  {
    Color detectedColor = RobotContainer.colorsensor.getColor();
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
    double count = 0;
    if (match.color == kBlueTarget) {
      if(storedColor != match.color)
      {
        storedColor = match.color;
        count += 1/8;
      }
     
    } else if (match.color == kRedTarget) {
      if(storedColor != match.color)
      {
        storedColor = match.color;
        count += 1/8;
      }
    } else if (match.color == kGreenTarget) {
      if(storedColor != match.color)
      {
        storedColor = match.color;
        count += 1/8;
      }
    } else if (match.color == kYellowTarget) {
      if(storedColor != match.color)
      {
        storedColor = match.color;
        count += 1/8;
      }

    } 
    
    return count;
      
    }
    
  
  

  // Called once the command ends or is interrupted.
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    RobotContainer.wheelspinner.set(ControlMode.PercentOutput, 0); 
    return false;
  }
}

interface IColorswitch {
  WheelColors Colorreading();
  IColorswitch colorswitch = new Colorswitch();
}