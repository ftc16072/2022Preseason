package org.firstinspires.ftc.teamcode.FTC16072.tests;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class TestColorSensor extends QQTest{
    RevColorSensorV3 colorSensor;


    public TestColorSensor(String description, RevColorSensorV3 colorSensor){
        super(description);
        this.colorSensor = colorSensor;
    }

    @Override
    public void run(boolean on, Telemetry telemetry) {
       telemetry.addData("ARGB", colorSensor.argb());
       telemetry.addData("Distance", colorSensor.getDistance(DistanceUnit.CM));

    }
}
