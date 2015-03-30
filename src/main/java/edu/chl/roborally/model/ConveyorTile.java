package edu.chl.roborally.model;

/**
 * Created by axel on 2015-03-30.
 */
public class ConveyorTile implements GameTile{


    private Constants.Direction d;


    public ConveyorTile(Constants.Direction d){
        this.d = d;
    }

    public Position getNewPosition(Position p){
        if(d = Constants.Directions.EAST) {
            return new Position(p.getX() + 1, p.getY());
        }
        else if(d = Constants.Directions.WEST){
            return new Position(p.getX()-1, p.getY());
        }
        else if(d = Constants.Directions.NORTH){
            return new Position(p.getX(), p.getY()+1);
        }
        else if(d = Constants.Directions.SOUTH){
            return new Position(p.getX(), p.getY()-1);
        }
        System.out.println("Unknown direction -getNewPosition");
        return p;
    }


}
