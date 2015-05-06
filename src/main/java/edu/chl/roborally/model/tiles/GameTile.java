package edu.chl.roborally.model.tiles;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by axel on 2015-03-26.
 */
public abstract class GameTile extends JPanel{

    protected BufferedImage icon;
    protected Color color;

    public GameTile() {
        icon = new BufferedImage(Constants.TILE_SIZE,Constants.TILE_SIZE,BufferedImage.TYPE_INT_RGB);
    }

    public abstract void doAction(Player p);
    public abstract String toString();
    public abstract void appearance();

    @Override
    public void paintComponent(Graphics g) {
        appearance();
        g.fillRect(0, 0, Constants.TILE_SIZE, Constants.TILE_SIZE);
        g.drawImage(icon,0,0,null);
    }
}
