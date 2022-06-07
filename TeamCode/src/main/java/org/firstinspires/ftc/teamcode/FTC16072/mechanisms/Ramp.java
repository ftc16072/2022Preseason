package org.firstinspires.ftc.teamcode.FTC16072.mechanisms;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.FTC16072.tests.QQTest;
import org.firstinspires.ftc.teamcode.FTC16072.tests.TestColorSensor;
import org.firstinspires.ftc.teamcode.FTC16072.tests.TestServo;

import java.util.Arrays;
import java.util.List;

public class Ramp extends Mechanism{
    private RevColorSensorV3 colorSensor;

    @Override
    public void init(HardwareMap hwMap) {
        colorSensor = hwMap.get(RevColorSensorV3.class, "ramp_tracker");
    }

    @Override
    public List<QQTest> getTests() {
        return Arrays.asList(
                new TestColorSensor("Ramp Color Sensor", colorSensor)
        );
    }
}
