package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.gameactions.GameAction;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.KillPlayer;
import edu.chl.roborally.utilities.GlobalImageHolder;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by axel on 2015-03-31.
 */
public class PitAttribute extends Attribute {

    private String name = "P";

    @Override
    public void doAction(Player p){
         new KillPlayer(p);
    }

    public String toString() {
        return name;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        BufferedImage temp = GlobalImageHolder.getInstance().getBoardTileImage().getSubimage(
                5*Constants.TILE_SIZE, 0, Constants.TILE_SIZE, Constants.TILE_SIZE);
        g.drawImage(temp, x, y, null);
    }
}
