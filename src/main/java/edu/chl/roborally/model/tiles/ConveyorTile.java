package edu.chl.roborally.model.tiles;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.Position;
import edu.chl.roborally.model.gameactions.MovePlayer;

import java.awt.*;

/**
 * Created by axel on 2015-03-30.
 */
public class ConveyorTile extends GameTile {

    private Constants.Directions d;
    private String name = "C";

    public ConveyorTile(Constants.Directions d){
        this.d = d;
    }

    public void doAction(Player p){
        new MovePlayer(p, d);
    }

    public String toString() {
        return name;
    }

    @Override
    public void draw(Graphics g, int x, int y) {

        char[] message;
        switch (d) {
            case EAST:
                g.setColor(Color.YELLOW);
                g.fillRect(x, y, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.setColor(Color.RED);
                message = "CE".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
            case WEST:
                g.setColor(Color.YELLOW);
                g.fillRect(x, y, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.setColor(Color.RED);
                message = "CW".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
            case NORTH:
                g.setColor(Color.YELLOW);
                g.fillRect(x, y, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.setColor(Color.RED);
                message = "CN".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
            case SOUTH:
                g.setColor(Color.YELLOW);
                g.fillRect(x, y, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.setColor(Color.RED);
                message = "CS".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
        }
    }
}


