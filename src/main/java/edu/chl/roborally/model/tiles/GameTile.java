package edu.chl.roborally.model.tiles;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.tiles.attributes.Attribute;
import edu.chl.roborally.utilities.Constants;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by axel on 2015-03-26.
 */

public class GameTile {

    private ArrayList<Attribute> attributes;

    protected Dimension size = new Dimension(Constants.TILE_SIZE,Constants.TILE_SIZE);

    public GameTile() {
        attributes = new ArrayList<>();

    }

    public void addAttribute(Attribute attribute) {
        attributes.add(attribute);
    }

    public void getAction(Player player) {
        for (Attribute attribute : this.attributes) {
            attribute.doAction(player);
        }
    }

    public void draw(Graphics g, int x, int y) {
        for (Attribute attribute : this.attributes) {
            attribute.draw(g,x,y);
        }
    }

}
