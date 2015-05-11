package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.Player;

import java.awt.*;

/**
 * Created by Pertta on 15-05-11.
 */
public interface Attribute {

    void doAction(Player player);
    String toString();
    void draw(Graphics g, int x, int y);


}
