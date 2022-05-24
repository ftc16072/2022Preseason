package org.firstinspires.ftc.teamcode.FTC16072.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.FTC16072.MechanumRobot;
import org.firstinspires.ftc.teamcode.FTC16072.Robot;

@TeleOp()
public class DriveOnly extends OpMode {
    MechanumRobot robot = new MechanumRobot();

    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void loop() {
        robot.mecanumDrive.drive(-gamepad1.left_stick_y, gamepad1.left_stick_x, 0.0);

    }
}
