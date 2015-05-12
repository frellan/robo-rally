package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.RepairPlayer;
import edu.chl.roborally.utilities.Constants;

import java.awt.*;

/**
 * Created by Pertta on 15-05-12.
 */
public class RepairAttribute implements Attribute {

    @Override
    public void doAction(Player player) {
        new RepairPlayer(player);
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.CYAN);
        g.fillRect(x,y, Constants.TILE_SIZE, Constants.TILE_SIZE);
    }
}
