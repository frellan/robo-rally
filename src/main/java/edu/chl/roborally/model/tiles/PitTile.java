package edu.chl.roborally.model.tiles;

import edu.chl.roborally.model.Player;

/**
 * Created by axel on 2015-03-31.
 */
public class PitTile implements GameTile{


    public PitTile(){

    }

    public void doAction(Player p){
        new RespawnPlayer(p);
    }
}
