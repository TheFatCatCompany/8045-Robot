/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;



import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.ColorSensorV3;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command; 
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Cancel;
import frc.robot.commands.Colorswitch;
import frc.robot.commands.Gyronum;
import frc.robot.commands.IntakeLifter;
import frc.robot.commands.Move;
import frc.robot.commands.MoveArm;
import frc.robot.commands.Pickup;
import frc.robot.commands.Shootball;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Balllauncher;
import frc.robot.subsystems.Colorwheel;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as des ribed in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  private Command m_autonomousCommand;
  private RobotContainer robotContainer;

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer. This will perform all our button bindings,
    // and put our
    // autonomous chooser on the dashboard.
    RobotContainer.xController = new XboxController(1);
    RobotContainer.drivetrain = new Drivetrain();
    RobotContainer.colorspinner = new Colorwheel();
    RobotContainer.colorSwitch = new Colorswitch();
    RobotContainer.joystick = new Joystick(Constants.joystick);
    RobotContainer.joystickButton8 = new JoystickButton(RobotContainer.joystick, 5);
    RobotContainer.joystickButton1 = new JoystickButton(RobotContainer.joystick, Constants.launch);
    RobotContainer.joystickButton3 = new JoystickButton(RobotContainer.joystick, Constants.catcher);
    RobotContainer.joystickButton4 = new JoystickButton(RobotContainer.joystick, 4);
    RobotContainer.joystickButton10 = new JoystickButton(RobotContainer.joystick, Constants.slow15);
    RobotContainer.joystickButton12 = new JoystickButton(RobotContainer.joystick, Constants.fast);
    RobotContainer.joystickButton11 = new JoystickButton(RobotContainer.joystick, Constants.cancel);
    RobotContainer.xBoxButton5 = new JoystickButton(RobotContainer.xController, 5);
    RobotContainer.drivetrain = new Drivetrain();
    RobotContainer.colorspinner = new Colorwheel();
    RobotContainer.v1 = new WPI_VictorSPX(Constants.RightLeader);
    RobotContainer.v2 = new WPI_VictorSPX(Constants.LeftLeader);
    RobotContainer.v3 = new WPI_VictorSPX(Constants.RightFollower);
    RobotContainer.v4 = new WPI_VictorSPX(Constants.LeftFollower);
    RobotContainer.leftMotors = new SpeedControllerGroup(RobotContainer.v1, RobotContainer.v3);
    RobotContainer.rightMotors = new SpeedControllerGroup(RobotContainer.v2, RobotContainer.v4);
    RobotContainer.myRobot = new DifferentialDrive(RobotContainer.rightMotors, RobotContainer.leftMotors);
    RobotContainer.i2cPort = I2C.Port.kOnboard;
    RobotContainer.colorsensor = new ColorSensorV3(RobotContainer.i2cPort);
    RobotContainer.wheelspinner = new WPI_VictorSPX(5);
    RobotContainer.drivetrain.intialize();
    RobotContainer.move = new Move();
    RobotContainer.intake = new Intake();
    RobotContainer.balllauncher = new Balllauncher();
    RobotContainer.pickup = new Pickup();
    RobotContainer.shootball = new Shootball();
    RobotContainer.cancel = new Cancel();
    RobotContainer.sensorthing = new PigeonIMU(0);
    Balllauncher.shooter = new WPI_VictorSPX(Constants.shooter);
    RobotContainer.ultrasound = new AnalogInput(0);
    Balllauncher.gate = new Servo(0);
    Intake.intakeServo = new Servo(1);
    Arm.Actuator = new Servo(2);
    RobotContainer.intakeLifter = new IntakeLifter();
    RobotContainer.armMover = new MoveArm(); 
    Intake.catcher1 = new WPI_VictorSPX(Constants.catcher1);
    Intake.catcher2 = new WPI_VictorSPX(Constants.catcher2);
    Intake.catcher = new SpeedControllerGroup(Intake.catcher1, Intake.catcher2);
    Intake.conveyerBelt = new WPI_VictorSPX(Constants.conveyerBelt);
    robotContainer = new RobotContainer();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler. This is responsible for polling buttons, adding
    // newly-scheduled
    // commands, running already-scheduled commands, removing finished or
    // interrupted commands,
    // and running subsystem periodic() methods. This must be called from the
    // robot's periodic
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
    CommandScheduler.getInstance().run();
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = robotContainer.getAutonomousCommand();
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
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {

    Balllauncher.gate.setAngle(175);
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