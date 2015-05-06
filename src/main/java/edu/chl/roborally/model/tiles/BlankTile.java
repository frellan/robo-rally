package edu.chl.roborally.model.tiles;

import edu.chl.roborally.model.Player;

/**
 * Created by axel on 2015-03-26.
 */
public class BlankTile extends GameTile {

    private String name = "B";

    public void doAction(Player p){
    }

    public String toString() {
        return name;
    }

    @Override
    public void appearance() {

    }

}
