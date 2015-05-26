package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.gameactions.GameAction;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.MovePlayer;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.GlobalImageHolder;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by axel on 2015-03-30.
 */
public class ConveyorAttribute extends Attribute {

    private Constants.Directions d;

    public ConveyorAttribute(Constants.Directions d, int speed){
        this.d = d;

        if (speed == 2) {
            //TODO If player is outside conveyer don't move two steps!
            super.setAction(new MovePlayer(d));
            super.setAction(new MovePlayer(d));
        } else {
            super.setAction(new MovePlayer(d));
        }
    }

    public String toString() {
        return "Conveyor";
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        BufferedImage allTiles = GlobalImageHolder.getInstance().getBoardTileImage();
        BufferedImage currentTile;
        switch (d) {
            case EAST:
                currentTile = allTiles.getSubimage(
                        3*Constants.TILE_SIZE, 6*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
            case WEST:
                currentTile = allTiles.getSubimage(
                        2*Constants.TILE_SIZE, 6*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
            case NORTH:
                currentTile = allTiles.getSubimage(
                        0, 6*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
            case SOUTH:
                currentTile = allTiles.getSubimage(
                        Constants.TILE_SIZE, 6*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
            case NORTH_WEST:
                currentTile = allTiles.getSubimage(
                        Constants.TILE_SIZE, 4*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
            case NORTH_EAST:
                currentTile = allTiles.getSubimage(
                        2*Constants.TILE_SIZE, 4*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
            case SOUTH_WEST:
                currentTile = allTiles.getSubimage(
                        3*Constants.TILE_SIZE, 5*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
            case SOUTH_EAST:
                currentTile = allTiles.getSubimage(
                        0, 5*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
            case WEST_NORTH:
                currentTile = allTiles.getSubimage(
                        0, 5*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
            case WEST_SOUTH:
                currentTile = allTiles.getSubimage(
                        3*Constants.TILE_SIZE, 4*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
            case EAST_NORTH:
                currentTile = allTiles.getSubimage(
                        2*Constants.TILE_SIZE, 5*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
            case EAST_SOUTH:
                currentTile = allTiles.getSubimage(
                        0, 4*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
        }
    }
}


