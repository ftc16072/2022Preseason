package org.firstinspires.ftc.teamcode.FTC16072.util;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.FTC16072.MechanumRobot;
import org.firstinspires.ftc.teamcode.FTC16072.Robot;

public class NavigationMechanum {
    public MechanumRobot robot;

    public NavigationMechanum(MechanumRobot robot){
        this.robot = robot;
    }

    public void driveFieldRelative(double forward, double right, double rotateSpeed){
        double heading = robot.gyro.getHeading(AngleUnit.RADIANS);
        Polar drive = new Polar(right, forward);
        drive.rotate(-heading, AngleUnit.RADIANS);

        robot.mecanumDrive.drive(drive.getY(), drive.getX(), rotateSpeed);
    }

}
