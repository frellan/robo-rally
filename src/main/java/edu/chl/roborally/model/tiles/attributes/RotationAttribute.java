package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.gameactions.RotatePlayer;
import edu.chl.roborally.utilities.GlobalImageHolder;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by axel on 2015-03-30.
 */
public class RotationAttribute extends Attribute {

    private final Constants.Directions direction;

    public RotationAttribute(Constants.Directions direction){
        this.direction = direction;
        super.setAction(new RotatePlayer(direction));
        tileMessage = "Rotated " + direction;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        BufferedImage allTiles = GlobalImageHolder.getInstance().getBoardTileImage();
        BufferedImage currentTile;
        switch (direction) {
            case WEST:
                currentTile = allTiles.getSubimage(
                        4*Constants.TILE_SIZE, 6*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
            case EAST:
                currentTile = allTiles.getSubimage(
                        5*Constants.TILE_SIZE, 6*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
        }
    }

}
