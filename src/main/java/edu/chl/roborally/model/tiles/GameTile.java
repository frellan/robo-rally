package edu.chl.roborally.model.tiles;

import edu.chl.roborally.model.Player;

/**
 * Created by axel on 2015-03-26.
 */
public abstract class GameTile {

    protected static final int WITDH = 80;
    protected static final int HEIGHT = 80;

    public abstract void doAction(Player p);
    public abstract String toString();
    public abstract void draw();
}
