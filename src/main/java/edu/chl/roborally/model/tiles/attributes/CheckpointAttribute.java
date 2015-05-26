package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.CheckpointPlayer;
import edu.chl.roborally.model.gameactions.GameAction;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.GlobalImageHolder;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Pertta on 15-05-13.
 */
public class CheckpointAttribute extends Attribute {

    private String name = "CP";
    private final int id;

    public CheckpointAttribute(int id) {
        super.setAction(new CheckpointPlayer());
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return name;
    }



    @Override
    public void draw(Graphics g, int x, int y) {
        BufferedImage allTiles = GlobalImageHolder.getInstance().getBoardTileImage();
        BufferedImage currentTile;
        switch (id) {
            case 0:
                currentTile = allTiles.getSubimage(
                        0, 11*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
            case 1:
                currentTile = allTiles.getSubimage(
                        Constants.TILE_SIZE, 11*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
            case 2:
                currentTile = allTiles.getSubimage(
                        2*Constants.TILE_SIZE, 11*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
            //case 3:
              //  currentTile = allTiles.getSubimage(
                //        3*Constants.TILE_SIZE, 11*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                //g.drawImage(currentTile, x, y, null);
               // break;
            //case 4:
              //  currentTile = allTiles.getSubimage(
                //        Constants.TILE_SIZE, 12*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
               // g.drawImage(currentTile, x, y, null);
               // break;
            case 3:
                currentTile = allTiles.getSubimage(
                        0, 12*Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.drawImage(currentTile, x, y, null);
                break;
        }
    }
}
