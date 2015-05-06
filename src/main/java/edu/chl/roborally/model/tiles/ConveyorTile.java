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
        switch (d) {
            case EAST:
                g.setColor(new Color(247,215,8));
                g.fillRect(x, y, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.setColor(Color.BLACK);
                message = "CE".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
            case WEST:
                g.setColor(new Color(247,215,8));
                g.fillRect(x, y, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.setColor(Color.BLACK);
                message = "CW".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
            case NORTH:
                g.setColor(new Color(247,215,8));
                g.fillRect(x, y, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.setColor(Color.BLACK);
                message = "CN".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
            case SOUTH:
                g.setColor(new Color(247,215,8));
                g.fillRect(x, y, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.setColor(Color.BLACK);
                message = "CS".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
        }
    }
}


