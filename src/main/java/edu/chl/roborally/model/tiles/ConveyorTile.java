package edu.chl.roborally.model.tiles;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.Position;
import edu.chl.roborally.model.gameactions.MovePlayer;

import java.awt.*;

/**
 * Created by axel on 2015-03-30.
 */
public class ConveyorTile extends GameTile {

    private Constants.Directions d;
    private String name = "C";

    public ConveyorTile(Constants.Directions d){
        this.d = d;
    }


    public void doAction(Player p){
        new MovePlayer(p, d);
    }

    public String toString() {
        return name;
    }

    @Override
    public void draw(Graphics g, int x, int y) {

    }

}
