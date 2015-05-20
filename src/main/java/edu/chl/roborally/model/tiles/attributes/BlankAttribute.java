package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.StopPlayer;
import edu.chl.roborally.model.tiles.GameTile;
import edu.chl.roborally.utilities.Constants;

import java.awt.*;

/**
 * Created by Pertta on 15-05-11.
 */
public class BlankAttribute implements Attribute {

    @Override
    public void beforeAction(Player player) {

    }

    @Override
    public void doAction(Player player) {

    }

    @Override
    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.GRAY);
        g.fillRect(x,y, Constants.TILE_SIZE, Constants.TILE_SIZE);
    }
}
