package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.ftc16072.tests.QQTest;
import org.firstinspires.ftc.teamcode.ftc16072.util.Polar;

import java.util.ArrayList;
import java.util.List;

public class DiffySwerveDrive extends Mechanism {

    DiffySwerveModule leftModule;
    DiffySwerveModule rightModule;

    public DiffySwerveDrive(){
        leftModule = new DiffySwerveModule("left_motor");
        rightModule = new DiffySwerveModule("right_motor");
    }

    @Override
    public void init(HardwareMap hwMap) {
        leftModule.init(hwMap);
        rightModule.init(hwMap);
    }


    private void setPowers(double steerLeft, double steerRight, double driveLeft, double driveRight){
        double topLeftPower = steerLeft + driveLeft;
        double bottomLeftPower = steerLeft - driveLeft;

        double topRightPower = steerRight - driveRight;
        double bottomRightPower = steerRight + driveRight;

        double maxPower = 1.0;

        maxPower = Math.max(maxPower, Math.abs(topLeftPower));
        maxPower = Math.max(maxPower, Math.abs(bottomLeftPower));
        maxPower = Math.max(maxPower, Math.abs(topRightPower));
        maxPower = Math.max(maxPower, Math.abs(bottomRightPower));

        leftModule.setPowers(topLeftPower/maxPower, bottomLeftPower/maxPower);
        rightModule.setPowers(topRightPower/maxPower, bottomRightPower/maxPower);
    }

    public void drive(double forward, double strafe, double rotate){
        double offsetLeft = 0;
        double offsetRight = 0;

        double wheelSpeed = Math.sqrt((forward*forward) + (strafe*strafe));
        double steer = AngleUnit.normalizeDegrees(AngleUnit.RADIANS.toDegrees(Math.atan2(forward, strafe)) - 90);

        if(wheelSpeed > 0.1){
            offsetLeft = leftModule.getOffset(steer, AngleUnit.DEGREES);
            offsetRight = rightModule.getOffset(steer, AngleUnit.DEGREES);
        }
        double steerLeftPower = Range.scale(offsetLeft, -90, 90, -1.25, 1.25);
        double steerRightPower = Range.scale(offsetRight, -90, 90, -1.25, 1.25);

        double driveLeftPower = leftModule.modifySpeed(wheelSpeed + rotate);
        double driveRightPower = rightModule.modifySpeed(wheelSpeed - rotate);

        setPowers(steerLeftPower, steerRightPower, driveLeftPower, driveRightPower);
    }

    @Override
    public List<QQTest> getTests() {
        List<QQTest> result = new ArrayList<>();

        result.addAll(leftModule.getTests());
        result.addAll(rightModule.getTests());

        return result;
    }
}
