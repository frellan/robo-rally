package edu.chl.roborally.model.tiles;

import java.awt.*;

/**
 * Created by Pertta on 15-05-11.
 */
public interface Attribute {

    void doAction();
    String toString();
    void draw(Graphics g, int x, int y);


}
