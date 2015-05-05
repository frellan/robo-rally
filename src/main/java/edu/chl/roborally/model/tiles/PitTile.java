package edu.chl.roborally.model.tiles;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.KillPlayer;

/**
 * Created by axel on 2015-03-31.
 */
public class PitTile extends GameTile{

    private String name = "P";

    public void doAction(Player p){
         new KillPlayer(p);
    }

    public String toString() {
        return name;
    }

    @Override
    public void apperance() {

    }

}
