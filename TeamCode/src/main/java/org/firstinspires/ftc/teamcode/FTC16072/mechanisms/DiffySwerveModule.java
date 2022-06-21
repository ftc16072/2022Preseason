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

    private double angle;

    @Override
    public void init(HardwareMap hwMap) {
        topMotor = hwMap.get(DcMotorEx.class, "top_motor");
        topMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        bottomMotor = hwMap.get(DcMotorEx.class, "bottom_motor");
        bottomMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    /*public void rotate(double angle){
        if(this.isRotating()==false){
            topMotor.setPower(0.0);
            bottomMotor.setPower(0.0);
        }
        if(this.isRotating()==true){

        }
    }*/

    private double getAngle(AngleUnit au) {
        return this.angle;
    }

    private double ticksToAngle(double ticks) {
        double test = ticks * 2;
        return test;
        //TODO: the above needs to be fixed
    }

    @Override
    public List<QQTest> getTests() {
        return null;
    }
}
