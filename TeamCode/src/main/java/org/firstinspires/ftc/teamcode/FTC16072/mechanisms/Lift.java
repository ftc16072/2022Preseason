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
    //these are for slides
    public double intakePosition = 0.0;
    public double retractPosition = 0.2;
    public double middlePosition = 0.7;
    public double extendPosition = 1.0;
    //servo positions are v4b levels for shipping hub
    public double servoIntakePosition = 0.0;
    public double servoTopPosition = 0.3;
    public double servoMiddlePosition = 0.7;
    public double servoBottomPosition = 1.0;
    //TODO: find the real values for the position
    public static int slidesMax;
    public static int slidesMin;
    //TODO: what are max and min values for extending and retracting
    public State state = State.INTAKE;

    public enum State{
        INTAKE,
        LEVEL1,
        LEVEL2,
        LEVEL3
    }

    @Override
    public void init(HardwareMap hwMap) {
        liftMotor = hwMap.get(DcMotorEx.class, "lift");

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
    //stops motor
    public void stopMotor() {
        liftMotor.setPower(0);
    }
    //accesor method
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
    public void extendVirtual4BarBottom(){
        v4b.setPosition(servoBottomPosition);
    }
    public void extentVirtual4BarMiddle(){
        v4b.setPosition(servoMiddlePosition);
    }
    public void extendVirtual4BarTop(){
        v4b.setPosition(servoTopPosition);
    }
    public void intakeVirtual4Bar(){
        v4b.setPosition(servoIntakePosition);
    }
    public boolean canRetract(){
        if(liftMotor.getCurrentPosition() > slidesMin){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean canExtend(){
        if(liftMotor.getCurrentPosition() < slidesMax){
            return true;
        }
        else{
            return false;
        }
    }

    public double getSlidePosition(){
        switch(state){
            case INTAKE:
                return intakePosition;
            case LEVEL1:
                return retractPosition;
            case LEVEL2:
                return middlePosition;
            case LEVEL3:
            default:
                return extendPosition;
        }
    }

    public double getV4bPosition(){
        switch (state){
            case INTAKE:
                return servoIntakePosition;
            case LEVEL1:
                return servoBottomPosition;
            case LEVEL2:
                return servoMiddlePosition;
            case LEVEL3:
            default:
                return servoTopPosition;
        }
    }


}
