package edu.chl.roborally.model.tiles;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.Player;

import java.awt.*;

/**
 * Created by axel on 2015-03-31.
 */
public class WallTile extends GameTile{

    private Constants.Directions d;
    private String name = "W";

    public WallTile(Constants.Directions d){
        this.d = d;
    }

    public void doAction(Player p){
        // new StopPlayer(p, d);
    }

    public String toString() {
        return name;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        char[] message;
        g.setColor(new Color(204,204,204));
        g.fillRect(x, y, Constants.TILE_SIZE, Constants.TILE_SIZE);
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
            case NORTH_WEST:
                message = "WNW".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
            case NORTH_EAST:
                message = "WNE".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
            case SOUTH_WEST:
                message = "WSW".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
            case SOUTH_EAST:
                message = "WSE".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
        }
    }
}
