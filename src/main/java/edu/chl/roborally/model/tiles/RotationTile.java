package edu.chl.roborally.model.tiles;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.Player;

/**
 * Created by axel on 2015-03-30.
 */
public class RotationTile implements GameTile {

    private Constants.Directions d;

    public RotationTile(Constants.Directions d){
        this.d = d;
    }

    public void doAction(Player p){
        new RotatePlayer(p,d);
    }
}