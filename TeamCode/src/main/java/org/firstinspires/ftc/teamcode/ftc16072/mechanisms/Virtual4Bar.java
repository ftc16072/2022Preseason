package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.ftc16072.tests.QQTest;
import org.firstinspires.ftc.teamcode.ftc16072.tests.TestServo;

import java.util.Arrays;
import java.util.List;

public class Virtual4Bar extends Mechanism{
    Servo arm;
    final static double TOP = 0.3;
    final static double MIDDLE = 0.35;
    final static double BOTTOM = 0.55;
    final static double INTAKE = .95;
    public enum Position{
        TOP,
        MIDDLE,
        BOTTOM,
        INTAKE;
    }


    @Override
    public void init(HardwareMap hwMap) {
        arm = hwMap.get(Servo.class, "v4b");
    }

    public void goTo(Position position){
        switch(position){
            case TOP:
                arm.setPosition(TOP);
                break;
            case MIDDLE:
                arm.setPosition(MIDDLE);
                break;
            case BOTTOM:
                arm.setPosition(BOTTOM);
                break;
            case INTAKE:
                arm.setPosition(INTAKE);
                break;
        }
    }


    @Override
    public List<QQTest> getTests() {
        return Arrays.asList(
                new TestServo(arm, "v4b", TOP, INTAKE)
        );
    }
}
