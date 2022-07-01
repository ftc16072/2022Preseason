package org.firstinspires.ftc.teamcode.FTC16072.mechanisms;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.FTC16072.tests.QQTest;
import org.firstinspires.ftc.teamcode.FTC16072.tests.TestCRServo;

import java.util.Arrays;
import java.util.List;

public class DSArm extends Mechanism{
    DcMotor front;
    DcMotor back;
    @Override
    public void init(HardwareMap hwMap) {
    }

    @Override
    public List<QQTest> getTests() {
        return null;
    }
}
