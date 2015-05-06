package edu.chl.roborally.model.tiles;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by axel on 2015-03-26.
 */
public abstract class GameTile {

    protected Dimension size = new Dimension(Constants.TILE_SIZE,Constants.TILE_SIZE);

    public GameTile() {
    }

    public abstract void doAction(Player p);
    public abstract String toString();
    public abstract void draw(Graphics g, int x, int y);

}
