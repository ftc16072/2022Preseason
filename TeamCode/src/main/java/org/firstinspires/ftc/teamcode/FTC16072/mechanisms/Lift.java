package org.firstinspires.ftc.teamcode.FTC16072.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.FTC16072.tests.QQTest;
import org.firstinspires.ftc.teamcode.FTC16072.tests.TestMotor;
import org.firstinspires.ftc.teamcode.FTC16072.tests.TestServo;

import java.util.Arrays;
import java.util.List;

public class Lift extends Mechanism{
    public DcMotorEx liftMotor;
    public Servo v4b;
    public double retractPosition;
    public double extendPosition;
    public double servoTopPosition = 0.0;
    public double servoMiddlePosition = 0.0;
    public double servoBottomPosition = 0.0;
    public static int max;
    public static int min;
    //TODO: what are max and min values for extending and retracting

    public enum State{
        INTAKE,
        LEVEL1,
        LEVEL2,
        LEVEL3
    }
    @Override
    public void init(HardwareMap hwMap) {
        liftMotor = hwMap.get(DcMotorEx.class, "Lift");

        v4b = hwMap.get(Servo.class, "v4b");
    }

    @Override
    public List<QQTest> getTests() {
        return Arrays.asList(
                new TestMotor(liftMotor, "Lift_Up", 0.2),
                new TestMotor(liftMotor, "Lift_Down", -0.2),
                new TestServo(v4b, "v4b", 0.2,0)
                //TODO:review the above
        );
    }
    public void stopMotor() {
        liftMotor.setPower(0);
    }

    public double getLiftPosition() {
        return liftMotor.getCurrentPosition();
    }

    public void retract(double power){
        liftMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        if(canRetract()==true){
            liftMotor.setPower(power);
        }
    }
    public void extend(double power){
        liftMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        if(canExtend()==true){
            liftMotor.setPower(power);
        }
    }
    public void extendVirtual4Bar(){
        v4b.setPosition(servoBottomPosition);
    }
    public boolean canRetract(){
        if(liftMotor.getCurrentPosition() > min){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean canExtend(){
        if(liftMotor.getCurrentPosition() < max){
            return true;
        }
        else{
            return false;
        }
    }


}
