package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.gameactions.GameAction;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Pertta on 15-05-11.
 */
public abstract class Attribute {

    private ArrayList<GameAction> actions = new ArrayList<>();
    protected String tileMessage;

    /**
     * Getters
     */
    public ArrayList<GameAction> getActions() {
        return this.actions;
    }

    public String getTileMessage(){return tileMessage;}

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
