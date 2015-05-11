package edu.chl.roborally.model.tiles;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by axel on 2015-03-26.
 */

public abstract class GameTile {

    private ArrayList<Attribute> attributes;

    protected Dimension size = new Dimension(Constants.TILE_SIZE,Constants.TILE_SIZE);

    public GameTile() {
        attributes = new ArrayList<>();

    }

    private void addAttribute(Attribute attribute) {
        attributes.add(attribute);
    }

}
