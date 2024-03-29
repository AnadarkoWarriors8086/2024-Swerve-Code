// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.OIConstants;
import frc.robot.commands.SwerveJoystickCmd;
import frc.robot.subsystems.SwerveSubsystem;

public class RobotContainer {
private final SwerveSubsystem swerveSub = new SwerveSubsystem();

    private final XboxController driverJoystick = new XboxController(0);

    public RobotContainer() {
        swerveSub.setDefaultCommand(new SwerveJoystickCmd(
                swerveSub,
                () -> -driverJoystick.getRawAxis(OIConstants.kDriverYAxis),
                () -> driverJoystick.getRawAxis(OIConstants.kDriverXAxis),
                () -> driverJoystick.getRawAxis(OIConstants.kDriverRotAxis),
                () -> !driverJoystick.getRawButton(OIConstants.kDriverFieldOrientedButtonIdx)));

        configureButtonBindings();
    }

    private void configureButtonBindings() {
        new JoystickButton(driverJoystick, 2).onTrue(swerveSub.runOnce(swerveSub::zeroHeading));
    }
    
  
          

          
  
        
            

      public Command getAutonomousCommand() {
        return null;
      }
}
