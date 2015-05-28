package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.utilities.GlobalImageHolder;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by axel on 2015-03-31.
 */
public class WallAttribute extends Attribute {

    private Constants.Directions direction;
    private String name = "W";

<<<<<<< HEAD
=======

>>>>>>> version1.0
    public WallAttribute(Constants.Directions direction){
        this.direction = direction;
        //super.setAction(new StopPlayer(direction));
    }

    public Constants.Directions getDirection() {
        return direction;
    }

    public String toString() {
        return name;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        BufferedImage allTiles = GlobalImageHolder.getInstance().getBoardTileImage();
        BufferedImage currentTile;
        switch (direction) {
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
