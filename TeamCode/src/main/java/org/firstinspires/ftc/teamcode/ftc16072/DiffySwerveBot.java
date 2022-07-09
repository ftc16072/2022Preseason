package org.firstinspires.ftc.teamcode.ftc16072;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.DiffySwerveDrive;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.Gyro;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.Mechanism;
import org.firstinspires.ftc.teamcode.ftc16072.util.Polar;

import java.util.Arrays;
import java.util.List;

public class DiffySwerveBot {
    public DiffySwerveDrive diffyDrive=new DiffySwerveDrive();
    public Gyro gyro = new Gyro();

    List<Mechanism> mechanismList = Arrays.asList(
            diffyDrive,
            gyro
    );
    public void init (HardwareMap hwMap){
        for(Mechanism mechanism : mechanismList){
            mechanism.init(hwMap);
        }
    }

    public void driveFieldRelative(double forward, double right, double rotateSpeed){
        double heading = gyro.getHeading(AngleUnit.RADIANS);
        Polar drive = new Polar(right, forward);
        drive.rotate(-heading, AngleUnit.RADIANS);

        diffyDrive.drive(drive.getY(), drive.getX(), rotateSpeed);
    }

    public List<Mechanism> getMechanismList(){
        return mechanismList;
    }

}