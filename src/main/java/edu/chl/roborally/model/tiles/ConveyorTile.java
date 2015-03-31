package edu.chl.roborally.model.tiles;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.Position;
import edu.chl.roborally.model.gameactions.MovePlayer;

/**
 * Created by axel on 2015-03-30.
 */
public class ConveyorTile implements GameTile {

    private Constants.Directions d;

    public ConveyorTile(Constants.Directions d){
        this.d = d;
    }


    public void doAction(Player p){
        new MovePlayer(p, d);
    }
}
