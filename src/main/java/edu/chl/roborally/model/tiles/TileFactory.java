package edu.chl.roborally.model.tiles;

import edu.chl.roborally.model.tiles.attributes.*;
import edu.chl.roborally.utilities.Constants;

/**
 * Created by Pertta on 15-05-11.
 */
public class TileFactory {

    private static TileFactory tile;

    public static TileFactory getInstance(){
        if(tile == null){
            tile = new TileFactory();
        }
        return tile;
    }

    /**
     * ConVey N,W,S,E : NW,NE,SW,SE = 11,12,13,14 : 15,16,17,18
     * RotTile W,E = 21,22
     * WallAttribute N,W,S,E = 31,32,33,34
     * PitAttribute = 4
     * StarTile = 5
     */

    public GameTile createTile(int tileNbr) {
        GameTile tile = new GameTile();
        if(tileNbr == 11) {
            tile.addAttribute(new ConveyorAttribute(Constants.Directions.NORTH));
        }
        else if (tileNbr == 0) {
            tile.addAttribute(new BlankAttribute());
        }
        else if (tileNbr == 12) {
            tile.addAttribute(new ConveyorAttribute((Constants.Directions.WEST)));
        }
        else if (tileNbr == 13) {
            tile.addAttribute((new ConveyorAttribute(Constants.Directions.SOUTH)));
        }
        else if (tileNbr == 14) {
            tile.addAttribute(new ConveyorAttribute(Constants.Directions.EAST));
        }
        else if (tileNbr == 15) {
            tile.addAttribute(new ConveyorAttribute(Constants.Directions.NORTH_WEST));
        }
        else if (tileNbr == 16) {
            tile.addAttribute(new ConveyorAttribute(Constants.Directions.NORTH_EAST));
        }
        else if (tileNbr == 17) {
            tile.addAttribute(new ConveyorAttribute(Constants.Directions.SOUTH_WEST));
        }
        else if (tileNbr == 18) {
            tile.addAttribute(new ConveyorAttribute(Constants.Directions.SOUTH_EAST));
        }
        else if (tileNbr == 21) {
            tile.addAttribute(new RotationAttribute(Constants.Directions.WEST));
        }
        else if (tileNbr == 22) {
            tile.addAttribute((new RotationAttribute(Constants.Directions.EAST)));
        }
        else if (tileNbr == 31) {
            tile.addAttribute(new WallAttribute(Constants.Directions.NORTH));
        }
        else if (tileNbr == 32) {
            tile.addAttribute(new WallAttribute(Constants.Directions.WEST));
        }
        else if (tileNbr == 33) {
            tile.addAttribute(new WallAttribute(Constants.Directions.SOUTH));
        }
        else if (tileNbr == 34) {
            tile.addAttribute(new WallAttribute(Constants.Directions.EAST));
        }
        else if (tileNbr == 4) {
            tile.addAttribute(new PitAttribute());
        }
        else if (tileNbr == 5) {
            tile.addAttribute(new StartAttribute());
        }
        return tile;
    }

}
