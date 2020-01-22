/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.ColorSensorV3;
import frc.robot.Constants;
import frc.robot.commands.Colorswitch;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.buttons.*;
public class Colorsensor extends Subsystem {
  /**
   * Creates a new ExampleSubsystem.
   */
  private Joystick j;
  private ColorSensorV3 m_colorsensor;
  private boolean svitch;
  private JoystickButton eight;
  private Colorswitch test;
  private I2C.Port i2cPort = I2C.Port.kOnboard;
  public Colorsensor() {
      j = new Joystick(Constants.joystick);
      m_colorsensor = new ColorSensorV3(i2cPort);
      svitch = false;
      eight = new JoystickButton(j, 8);
      Colorswitch test = new Colorswitch();


  


  }

  @Override
  public void periodic() {
    eight.toggleWhenPressed(test);
    // This method will be called once per scheduler run
  }

    @Override
    protected void initDefaultCommand() {
        // TODO Auto-generated method stub
        setDefaultCommand(new Colorswitch());

    }
}
