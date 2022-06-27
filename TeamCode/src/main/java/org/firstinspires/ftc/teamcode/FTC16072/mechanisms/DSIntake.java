package org.firstinspires.ftc.teamcode.FTC16072.mechanisms;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.FTC16072.tests.QQTest;
import org.firstinspires.ftc.teamcode.FTC16072.tests.TestCRServo;

import java.util.Arrays;
import java.util.List;

public class DSIntake extends Mechanism {
    CRServo intake;

    @Override
    public void init(HardwareMap hwMap) {
        intake = hwMap.get(CRServo.class,"dsIntake"); // config name
    }

    @Override
    public List<QQTest> getTests() {
        return Arrays.asList(
                new TestCRServo(intake, "Diffy Swerve Intake Servo",1 ));
    }

    //add code to power intake

}
