package org.firstinspires.ftc.teamcode.FTC16072.util;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Polar {
    private double x;
    private double y;
    private double theta;
    private double r;

    public Polar(double angle, AngleUnit au, double r){
        this.r = r;
        this.theta = au.toRadians(angle);
        x = r * Math.cos(theta);
        y = r * Math.sin(theta);
    }

    public Polar(double x, double y){
        this.x = x;
        this.y = y;
        theta = Math.atan2(this.y, this.x);
        r = Math.hypot(this.x, this.y);
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getTheta(AngleUnit au){
        return au.fromRadians(theta);
    }

    public double getR(){
        return r;
    }

    public Polar rotate(double angle, AngleUnit au){
        //angle = angle * Math.PI/180;
        return new Polar(theta + au.toRadians(angle), AngleUnit.RADIANS, r);
    }

    public void scaleR(double scale){
        r *= scale;
    }


}
