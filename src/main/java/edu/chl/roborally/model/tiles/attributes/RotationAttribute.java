package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.tiles.GameTile;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.RotatePlayer;

import java.awt.*;

/**
 * Created by axel on 2015-03-30.
 */
public class RotationAttribute implements Attribute {

    private Constants.Directions d;
    private String name = "R";

    public RotationAttribute(Constants.Directions d){
        this.d = d;
    }

    public void doAction(Player p){
        new RotatePlayer(p,d);
    }

    public String toString() {
        return name;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        char[] message;
        g.setColor(new Color(156,207,49));
        g.fillRect(x, y, Constants.TILE_SIZE, Constants.TILE_SIZE);
        g.setColor(Color.BLACK);
        switch (d) {
            case LEFT:
                message = "RL".toCharArray();
                g.drawChars(message, 0, message.length, x, y+10);
                break;
            case RIGHT:
                message = "RR".toCharArray();
                g.drawChars(message, 0, message.length, x, y+10);
                break;
        }
    }

}
