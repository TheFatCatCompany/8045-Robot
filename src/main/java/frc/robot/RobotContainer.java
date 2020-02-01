/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.Colorswitch;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Move;
import frc.robot.commands.Pickup;
import frc.robot.commands.Shootball;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Balllauncher;
import frc.robot.subsystems.Colorwheel;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  public static I2C.Port i2cPort;
  public static ColorSensorV3 colorsensor;
  public static Joystick joystick;
  // The robot's subsystems and commands are defined here...
  public static ExampleSubsystem m_exampleSubsystem;
  public static ExampleCommand m_autoCommand;
  public static Move move;
  public static Drivetrain drivetrain;
  public static Colorwheel colorspinner;
  public static JoystickButton joystickButton8;
  public static JoystickButton joystickButton3;
  public static JoystickButton joystickButton4;
  public static DifferentialDrive myRobot;
  public static WPI_VictorSPX v1;
  public static WPI_VictorSPX v2;
  public static WPI_VictorSPX v3;
  public static WPI_VictorSPX v4;
  public static SpeedControllerGroup leftMotors;
  public static SpeedControllerGroup rightMotors;
  public static WPI_VictorSPX wheelspinner;
  public static Colorswitch colorSwitch;
  public static Pickup pickup;
  public static Intake intake;
  public static Shootball shootball;
  public static Balllauncher balllauncher;

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // JoystickButton eight = new JoystickButton(j, 8);
    joystickButton8.whenPressed(colorSwitch);
    joystickButton3.whenActive(pickup);
    joystickButton4.whenActive(shootball);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
