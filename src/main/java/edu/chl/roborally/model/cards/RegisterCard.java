package edu.chl.roborally.model.cards;

import edu.chl.roborally.model.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by fredrikkindstrom on 26/03/15.
 */
public abstract class RegisterCard {

    private int points;
    private boolean isHidden;
    private String name;
    protected BufferedImage image;

    public RegisterCard(int points, boolean isHidden, String name ) {
        this.points = points;
        this.isHidden = isHidden;
        this.name = name;
    }

    public abstract void doAction(Player p);

    public int getPoints() {
        return points;
    }

    public boolean getHidden() {
        return isHidden;
    }

    public void setHidden(boolean b) {
        isHidden = b;
    }

    public String toString() {
        return name + " " + "Points: " + points;
    }

    public void draw(Graphics g, int x, int y){
        g.drawImage(image,x,y,null);
        g.drawChars(name.toCharArray(),0, name.length(), x + 20, y + 30);
    }
}