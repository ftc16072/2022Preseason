package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.ftc16072.tests.QQTest;
import org.firstinspires.ftc.teamcode.ftc16072.tests.TestMotor;

import java.util.Arrays;
import java.util.List;

public class DiffySwerveModule extends Mechanism {

    static final double TICKS_PER_ROTATION = 560;
    boolean reversed;

    DcMotorEx topMotor;
    DcMotorEx bottomMotor;

    private String suffix;

    public DiffySwerveModule(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public void init(HardwareMap hwMap) {
        topMotor = hwMap.get(DcMotorEx.class, "top_" + suffix);
        topMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        topMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        bottomMotor = hwMap.get(DcMotorEx.class, "bottom_" + suffix);
        bottomMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bottomMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public double modifySpeed(double speed){
        if(reversed){
            speed = speed * -1;
        }
        return speed;
    }

    public double getAngle(AngleUnit au){
        double currentAngle = 180 * (topMotor.getCurrentPosition() + bottomMotor.getCurrentPosition())
                / (4.0 * TICKS_PER_ROTATION);
        if(reversed){
            currentAngle += 180;
        }
        return au.fromDegrees(currentAngle);
    }

    public double getOffset(double newAngle,AngleUnit au){
        double currentAngle = getAngle(AngleUnit.DEGREES);
        double offsetDegrees = AngleUnit.normalizeDegrees(au.toDegrees(newAngle) - currentAngle);

        if(Math.abs(offsetDegrees) > 90){
            reversed = !reversed;
            offsetDegrees = AngleUnit.normalizeDegrees(offsetDegrees + 180);
        }
        return au.fromDegrees(offsetDegrees);
    }

    public void setPowers(double topPower, double bottomPower){
        topMotor.setPower(topPower);
        bottomMotor.setPower(bottomPower);
    }


    @Override
    public List<QQTest> getTests() {
        return Arrays.asList(
                new TestMotor(topMotor, "Top_" + suffix, 0.2),
                new TestMotor(bottomMotor, "Bottom_" + suffix, 0.2)
        );

    }
}
