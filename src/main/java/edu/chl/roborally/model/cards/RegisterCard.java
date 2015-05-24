package edu.chl.roborally.model.cards;

import edu.chl.roborally.model.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * Created by fredrikkindstrom on 26/03/15.
 */
public abstract class RegisterCard {

    private int points;
    private boolean isHidden;
    private boolean isLocked;
    private String name;
    protected BufferedImage mainImage;
    protected BufferedImage pickImage;
    protected BufferedImage pickImageRollover;

    public RegisterCard(int points, boolean isHidden, String name ) {
        this.points = points;
        this.isHidden = isHidden;
        this.isLocked = false;
        this.name = name;
    }

    /*
    Commands
     */
    public abstract void doAction(Player p);
    public String toString() {
        return name + " (" + points + ")";
    }

    /*
    Getters
     */
    public String getName() {
        return name;
    }
    public int getPoints() {
        return points;
    }
    public ImageIcon getMainIcon() {
        return new ImageIcon(mainImage);
    }
    public ImageIcon getPickIcon() {
        return new ImageIcon(pickImage);
    }
    public ImageIcon getPickIconRollover() {
        return new ImageIcon(pickImageRollover);
    }
    public boolean isLocked() {
        return isLocked;
    }
    public boolean isHidden() {
        return isHidden;
    }

    /*
    Setters
     */
    public void setLocked(boolean b) {
        isLocked = b;
    }
    public void setHidden(boolean b) {
        isHidden = b;
    }
}