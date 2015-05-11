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
     * ConVey NORTH with wall W,S,E = 112,113,114
     * ConVey WEST with wall N,S,E = 121,123,124
     * ETC..
     *
     *
     * RotTile W,E = 21,22
     * WallAttribute N,W,S,E = 31,32,33,34
     * PitAttribute = 4
     * StarTile = 5
     * StartTile with wall S = 53
     */

    public GameTile createTile(int tileNbr) {
        GameTile tile = new GameTile();
        switch (tileNbr) {
            case 0:
                tile.addAttribute(new BlankAttribute());
                break;

            //Straight Conveyers NO walls
            case 11:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.NORTH));
                break;
            case 12:
                tile.addAttribute(new ConveyorAttribute((Constants.Directions.WEST)));
                break;
            case 13:
                tile.addAttribute((new ConveyorAttribute(Constants.Directions.SOUTH)));
                break;
            case 14:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.EAST));
                break;
            case 15:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.NORTH_WEST));
                break;
            case 16:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.NORTH_EAST));
                break;
            case 17:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.SOUTH_WEST));
                break;
            case 18:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.SOUTH_EAST));
                break;

            //Straight ConveyerNORTH with WALL
            case 112:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.NORTH));
                tile.addAttribute(new WallAttribute(Constants.Directions.WEST));
                break;
            case 113:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.NORTH));
                tile.addAttribute(new WallAttribute(Constants.Directions.SOUTH));
                break;
            case 114:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.NORTH));
                tile.addAttribute(new WallAttribute(Constants.Directions.EAST));
                break;

            //Straight ConveyerWEST with WALL
            case 121:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.WEST));
                tile.addAttribute(new WallAttribute(Constants.Directions.NORTH));
                break;
            case 123:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.WEST));
                tile.addAttribute(new WallAttribute(Constants.Directions.SOUTH));
                break;
            case 124:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.WEST));
                tile.addAttribute(new WallAttribute(Constants.Directions.EAST));
                break;

            //Straight ConveyerEAST with WALL
            case 143:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.EAST));
                tile.addAttribute(new WallAttribute(Constants.Directions.SOUTH));
                break;

            //Rotation
            case 21:
                tile.addAttribute(new RotationAttribute(Constants.Directions.LEFT));
                break;
            case 22:
                tile.addAttribute((new RotationAttribute(Constants.Directions.RIGHT)));
                break;

            //Walls
            case 31:
                tile.addAttribute(new WallAttribute(Constants.Directions.NORTH));
                break;
            case 32:
                tile.addAttribute(new WallAttribute(Constants.Directions.WEST));
                break;
            case 33:
                tile.addAttribute(new WallAttribute(Constants.Directions.SOUTH));
                break;
            case 34:
                tile.addAttribute(new WallAttribute(Constants.Directions.EAST));
                break;

            //Pit
            case 4:
                tile.addAttribute(new PitAttribute());
                break;

            //Startposition
            case 5:
                tile.addAttribute(new StartAttribute());
                break;
            //Startposition with WALL
            case 53:
                tile.addAttribute(new StartAttribute());
                tile.addAttribute(new WallAttribute(Constants.Directions.SOUTH));
                break;
        }
        return tile;
    }

}
