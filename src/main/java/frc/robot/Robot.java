/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.Colorswitch;
import frc.robot.commands.Move;
import frc.robot.subsystems.Balllauncher;
import frc.robot.subsystems.Colorwheel;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 *  The VM is configured to automatically run
 * this class, and to call the functions corresponding to each mode, as des
 * ribed in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  private Command m_autonomousCommand;
  private RobotContainer m_robotContainer;
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    RobotContainer.drivetrain= new Drivetrain();
    RobotContainer.colorspinner = new Colorwheel();
    RobotContainer.joystick = new Joystick(Constants.joystick);
    RobotContainer.joystickButton8 = new JoystickButton(RobotContainer.joystick, 8);
    RobotContainer.drivetrain = new Drivetrain();
    RobotContainer.colorspinner = new Colorwheel();
    RobotContainer.colorSwitch = new Colorswitch();
    RobotContainer.v1 = new WPI_VictorSPX(Constants.RightLeader);
    RobotContainer.v2 = new WPI_VictorSPX(Constants.LeftLeader);
    RobotContainer.v3 = new WPI_VictorSPX(Constants.RightFollower);
    RobotContainer.v4 = new WPI_VictorSPX(Constants.LeftFollower);
    RobotContainer.leftMotors = new SpeedControllerGroup(RobotContainer.v1,RobotContainer.v3);
    RobotContainer.rightMotors = new SpeedControllerGroup(RobotContainer.v2, RobotContainer.v4);
    RobotContainer.leftMotors.setInverted(true);
    RobotContainer.myRobot = new DifferentialDrive(RobotContainer.rightMotors, RobotContainer.leftMotors);
    RobotContainer.colorswitch = new Colorswitch();
    RobotContainer.i2cPort = I2C.Port.kOnboard;
    RobotContainer.colorsensor = new ColorSensorV3(RobotContainer.i2cPort);
    RobotContainer.wheelspinner = new WPI_VictorSPX(5);   
    RobotContainer.drivetrain.intialize();
    RobotContainer.move = new Move();
    Intake.catcher1 = new WPI_VictorSPX (Constants.catcher1);
    Intake.catcher2 = new WPI_VictorSPX (Constants.catcher2);
    Intake.catcher = new SpeedControllerGroup(Intake.catcher1, Intake.catcher2);
    Intake.conveyerBelt = new WPI_VictorSPX(Constants.conveyerBelt);
    Balllauncher.shooter = new WPI_VictorSPX (Constants.shooter);
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
   
  }

  /**
   *This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work. 
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();
    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    RobotContainer.move.schedule();
    RobotContainer.colorSwitch.schedule();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}