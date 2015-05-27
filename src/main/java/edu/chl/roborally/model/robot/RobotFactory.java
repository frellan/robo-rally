package edu.chl.roborally.model.robot;

import java.awt.*;

/**
 * Created by henriknilson on 19/05/15.
 */
public class RobotFactory {

    private static RobotFactory instance;

    private RobotFactory() {}

    public static RobotFactory getInstance() {
        if (instance == null) {
            instance = new RobotFactory();
        }
        return instance;
    }

    /**
     * Constructs a robot character according to its id.
     * @param id The id of the robot character to create.
     * @return The created robot.
     */
    public Robot constructRobot(int id) {
        switch (id) {
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
