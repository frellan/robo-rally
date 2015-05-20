package edu.chl.roborally.model.cards;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by fredrikkindstrom on 26/03/15.
 */
public abstract class RegisterCard {

    private int points;
    private boolean isHidden;
    private boolean isLocked;
    private String name;
    protected BufferedImage image;

    private static final int CARD_WIDTH = 96;
    private static final int CARD_HEIGHT = 145;

    public RegisterCard(int points, boolean isHidden, String name ) {
        this.points = points;
        this.isHidden = isHidden;
        this.isLocked = false;
        this.name = name;
    }

    public abstract void doAction(Player p);

    public ImageIcon getIcon() {
        return new ImageIcon(image);
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public boolean getHidden() {
        return isHidden;
    }

    public void setHidden(boolean b) {
        isHidden = b;
    }

    public boolean getLocked() {
        return isLocked;
    }

    public void setLocked(boolean b) {
        isLocked = b;
    }

    public String toString() {
        return name + " (" + points + ")";
    }

}