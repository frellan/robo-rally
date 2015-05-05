package edu.chl.roborally.model.tiles;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.RotatePlayer;

/**
 * Created by axel on 2015-03-30.
 */
public class RotationTile extends GameTile {

    private Constants.Directions d;
    private String name = "R";

    public RotationTile(Constants.Directions d){
        this.d = d;
    }

    public void doAction(Player p){
        new RotatePlayer(p,d);
    }

    public String toString() {
        return name;
    }

    @Override
    public void special() {

    }

}
