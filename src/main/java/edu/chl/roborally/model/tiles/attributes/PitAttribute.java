package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.tiles.GameTile;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.KillPlayer;

import java.awt.*;

/**
 * Created by axel on 2015-03-31.
 */
public class PitAttribute implements Attribute {

    private String name = "P";

    @Override
    public void beforeAction(Player player) {

    }

    public void doAction(Player p){
         new KillPlayer(p);
    }

    public String toString() {
        return name;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.fillRect(x,y, Constants.TILE_SIZE, Constants.TILE_SIZE);
        g.setColor(Color.WHITE);
        char[] message = "P".toCharArray();
        g.drawChars(message,0,message.length,x,y+10);
    }
}
