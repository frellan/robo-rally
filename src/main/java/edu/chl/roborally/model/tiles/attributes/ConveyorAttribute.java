package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.tiles.GameTile;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.MovePlayer;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.LargeImageHolder;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by axel on 2015-03-30.
 */
public class ConveyorAttribute implements Attribute {

    private Constants.Directions d;
    private int speed;

    public ConveyorAttribute(Constants.Directions d, int speed){
        this.d = d;
        this.speed = speed;
    }


    @Override
    public void beforeAction(Player player) {

    }

    @Override
    public void doAction(Player p){
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, "Moving ", null);
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, p.getName() , p.getColor());
        if (speed == 2) {
            //TODO If player is outside conveyer don't move two steps! 
            new MovePlayer(p, d);
            new MovePlayer(p, d);
            EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, " Two Tiles" + "\n", null);
        } else {
            new MovePlayer(p, d);
            EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, " One Tile" + "\n", null);
        }
        //TODO Check if oncoming tile is a ConveyerRotateTile and rotate accordingly
    }

    public String toString() {
        return "Conveyor";
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        BufferedImage allTiles = LargeImageHolder.getInstance().getBoardTileImage();
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
        }
    }
}


