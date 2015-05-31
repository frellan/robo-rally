package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.gameactions.MovePlayer;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.utilities.GlobalImageHolder;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Pertta on 15-05-12.
 */
public class TurnConveyorAttribute extends Attribute {

    private final Constants.Directions direction;

    public TurnConveyorAttribute(Constants.Directions direction) {
        this.direction = direction;
        super.setAction(new MovePlayer(direction));
        tileMessage = "Moving and Rotating";
    }

    public String toString() {
        return "TurnConveyor";
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        BufferedImage allTiles = GlobalImageHolder.getInstance().getBoardTileImage();
        BufferedImage currentTile;
        switch (direction) {
            case NORTH_WEST:
                currentTile = allTiles.getSubimage(
                        3*Constants.TILE_SIZE, 7*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
            case NORTH_EAST:
                currentTile = allTiles.getSubimage(
                        Constants.TILE_SIZE, 8*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
            case WEST_NORTH:
                currentTile = allTiles.getSubimage(
                        0, 7*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
            case WEST_SOUTH:
                currentTile = allTiles.getSubimage(
                        2*Constants.TILE_SIZE, 8*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
            case SOUTH_WEST:
                currentTile = allTiles.getSubimage(
                        3*Constants.TILE_SIZE, 8*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
            case SOUTH_EAST:
                currentTile = allTiles.getSubimage(
                        Constants.TILE_SIZE, 8*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
            case EAST_NORTH:
                currentTile = allTiles.getSubimage(
                        0, 7*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
            case EAST_SOUTH:
                currentTile = allTiles.getSubimage(
                        2*Constants.TILE_SIZE, 8*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
        }

    }
}
