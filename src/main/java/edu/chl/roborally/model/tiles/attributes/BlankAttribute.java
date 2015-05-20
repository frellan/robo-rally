package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.StopPlayer;
import edu.chl.roborally.model.tiles.GameTile;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.utilities.LargeImageHolder;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Pertta on 15-05-11.
 */
public class BlankAttribute implements Attribute {

    @Override
    public void beforeAction(Player player) {

    }

    @Override
    public void doAction(Player player) {

    }

    @Override
    public void draw(Graphics g, int x, int y) {
        BufferedImage temp = LargeImageHolder.getInstance().getBoardTileImage().getSubimage(
                4 * Constants.TILE_SIZE, 0, Constants.TILE_SIZE, Constants.TILE_SIZE);
        g.drawImage(temp,x,y,null);
    }
}
