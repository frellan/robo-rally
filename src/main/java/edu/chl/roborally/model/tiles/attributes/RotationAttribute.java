package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.tiles.GameTile;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.RotatePlayer;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.LargeImageHolder;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by axel on 2015-03-30.
 */
public class RotationAttribute implements Attribute {

    private Constants.Directions d;
    private String name = "R";

    public RotationAttribute(Constants.Directions d){
        this.d = d;
    }

    public void doAction(Player p){
        new RotatePlayer(p,d);
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, "Rotating ", null);
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, p.getName() , p.getColor());
        if(d == Constants.Directions.WEST)
            EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, " One Left" + "\n", null);
        if(d == Constants.Directions.EAST)
            EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, " One Right" + "\n", null);
    }

    public String toString() {
        return name;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        BufferedImage allTiles = LargeImageHolder.getInstance().getBoardTileImage();
        BufferedImage currentTile;
        switch (d) {
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
