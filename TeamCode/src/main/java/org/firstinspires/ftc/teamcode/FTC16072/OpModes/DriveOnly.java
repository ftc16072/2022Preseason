package org.firstinspires.ftc.teamcode.FTC16072.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.FTC16072.MechanumRobot;
import org.firstinspires.ftc.teamcode.FTC16072.util.NavigationMecanum;

@TeleOp()
public class DriveOnly extends OpMode {
    MechanumRobot robot = new MechanumRobot();
    NavigationMecanum nav = new NavigationMecanum(robot);


    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void loop() {
        nav.driveFieldRelative(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

    }
}
