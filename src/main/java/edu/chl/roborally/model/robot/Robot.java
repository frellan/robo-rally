package edu.chl.roborally.model.robot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by henriknilson on 19/05/15.
 *
 * Creates a robot character to assign to a player.
 */
public class Robot {

    private final String name;
    private final Color color;
    private BufferedImage image;

    /**
     * Gets a name from the RobotFactory class and creates the robot character with that name.
     * @param name The name of the robot character.
     * @param color The color associated with the robot (for prints in the console etc.).
     */
    public Robot(String name, Color color) {
        this.name = name;
        this.color = color;
        switch (name) {
            case "Twitch":
                try {
                    image = ImageIO.read(this.getClass().getClassLoader().getResource("robots/twitch.png"));
                } catch (java.io.IOException | NullPointerException e) {
                    System.out.println("board_tiles.png could not be read");
                }
                break;
            case "Hank The Tank":
                try {
                    image = ImageIO.read(this.getClass().getClassLoader().getResource("robots/hank.png"));
                } catch (java.io.IOException | NullPointerException e) {
                    System.out.println("board_tiles.png could not be read");
                }
                break;
            case "Frellster":
                try {
                    image = ImageIO.read(this.getClass().getClassLoader().getResource("robots/frellster.png"));
                } catch (java.io.IOException | NullPointerException e) {
                    System.out.println("board_tiles.png could not be read");
                }
                break;
            default:
                // No mainImage
                break;
        }
    }

    /*
    Getters
     */

    /**
     * Returns the name of the robot.
     * @return The name of the robot.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the color associated with the robot.
     * @return The color associated with the robot.
     */
    public Color getColor(){return color;}

    /**
     * Returns the image of the robot.
     * @return The image of the robot.
     */
    public BufferedImage getImage() {
        return image;
    }
}
