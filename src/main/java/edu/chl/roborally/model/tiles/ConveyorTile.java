package edu.chl.roborally.model.tiles;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.Position;

/**
 * Created by axel on 2015-03-30.
 */
public class ConveyorTile implements GameTile {

    private Constants.Directions d;
    private Boolean isExpress;

    public ConveyorTile(Constants.Directions d, Boolean isExpress){
        this.d = d;
        this.isExpress = isExpress;
    }

    public Position getNewPosition(Position p){
        switch (d) {
            case EAST:
                return new Position(p.getX() + 1, p.getY());
            case WEST:
                return new Position(p.getX()-1, p.getY());
            case NORTH:
                return new Position(p.getX(), p.getY()+1);
            case SOUTH:
                return new Position(p.getX(), p.getY()-1);
            default:
                System.out.println("Unknown Direction -getNewPosition");
                return p;
        }
    }

}
