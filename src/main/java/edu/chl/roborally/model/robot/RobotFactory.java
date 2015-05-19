package edu.chl.roborally.model.robot;

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
                return new Robot("Twitch");
            case 1:
                return new Robot("Hank The Tank");
            case 2:
                return new Robot("Frellster");
            default:
                return new Robot("Dummy");
        }
    }

}
