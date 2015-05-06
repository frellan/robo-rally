package edu.chl.roborally.model.tiles;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.MovePlayer;

import java.awt.*;

/**
 * Created by axel on 2015-03-30.
 */
public class ConveyorTile extends GameTile {

    private Constants.Directions d;

    public ConveyorTile(Constants.Directions d){
        this.d = d;
    }

    public void doAction(Player p){
        new MovePlayer(p, d);
    }

    public String toString() {
        return "Conveyor";
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        char[] message;
        g.setColor(new Color(247,215,8));
        g.fillRect(x, y, Constants.TILE_SIZE, Constants.TILE_SIZE);
        g.setColor(Color.BLACK);
        switch (d) {
            case EAST:
                message = "CE".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
            case WEST:
                message = "CW".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
            case NORTH:
                message = "CN".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
            case SOUTH:
                message = "CS".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
            case NORTH_WEST:
                message = "CNW".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
            case NORTH_EAST:
                message = "CNE".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
            case SOUTH_WEST:
                message = "CSW".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
            case SOUTH_EAST:
                message = "CSE".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
        }
    }
}


