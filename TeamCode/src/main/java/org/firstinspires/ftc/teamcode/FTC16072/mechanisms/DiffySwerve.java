package org.firstinspires.ftc.teamcode.FTC16072.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.FTC16072.tests.QQTest;

import java.util.List;

public class DiffySwerve extends Mechanism {
    DcMotorEx leftPodTop;
    DcMotorEx leftPodBottom;
    DcMotorEx rightPodTop;
    DcMotorEx rightPodBottom;

    @Override
    public void init(HardwareMap hwMap) {
        leftPodTop = hwMap.get(DcMotorEx.class, "left_top_motor");
        leftPodTop.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftPodBottom = hwMap.get(DcMotorEx.class, "left_bottom_motor");
        leftPodBottom.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightPodTop = hwMap.get(DcMotorEx.class, "right_top_motor");
        rightPodTop.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightPodBottom = hwMap.get(DcMotorEx.class, "right_bottom_motor");
        rightPodBottom.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public List<QQTest> getTests() {
        return null;
    }
}
