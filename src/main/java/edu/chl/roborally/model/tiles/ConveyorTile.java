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

    public Position getNewPosition(Position p, Boolean isExpress){
        if(d == Constants.Directions.EAST) {
            return new Position(p.getX() + 1, p.getY());
        }
        else if(d ==(Constants.Directions.WEST)){
            return new Position(p.getX()-1, p.getY());
        }
        else if(d == Constants.Directions.NORTH){
            return new Position(p.getX(), p.getY()+1);
        }
        else if(d == Constants.Directions.SOUTH){
            return new Position(p.getX(), p.getY()-1);
        }
        System.out.println("Unknown direction -getNewPosition");
        return p;
    }


}
