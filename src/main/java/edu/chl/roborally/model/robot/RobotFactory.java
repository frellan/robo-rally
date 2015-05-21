package edu.chl.roborally.model.robot;

import java.awt.*;

/**
 * Created by henriknilson on 19/05/15.
 */
public class RobotFactory {

    private static RobotFactory robotFactory;

    public static RobotFactory getInstance() {
        if (robotFactory == null) {
            robotFactory = new RobotFactory();
        }

        return robotFactory;
    }

    public Robot constructRobot(int i) {
        switch (i) {
            case 0:
                return new Robot("Twitch", Color.GREEN);
            case 1:
                return new Robot("Hank The Tank", Color.CYAN);
            case 2:
                return new Robot("Frellster", Color.ORANGE);
            default:
                return new Robot("Dummy", Color.PINK);
        }
    }

}
