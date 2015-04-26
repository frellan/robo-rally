package edu.chl.roborally.model.tiles;

import edu.chl.roborally.model.Player;

/**
 * Created by axel on 2015-03-26.
 */
public interface GameTile {

    public void doAction(Player p);
    public String toString();
    public void draw();
}
