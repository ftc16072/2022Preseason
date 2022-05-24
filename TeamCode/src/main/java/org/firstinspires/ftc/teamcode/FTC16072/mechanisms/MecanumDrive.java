package org.firstinspires.ftc.teamcode.FTC16072.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.FTC16072.tests.QQTest;
import org.firstinspires.ftc.teamcode.FTC16072.tests.TestMotor;

import java.util.Arrays;
import java.util.List;

public class MecanumDrive extends Mechanism {
    DcMotorEx leftFront;
    DcMotorEx rightFront;
    DcMotorEx leftRear;
    DcMotorEx rightRear;

    @Override
    public void init(HardwareMap hwMap) {
        leftFront = hwMap.get(DcMotorEx.class, "left_motor_front");
        leftRear = hwMap.get(DcMotorEx.class, "left_motor_back");
        rightRear = hwMap.get(DcMotorEx.class, "right_motor_back");
        rightFront = hwMap.get(DcMotorEx.class, "right_motor_front");
        rightRear.setDirection(DcMotorSimple.Direction.REVERSE);
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public List<QQTest> getTests() {
        return Arrays.asList(
                new TestMotor(leftFront, "Left Front", 0.2),
                new TestMotor(rightFront, "Right Front", 0.2),
                new TestMotor(leftRear, "Left Rear", 0.2),
                new TestMotor(rightRear, "Right Rear", 0.2)
        );
    }

    public void drive(double forward, double right, double rotate) {
        double leftFrontPower = forward + right + rotate;
        double rightFrontPower = forward - right - rotate;
        double rightRearPower = forward + right - rotate;
        double leftRearPower = forward - right + rotate;
        double maxPower = 1.0;

        maxPower = Math.max(maxPower, Math.abs(leftFrontPower));
        maxPower = Math.max(maxPower, Math.abs(rightFrontPower));
        maxPower = Math.max(maxPower, Math.abs(rightRearPower));
        maxPower = Math.max(maxPower, Math.abs(leftRearPower));

        leftFront.setPower(leftFrontPower/maxPower);
        rightFront.setPower((rightFrontPower/maxPower));
        rightRear.setPower(rightRearPower/maxPower);
        leftRear.setPower((leftRearPower/maxPower));
    }
}
