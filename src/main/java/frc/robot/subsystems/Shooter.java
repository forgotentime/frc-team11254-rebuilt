// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import static frc.robot.Constants.shooterConstants.*;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.config.ClosedLoopConfig;
import com.revrobotics.spark.config.SparkMaxConfig;


public class Shooter extends SubsystemBase {
  private SparkMax motorShooter;
  private SparkMaxConfig motorShooterConfig;
  private SparkClosedLoopController sparkControl;
  private RelativeEncoder encoder;
  
  /** Creates a new Shooter. */
  public Shooter() {
    motorShooter = new SparkMax(SHOOTER, MotorType.kBrushless);
    motorShooterConfig = new SparkMaxConfig();
    sparkControl = motorShooter.getClosedLoopController();
    encoder = motorShooter.getEncoder();

    motorShooterConfig
      .idleMode(IdleMode.kBrake)
      .smartCurrentLimit(60)
      .closedLoop.positionWrappingEnabled(true)
      .pid(.005, 0, 0);

    motorShooter.configure(motorShooterConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }
public void stop(){
  motorShooter.stopMotor();
}
public void spinShoot(){
  motorShooter.set(.4);
}
public void PIDShoot(double fireSpeed){
  sparkControl.setSetpoint(fireSpeed, ControlType.kVelocity);
}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
