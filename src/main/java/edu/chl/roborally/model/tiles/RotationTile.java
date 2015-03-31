package edu.chl.roborally.model.tiles;

import edu.chl.roborally.model.Constants;

/**
 * Created by axel on 2015-03-30.
 */
public class RotationTile implements GameTile {


    private boolean rotationRight;


    public RotationTile(Boolean rotationRight){
        this.rotationRight = rotationRight;
    }

    public Constants.Directions getNewDirection(Constants.Directions d){
        if (rotationRight) {
            switch (d) {
                case EAST:
                    return Constants.Directions.SOUTH;
                case SOUTH:
                    return Constants.Directions.WEST;
                case WEST:
                    return Constants.Directions.NORTH;
                case NORTH:
                    return Constants.Directions.EAST;
                default:
                    System.out.println("Unknown Direction -getNewDirection");
                    return d;
            }
        } else {
            switch (d) {
                case EAST:
                    return Constants.Directions.NORTH;
                case SOUTH:
                    return Constants.Directions.EAST;
                case WEST:
                    return Constants.Directions.SOUTH;
                case NORTH:
                    return Constants.Directions.WEST;
                default:
                    System.out.println("Unknown Direction -getNewDirection");
                    return d;
            }
        }
    }

    public void doAction(){

    }


}
