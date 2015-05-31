package edu.chl.roborally.model.tiles;

import edu.chl.roborally.model.gameactions.GameAction;
import edu.chl.roborally.model.tiles.attributes.Attribute;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by axel on 2015-03-26.
 *
 * This class represents a full complete tile that consists of attributes.
 */

public class GameTile {

    private final ArrayList<Attribute> attributes;
    private final ArrayList<Attribute> beforeAttributes;
    private int priority;

    public GameTile() {
        beforeAttributes = new ArrayList<>();
        attributes = new ArrayList<>();
    }

    /*
    Commands
    */

    /**
     * Add an attribute to the Tile
     * @param attribute The attribute to add.
     */
    public void addAttribute(Attribute attribute) {
        attributes.add(attribute);
    }

    /**
     * Adds a before-attribute to the Tile
     * @param attribute The before-attribute to add.
     */
    public void addBeforeAttribute(Attribute attribute) {
        beforeAttributes.add(attribute);
    }

    /*
    Getters
    */

    /**
     * Returns the beforeAttribute.
     * @return beforeAttribute.
     */
    public ArrayList<Attribute> getBeforeAttributes(){return this.beforeAttributes;}

    /**
     * Returns the actions associated with the tile.
     * @return Actions
     */
    public ArrayList<GameAction> getActions() {
        ArrayList<GameAction> actions = new ArrayList<>();
        for (Attribute attribute : attributes) {
            for (GameAction action : attribute.getActions()) {
                actions.add(action);
            }
        }
        return actions;
    }

    /**
     * Returns a priority number for the tile. To execute tiles in a certain order.
     * @return The priority number fot the tile.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Returns the actions if there is a need for a before-action.
     * @return Before-actions
     */
    public ArrayList<GameAction> getBeforeAction() {
        ArrayList<GameAction> actions = new ArrayList<>();
        for (Attribute attribute : beforeAttributes) {
            for (GameAction action : attribute.getActions()) {
                actions.add(action);
            }
        }
        return actions;
    }

    /*
    Setters
    */

    /**
     * Seta the priority number for the tile. To execute tiles in a certain order.
     * @param priority The priority number to set.
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /*
    Graphics
     */

    /**
     * Draw method which draws the tile
     * @param g Graphics.
     * @param x X Coordinate.
     * @param y Y Coordinate.
     */
    public void draw(Graphics g, int x, int y) {
        for (Attribute attribute : this.attributes) {
            attribute.draw(g,x,y);
        }
        for (Attribute attribute : this.beforeAttributes) {
            attribute.draw(g,x,y);
        }
    }

}
