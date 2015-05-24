package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.Turn;
import edu.chl.roborally.model.gameactions.MovePlayer;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.GlobalImageHolder;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Pertta on 15-05-12.
 */
public class TurnConveyorAttribute implements Attribute {

    private Constants.Directions d;

    public TurnConveyorAttribute(Constants.Directions d) {
        this.d = d;
    }

    @Override
    public void doAction(Player player) {
        new MovePlayer(player, d);
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, " Moving and Rotating ", null);
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, player .getName() , player.getColor());
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, "One Tile + Right" + "\n", null);
    }

    public String toString() {
        return "TurnConveyor";
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        BufferedImage allTiles = GlobalImageHolder.getInstance().getBoardTileImage();
        BufferedImage currentTile;
        switch (d) {
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
