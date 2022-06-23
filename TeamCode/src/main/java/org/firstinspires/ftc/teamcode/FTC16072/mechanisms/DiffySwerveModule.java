package org.firstinspires.ftc.teamcode.FTC16072.mechanisms;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.FTC16072.tests.QQTest;

import java.util.List;

public class DiffySwerveModule extends Mechanism {
    DcMotorEx topMotor;
    DcMotorEx bottomMotor;

    private double currentAngle;
    private double targetAngle;
    private boolean rotating;

    private double encoderConstant;
    //TODO: find this out in meeting

    @Override
    public void init(HardwareMap hwMap) {
        topMotor = hwMap.get(DcMotorEx.class, "top_motor");
        topMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bottomMotor = hwMap.get(DcMotorEx.class, "bottom_motor");
        bottomMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public boolean isRotating(){
        if(currentAngle!=targetAngle){
            return true;
        }
        else {
            return false;
        }

    }
    public void rotate(double angle){
        if(!this.rotating){
            targetAngle = angle;
            this.rotating=true;
            rotate(targetAngle);
        }
        //TODO:figure out why this happens
        else {
            rotate(targetAngle);
            topMotor.setPower(0.5);
            bottomMotor.setPower(0.5);
        }

        if(this.currentAngle==this.targetAngle){
            rotating = false;
        }
    }

    private double getAngle(AngleUnit au) {
        return au.toRadians(this.currentAngle);
    }

    private double ticksToAngle(double ticks) {
        double au = ticks * encoderConstant;
        return au;
//TODO: Meeting task
    }

    @Override
    public List<QQTest> getTests() {
        return null;
    }
}
