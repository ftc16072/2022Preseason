package org.firstinspires.ftc.teamcode.FTC16072;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.FTC16072.mechanisms.Box;
import org.firstinspires.ftc.teamcode.FTC16072.mechanisms.DuckSpinner;
import org.firstinspires.ftc.teamcode.FTC16072.mechanisms.Gyro;
import org.firstinspires.ftc.teamcode.FTC16072.mechanisms.Intake;
import org.firstinspires.ftc.teamcode.FTC16072.mechanisms.MecanumDrive;
import org.firstinspires.ftc.teamcode.FTC16072.mechanisms.Mechanism;
import org.firstinspires.ftc.teamcode.FTC16072.mechanisms.Virtual4Bar;

import java.util.Arrays;
import java.util.List;

public class MechanumRobot {
    public MecanumDrive mecanumDrive=new MecanumDrive();
    public Gyro gyro = new Gyro();

    List<Mechanism> mechanismList = Arrays.asList(
            mecanumDrive,
            gyro
    );
    public void init (HardwareMap hwMap){
        for(Mechanism mechanism : mechanismList){
            mechanism.init(hwMap);
        }
    }
    public List<Mechanism> getMechanismList(){
        return mechanismList;
    }

}
