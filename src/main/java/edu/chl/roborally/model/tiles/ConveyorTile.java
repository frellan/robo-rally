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
    private char[] message = name.toCharArray();



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
        if(d == Constants.Directions.EAST){
            g.setColor(Color.BLUE);
            g.fillRect(x,y,Constants.TILE_SIZE,Constants.TILE_SIZE);
            g.setColor(Color.RED);
            g.drawChars(message, 0, message.length, x, y+10);
        }else if(d == Constants.Directions.WEST){
            g.setColor(Color.RED);
            g.fillRect(x,y,Constants.TILE_SIZE,Constants.TILE_SIZE);
            g.setColor(Color.BLUE);
            g.drawChars(message, 0, message.length, x, y+10);
        }else if(d == Constants.Directions.NORTH){
            g.setColor(Color.YELLOW);
            g.fillRect(x,y,Constants.TILE_SIZE,Constants.TILE_SIZE);
            g.setColor(Color.RED);
            g.drawChars(message, 0, message.length, x, y+10);
        }else if(d == Constants.Directions.SOUTH){
            g.setColor(Color.DARK_GRAY);
            g.fillRect(x,y,Constants.TILE_SIZE,Constants.TILE_SIZE);
            g.setColor(Color.RED);
            g.drawChars(message, 0, message.length, x, y+10);
        }
    }
}


