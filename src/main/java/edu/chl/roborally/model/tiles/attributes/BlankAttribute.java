package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.tiles.GameTile;

import java.awt.*;

/**
 * Created by axel on 2015-03-26.
 */
public class BlankAttribute implements Attribute {

    private String name = "B";

    public BlankAttribute() {
    }

    public void doAction(Player p){
    }

    public String toString() {
        return name;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        g.setColor(new Color(204,204,204));
        g.fillRect(x,y,size.width,size.height);
    }
}
