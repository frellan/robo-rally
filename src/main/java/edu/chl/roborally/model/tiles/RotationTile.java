package edu.chl.roborally.model.tiles;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.RotatePlayer;

import java.awt.*;

/**
 * Created by axel on 2015-03-30.
 */
public class RotationTile extends GameTile {

    private Constants.Directions d;
    private String name = "R";

    public RotationTile(Constants.Directions d){
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
        switch (d) {
            case LEFT:
                g.setColor(new Color(156,207,49));
                g.fillRect(x, y, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.setColor(Color.BLACK);
                message = "RL".toCharArray();
                g.drawChars(message, 0, message.length, x, y+10);
                break;
            case RIGHT:
                g.setColor(new Color(156,207,49));
                g.fillRect(x, y, Constants.TILE_SIZE, Constants.TILE_SIZE);
                g.setColor(Color.BLACK);
                message = "RR".toCharArray();
                g.drawChars(message, 0, message.length, x, y+10);
                break;
        }
    }

}
