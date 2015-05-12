package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.gameactions.StopPlayer;
import edu.chl.roborally.model.tiles.GameTile;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;

import java.awt.*;

/**
 * Created by axel on 2015-03-31.
 */
public class WallAttribute implements Attribute {

    private Constants.Directions d;
    private String name = "W";

    public WallAttribute(Constants.Directions d){
        this.d = d;
    }


    @Override
    public void beforeAction(Player player) {

    }

    public void doAction(Player p){
        new StopPlayer(p);
    }

    public String toString() {
        return name;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        g.setColor(new Color(204,204,204));
        g.fillRect(x, y, Constants.TILE_SIZE, Constants.TILE_SIZE);
        char[] message;
        g.setColor(Color.RED);
        switch (d) {
            case EAST:
                message = "WE".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
            case WEST:
                message = "WW".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
            case NORTH:
                message = "WN".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
            case SOUTH:
                message = "WS".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
        }
    }
}
