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
        if(rotationRight) {
            if (d == Constants.Directions.EAST) {
                return Constants.Directions.SOUTH;
            } else if (d == Constants.Directions.SOUTH) {
                return Constants.Directions.WEST;
            } else if (d == Constants.Directions.WEST) {
                return Constants.Directions.NORTH;
            } else if (d == Constants.Directions.NORTH) {
                return Constants.Directions.EAST;
            }
        }else{
            if (d == Constants.Directions.EAST) {
                return Constants.Directions.NORTH;
            } else if (d == Constants.Directions.SOUTH) {
                return Constants.Directions.EAST;
            } else if (d == Constants.Directions.WEST) {
                return Constants.Directions.SOUTH;
            } else if (d == Constants.Directions.NORTH) {
                return Constants.Directions.WEST;
            }
        }

        System.out.println("Unknown Direction -getNewDirection");
        return d;
    }
}
