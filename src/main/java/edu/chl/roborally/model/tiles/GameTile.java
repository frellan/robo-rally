package edu.chl.roborally.model.tiles;

import edu.chl.roborally.model.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by axel on 2015-03-26.
 */
public abstract class GameTile {

    protected static final int WITDH = 80;
    protected static final int HEIGHT = 80;
    protected BufferedImage icon;

    public GameTile() {
        icon = new BufferedImage(WITDH,HEIGHT,BufferedImage.TYPE_INT_RGB);
    }

    public abstract void doAction(Player p);
    public abstract String toString();
    public abstract void appearance();

    public void draw() {
        Graphics2D g = (Graphics2D)icon.getGraphics();
    }
}
