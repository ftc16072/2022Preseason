package org.firstinspires.ftc.teamcode.FTC16072.util;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Polar {
    private double x_cm;
    private double y_cm;
    private double theta;
    private double r;

    public Polar(double angle, AngleUnit au, double r, DistanceUnit du){
        this.r = du.toCm(r);
        this.theta = au.toRadians(angle);
        x_cm = r * Math.cos(theta);
        y_cm = r * Math.sin(theta);
    }

    public Polar(double x, double y, DistanceUnit du){
        this.x_cm = du.toCm(x);
        this.y_cm = du.toCm(y);
        theta = Math.atan2(y_cm, x_cm);
        r = Math.hypot(x_cm, y_cm);
    }

    public double getX(DistanceUnit du){
        return du.fromCm(x_cm);
    }

    public double getY(DistanceUnit du){
        return du.fromCm(y_cm);
    }

    public double getTheta(AngleUnit au){
        return au.fromRadians(theta);
    }

    public double getR(DistanceUnit du){
        return du.fromCm(r);
    }

    public Polar rotate(double angle, AngleUnit au){
        //angle = angle * Math.PI/180;
        return new Polar(theta + au.toRadians(angle), AngleUnit.RADIANS, r, DistanceUnit.CM);
    }

    public void scaleR(double scale){
        r *= scale;
    }


}
