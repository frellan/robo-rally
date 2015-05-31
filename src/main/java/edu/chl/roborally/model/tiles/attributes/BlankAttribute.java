package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.utilities.GlobalImageHolder;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Pertta on 15-05-11.
 *
 * Represents a blank tile, just a place to go, nothing happens.
 */
public class BlankAttribute extends Attribute {

    @Override
    public void draw(Graphics g, int x, int y) {
        BufferedImage temp = GlobalImageHolder.getInstance().getBoardTileImage().getSubimage(
                4*Constants.TILE_SIZE, 0, Constants.TILE_SIZE, Constants.TILE_SIZE);
        g.drawImage(temp,x,y,null);
    }
}
