/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
   // The robot's subsystems and commands are defined here...

   public DriveTrainFalcon driveTrain = new DriveTrainFalcon();
   public ArmFalcon arm = new ArmFalcon();

   public Joystick driverLeft = new Joystick(0);
   public Joystick driverRight = new Joystick(1);

   public XboxHandler gunnerController = new XboxHandler(2);

   /**
    * The container for the robot. Contains subsystems, OI devices, and commands.
    */
   public RobotContainer() {
      // Configure the button bindings
      configureButtonBindings();
   }

   /**
    * Getter for the value on the left stick.
    * 
    * @return The y-value of the left Joystick.
    */
   public double getDriverLeft() {
      return driverLeft.getRawAxis(1);
   }

   /**
    * Getter for the value on the right stick.
    * 
    * @return The y-value of the right Joystick.
    */
   public double getRightStickValue() {
      return driverRight.getRawAxis(1);
   }

   /**
    * Use this method to define your button->command mappings. Buttons can be
    * created by instantiating a {@link GenericHID} or one of its subclasses
    * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
    * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
    */
   private void configureButtonBindings() {
      gunnerController.leftBumper.whileHeld(new ArmPosUp(arm));
      gunnerController.rightBumper.whileHeld(new ArmPosDown(arm));
   }

   /**
    * Use this to pass the autonomous command to the main {@link Robot} class.
    *
    * @return the command to run in autonomous
    */
   public Command getAutonomousCommand() {
      // An ExampleCommand will run in autonomous
      return null;
   }
}
