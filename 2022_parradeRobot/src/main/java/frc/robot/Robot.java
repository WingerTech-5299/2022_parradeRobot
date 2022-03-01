// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  //Motor Controllers
  WPI_VictorSPX Cont_DriveL = new WPI_VictorSPX(10);
  WPI_VictorSPX Cont_DriveR = new WPI_VictorSPX(11);

  WPI_TalonSRX Cont_Shoulder = new WPI_TalonSRX(12);
  WPI_TalonSRX Cont_Elbow = new WPI_TalonSRX(13);
  CANSparkMax Cont_Winch = new CANSparkMax(14, MotorType.kBrushed);


  //Drivetrain
  DifferentialDrive drive = new DifferentialDrive(Cont_DriveL, Cont_DriveR);

  //Input Devices
  XboxController xbox = new XboxController(0);

  Joystick joy_R = new Joystick(1);
  Joystick joy_L = new Joystick(2);

  //Buttons
  Double btn_DriveFB;
  Double btn_DriveSpin;

  Double btn_DriveR;
  Double btn_DriveL;

  @Override
  public void robotInit() {
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {

    
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {

    btn_DriveFB = xbox.getRawAxis(0);
    btn_DriveSpin = xbox.getRawAxis(5);

    btn_DriveR = joy_R.getRawAxis(1);
    btn_DriveL = joy_L.getRawAxis(1);

    Cont_DriveR.set(0.8*btn_DriveR);
    Cont_DriveL.set(0.8*btn_DriveL);

    drive.arcadeDrive(-0.8*btn_DriveFB, 0.8*btn_DriveSpin);
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
