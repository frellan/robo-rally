package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.Constants;

import java.awt.*;

/**
 * Created by Pertta on 15-05-13.
 */
public class CheckpointAttribute implements Attribute {

    private String name = "CP";
    private int id;

    public CheckpointAttribute(int id) {
        this.id = id;
    }

    @Override
    public void beforeAction(Player player) {

    }

    @Override
    public void doAction(Player player) {

    }

    public String toString() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.MAGENTA);
        g.fillRect(x,y, Constants.TILE_SIZE, Constants.TILE_SIZE);
        g.setColor(Color.BLACK);
        char[] message = "CP".toCharArray();
        g.drawChars(message,0,message.length,x,y+10);

    }
}
