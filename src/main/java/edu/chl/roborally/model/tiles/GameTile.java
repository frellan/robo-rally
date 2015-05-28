package edu.chl.roborally.model.tiles;

import edu.chl.roborally.model.gameactions.GameAction;
import edu.chl.roborally.model.tiles.attributes.Attribute;
import edu.chl.roborally.utilities.Constants;
import java.awt.*;
import java.util.ArrayList;
import java.util.jar.Attributes;

/**
 * Created by axel on 2015-03-26.
 *
 * Creates a Tile with attributes.
 */

public class GameTile {

    private ArrayList<Attribute> attributes;
    private ArrayList<Attribute> beforeAttributes;

    protected Dimension size = new Dimension(Constants.TILE_SIZE,Constants.TILE_SIZE);

    public GameTile() {
        beforeAttributes = new ArrayList<>();
        attributes = new ArrayList<>();
    }

    /*
    Commands
    */

    /**
     * Add an attribute to the Tile
     * @param attribute
     */
    public void addAttribute(Attribute attribute) {
        attributes.add(attribute);
    }

    /**
     * Adds a before-attribute to the Tile
     * @param attribute
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
     * Returns the actions associated with the tile
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
     * Returns the actions if there is a need for a before-action
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
