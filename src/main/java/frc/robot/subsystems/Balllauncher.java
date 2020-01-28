/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants;
import frc.robot.commands.Shootball;


public class Balllauncher extends Subsystem {
private Joystick j;
public static WPI_VictorSPX shooter;
private JoystickButton two;
private Shootball test;



  public Balllauncher() {
    j = new Joystick(Constants.joystick);
    shooter = new WPI_VictorSPX (Constants.shooter);
    two = new JoystickButton(j,2);
    Shootball test = new Shootball();

  }

  @Override
  public void periodic() {
    two.whenPressed(test);
    // This method will be called once per scheduler run
  }

  @Override
  protected void initDefaultCommand() {
    // TODO Auto-generated method stub
    

  }
}
