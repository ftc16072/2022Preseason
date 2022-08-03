package org.firstinspires.ftc.teamcode.FTC16072.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.FTC16072.MechanumRobot;
import org.firstinspires.ftc.teamcode.FTC16072.Robot;
import org.firstinspires.ftc.teamcode.FTC16072.util.NavigationMecanum;

@TeleOp()
public class Driving extends OpMode {
    // Robot robot = new Robot();
    MechanumRobot robot = new MechanumRobot();
    NavigationMecanum nav = new NavigationMecanum(robot);

    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void loop() {
        //left intake
        if (gamepad1.left_bumper) {
            robot.frontIntake.start(0.7);
        } else {
            robot.frontIntake.stop();
        }
        //right intake
        if (gamepad1.right_bumper) {
            robot.backIntake.start(-0.7);
        } else {
            robot.backIntake.stop();
        }
        //duck spinner
        if (gamepad1.a || gamepad2.a) {
            robot.frontDuckSpinner.start();
            robot.backDuckSpinner.start();
        } else {
            robot.frontDuckSpinner.stop();
            robot.backDuckSpinner.stop();
        }

        //box
        if (gamepad1.b) {
            robot.box.open();
        } else {
            robot.box.close();
        }
        //lift
        if (gamepad1.dpad_down) {
            robot.lift.intakeVirtual4Bar();
            robot.lift.retract(0.5);
        } else if (gamepad1.dpad_up) {
            robot.lift.extendVirtual4BarTop();
            robot.lift.extend(-0.5);
        } else {
            robot.lift.stopMotor();
        }
//outtake
        if (gamepad1.x) {
            robot.backIntake.start(0.7);
            robot.frontIntake.start(-0.7);
        }/*else{
            robot.frontIntake.stop();
            robot.backIntake.stop();
        }*/
        if (gamepad2.left_bumper || gamepad2.right_bumper) {
            robot.backIntake.start(0.7);
            robot.frontIntake.start(-0.7);
        }
        //v4b middle position
        if (gamepad1.y) {
            robot.lift.extendVirtual4BarMiddle();
        }

        //TODO: Add rotate controls to gamepad
        //y is reversed :(
        // robot.mecanumDrive.drive(-gamepad1.left_stick_y, gamepad1.left_stick_x, 0.0);
        nav.driveFieldRelative(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

    }
}
