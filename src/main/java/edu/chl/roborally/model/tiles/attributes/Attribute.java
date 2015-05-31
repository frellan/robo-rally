package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.gameactions.GameAction;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Pertta on 15-05-11.
 *
 * Represent an attribute that a tile can have. For example a wall, a conveyor, a pit etc.
 * The attributes uses the game action package to actually affect a player.
 * This is just the representation classes.
 */
public abstract class Attribute {

    private final ArrayList<GameAction> actions = new ArrayList<>();
    String tileMessage;

    /*
    Commands
     */

    /**
     * Adds an action to a the list of actions to happen on a tile with this attribute.
     * Used by the subclasses.
     * @param action The action to add.
     */
    void addAction(GameAction action) {
        this.actions.add(action);
    }

    /*
    Getters
     */

    /**
     * Returns all the actions associated with the attribute.
     * @return A list of all the actions.
     */
    public ArrayList<GameAction> getActions() {
        return this.actions;
    }

    /*
    Graphics
     */

    public abstract void draw(Graphics g, int x, int y);
}
