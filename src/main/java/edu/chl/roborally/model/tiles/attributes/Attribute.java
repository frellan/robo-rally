package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.gameactions.GameAction;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Pertta on 15-05-11.
 */
public abstract class Attribute {

    private ArrayList<GameAction> actions = new ArrayList<>();

    /**
     * Getters
     */
    public ArrayList<GameAction> getActions() {
        return this.actions;
    }

    /**
     * Setters
     */

    protected void setAction(GameAction action) {
        this.actions.add(action);
    }

    /**
     * Commands
     */
    public abstract void draw(Graphics g, int x, int y);


}
