package org.firstinspires.ftc.teamcode.FTC16072.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.FTC16072.Robot;

@TeleOp()
public class LiftTesting extends OpMode {
    Robot robot = new Robot();


    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addLine(String.valueOf(robot.lift.getLiftPosition()));
        //telemetry.addLine(String.valueOf(robot.lift.currentV4bPosition()));
        if (gamepad1.dpad_left) {// && robot.lift.getLiftPosition() > robot.lift.intakePosition ){
            robot.lift.retract(0.5);
        }else if (gamepad1.dpad_right) {//&& robot.lift.getLiftPosition() < robot.lift.extendPosition){
            robot.lift.extend(-0.5);
        } else {
            robot.lift.stopMotor();
        }
        if (gamepad1.dpad_up) {
            robot.box.open();
        } else {
            robot.box.close();
        }
        if (gamepad1.b) {
            robot.lift.intakeVirtual4Bar();
        } else if (gamepad1.a) {
            robot.lift.extendVirtual4BarBottom();
        } else if (gamepad1.y) {
            robot.lift.extendVirtual4BarMiddle();
        } else if (gamepad1.x) {
            robot.lift.extendVirtual4BarTop();
        }

        //TODO: Add rotate controls to gamepad
        //y is reversed :(
        //robot.mecanumDrive.drive(-gamepad1.left_stick_y, gamepad1.left_stick_x, 0.0);

    }
}
