package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurretLock extends CommandBase {
    public static boolean lockedTarget = false;
    public TurretLock() {
        if (lockedTarget == true){
            lockedTarget = false;
        }else{
            lockedTarget = true;
        }
    }
}
