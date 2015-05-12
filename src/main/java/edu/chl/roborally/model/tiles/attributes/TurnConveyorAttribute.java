package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.Turn;
import edu.chl.roborally.utilities.Constants;

import java.awt.*;

/**
 * Created by Pertta on 15-05-12.
 */
public class TurnConveyorAttribute implements Attribute {

    private Constants.Directions d;

    public TurnConveyorAttribute(Constants.Directions d) {
        this.d = d;

    }

    @Override
    public void doAction(Player player) {

    }

    @Override
    public void draw(Graphics g, int x, int y) {

    }
}
