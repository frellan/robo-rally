package edu.chl.roborally.model.robot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by henriknilson on 19/05/15.
 */
public class Robot {

    private String name;
    private Color color;
    private BufferedImage image;

    public Robot(String name, Color color) {
        this.name = name;
        this.color = color;
        if (name.equals("Twitch")) {
            try {
                image = ImageIO.read(this.getClass().getClassLoader().getResource("robots/twitch.png"));
            } catch (java.io.IOException | NullPointerException e){
                System.out.println("board_tiles.png could not be read");
            }
        }
        if (name.equals("Hank The Tank")) {
            try {
                image = ImageIO.read(this.getClass().getClassLoader().getResource("robots/hank.png"));
            } catch (java.io.IOException | NullPointerException e){
                System.out.println("board_tiles.png could not be read");
            }
        }
        if (name.equals("Frellster")) {
            try {
                image = ImageIO.read(this.getClass().getClassLoader().getResource("robots/frellster.png"));
            } catch (java.io.IOException | NullPointerException e){
                System.out.println("board_tiles.png could not be read");
            }
        } else {
            // No mainImage
        }
    }

    public String getName() {
        return name;
    }
    public Color getColor(){return color;}
    public BufferedImage getImage() {
        return image;
    }
}
