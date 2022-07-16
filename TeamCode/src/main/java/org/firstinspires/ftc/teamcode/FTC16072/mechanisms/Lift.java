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
}
