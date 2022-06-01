package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.ftc16072.Robot;
import org.firstinspires.ftc.teamcode.ftc16072.util.Navigation;

@TeleOp()
public class FieldRelativeDriving extends OpMode {
    Robot robot = new Robot();
    Navigation nav = new Navigation(robot);

    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void loop() {
        if(gamepad1.right_bumper){
            robot.frontIntake.start();
        }else{
            robot.frontIntake.stop();
        }
        if(gamepad1.left_bumper){
            robot.backIntake.start();
        }else{
            robot.backIntake.stop();
        }
        if(gamepad1.a){
            robot.frontDuckSpinner.start();
            robot.backDuckSpinner.start();
        }else{
            robot.frontDuckSpinner.stop();
            robot.backDuckSpinner.stop();
        }
        if(gamepad1.b){
            robot.box.open();
        }else{
            robot.box.close();
        }
        //TODO: Add rotate controls to gamepad
        //y is reversed :(
        nav.driveFieldRelative(-gamepad1.left_stick_y, gamepad1.left_stick_x, 0.0);

    }
}
