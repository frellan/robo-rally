package edu.chl.roborally.model.tiles;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.Player;

/**
 * Created by axel on 2015-03-31.
 */
public class WallTile implements GameTile{

    private Constants.Directions d;
    private String name;

    public WallTile(Constants.Directions d){
        this.d=d;
    }

    public void doAction(Player p){
        // new StopPlayer(p, d);
    }

    public String toString() {
        return name;
    }



}
