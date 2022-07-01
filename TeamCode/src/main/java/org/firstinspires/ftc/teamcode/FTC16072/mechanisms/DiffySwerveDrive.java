package org.firstinspires.ftc.teamcode.FTC16072.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.FTC16072.DiffySwerveBot;
import org.firstinspires.ftc.teamcode.FTC16072.tests.QQTest;

import java.util.List;

public class DiffySwerveDrive extends Mechanism{

    DiffySwerveModule LeftModule;
    DiffySwerveModule RightModule;

    @Override
    public void init(HardwareMap hwMap) {
        LeftModule = new DiffySwerveModule(hwMap, "top_motor_left","bottom_motor_left");
        RightModule = new DiffySwerveModule(hwMap, "top_motor_right", "bottom_motor_right");
    }

    public void drive(double joystickY, double joystickX){
        LeftModule.rotate(joystickX);
        RightModule.rotate(joystickX);
        LeftModule.move(joystickY);
        RightModule.move(joystickY);
    }

    @Override
    public List<QQTest> getTests() {
        return null;
    }
}
