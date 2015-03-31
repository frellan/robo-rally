package edu.chl.roborally.model.tiles;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.Player;

/**
 * Created by axel on 2015-03-31.
 */
public class WallTile implements GameTile{

    private Player player;
    private Constants.Directions d;


    public WallTile(Player player, Constants.Directions d){
        this.player = player;
        this.d=d;
    }

    public void doAction(){

    }



}
