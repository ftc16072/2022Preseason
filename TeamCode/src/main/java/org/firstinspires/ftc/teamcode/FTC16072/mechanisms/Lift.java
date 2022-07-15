package org.firstinspires.ftc.teamcode.FTC16072.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.FTC16072.tests.QQTest;

import java.util.List;

public class Lift extends Mechanism{
    public DcMotorEx liftMotor;
    public Servo v4b;
    @Override
    public void init(HardwareMap hwMap) {
        liftMotor = hwMap.get(DcMotorEx.class, "Lift");
        //liftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        v4b = hwMap.get(Servo.class, "v4b");
    }

    @Override
    public List<QQTest> getTests() {
        return null;
    }
}
