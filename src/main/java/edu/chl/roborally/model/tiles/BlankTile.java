package edu.chl.roborally.model.tiles;

import edu.chl.roborally.model.Player;

import java.awt.*;

/**
 * Created by axel on 2015-03-26.
 */
public class BlankTile extends GameTile {

    private String name = "B";

    public BlankTile() {
    }

    public void doAction(Player p){
    }

    public String toString() {
        return name;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        g.fillRect(x,y,size.width,size.height);
        g.setColor(Color.GRAY);
    }

}
