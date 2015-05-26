package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.gameactions.GameAction;
import edu.chl.roborally.model.gameactions.StopPlayer;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.GlobalImageHolder;
import edu.chl.roborally.utilities.WallException;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by axel on 2015-03-31.
 */
public class WallAttribute extends Attribute {

    private Constants.Directions d;
    private String name = "W";

    public WallAttribute(Constants.Directions d){
        this.d = d;
        super.setAction(new StopPlayer());
    }

    public String toString() {
        return name;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        BufferedImage allTiles = GlobalImageHolder.getInstance().getBoardTileImage();
        BufferedImage currentTile;
        switch (d) {
            case EAST:
                currentTile = allTiles.getSubimage(
                        6*Constants.TILE_SIZE, 2*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
            case WEST:
                currentTile = allTiles.getSubimage(
                        5*Constants.TILE_SIZE, 3*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
            case NORTH:
                currentTile = allTiles.getSubimage(
                        6*Constants.TILE_SIZE, 3*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
            case SOUTH:
                currentTile = allTiles.getSubimage(
                        4*Constants.TILE_SIZE, 3*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
        }
    }
}
