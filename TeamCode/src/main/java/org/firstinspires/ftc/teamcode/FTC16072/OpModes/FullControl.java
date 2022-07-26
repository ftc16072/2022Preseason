package org.firstinspires.ftc.teamcode.FTC16072.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.FTC16072.Robot;
import org.firstinspires.ftc.teamcode.FTC16072.mechanisms.Virtual4Bar;
import org.firstinspires.ftc.teamcode.FTC16072.util.Navigation;

@TeleOp()
public class FullControl extends OpMode {
    Robot robot = new Robot();
    Navigation nav = new Navigation(robot);

    final double LIFT_EXTEND_POWER = 0.5;
    final double LIFT_RETRACT_POWER = 0.5;

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
        }else {
            robot.box.close();
        }
        if(gamepad1.dpad_up){
            robot.lift.extend(LIFT_EXTEND_POWER);
        }
        else if(gamepad1.dpad_down){
            robot.lift.retract(LIFT_RETRACT_POWER);
        }
        else{
            robot.lift.stopMotor();
        }
        if(gamepad1.y){
            robot.virtual4Bar.goTo(Virtual4Bar.Position.TOP);
        }
        else if(gamepad1.x){
            robot.virtual4Bar.goTo(Virtual4Bar.Position.BOTTOM);
        }
        else if(gamepad1.a) {
            robot.virtual4Bar.goTo(Virtual4Bar.Position.INTAKE);
        }

        //y is reversed :(
        nav.driveFieldRelative(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
    }
}
