package edu.chl.roborally.model.tiles;

import edu.chl.roborally.model.tiles.attributes.*;
import edu.chl.roborally.utilities.Constants;

/**
 * Created by Pertta on 15-05-11.
 */
public class TileFactory {

    private static TileFactory instance;

    private TileFactory() {}

    public static TileFactory getInstance() {
        if(instance == null){
            instance = new TileFactory();
        }
        return instance;
    }

    /**
     * ConVey N,W,S,E : NW,NE,SW,SE,WS,WN = 11,12,13,14 : 15,16,17,18,19,120 Priority 2
     * ConVey NORTH with wall W,S,E = 112,113,114
     * ConVey WEST with wall N,S,E = 121,123,124
     * DubbleConvey W,S = 212,213
     * DubbleConveySOUTH with wall W = 232
     * TurnConVey NW = 011
     *
     * RotTile W,E = 21,22
     * WallTile N,W,S,E = 31,32,33,34
     * PitTile = 4
     * RepairTile = 6
     * Repair with wall N = 61
     * StartCheckpoint = 70
     * FinalCheckpoint = 73
     * Checkpoint 1,2,3,4 = 71,72,73
     * StartCheckpoint with WALL CP1_SOUTH = 703
     */

    public GameTile createTile(int tileNbr) {
        GameTile tile = new GameTile();

        setPriorityToTile(tile, tileNbr);

        switch (tileNbr) {
            case 0:
                tile.addAttribute(new BlankAttribute());
                break;

            //Straight Conveyers NO walls
            case 11:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.NORTH,1));
                break;
            case 12:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.WEST,1));
                break;
            case 13:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.SOUTH,1));
                break;
            case 14:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.EAST,1));
                break;
            case 15:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.NORTH_WEST,1));
                break;
            case 16:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.NORTH_EAST,1));
                break;
            case 17:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.SOUTH_WEST,1));
                break;
            case 18:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.SOUTH_EAST,1));
                break;
            case 19:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.WEST_SOUTH,1));
                break;
            case 120:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.WEST_SOUTH,1));
                break;

            //Straight ConveyerNORTH with WALL
            case 112:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.NORTH,1));
                tile.addBeforeAttribute(new WallAttribute(Constants.Directions.WEST));
                break;
            case 113:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.NORTH,1));
                tile.addBeforeAttribute(new WallAttribute(Constants.Directions.SOUTH));
                break;
            case 114:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.NORTH,1));
                tile.addBeforeAttribute(new WallAttribute(Constants.Directions.EAST));
                break;

            //ConveyerWEST with WALL
            case 121:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.WEST,1));
                tile.addBeforeAttribute(new WallAttribute(Constants.Directions.NORTH));
                break;
            case 123:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.WEST,1));
                tile.addBeforeAttribute(new WallAttribute(Constants.Directions.SOUTH));
                break;
            case 124:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.WEST,1));
                tile.addBeforeAttribute(new WallAttribute(Constants.Directions.EAST));
                break;

            //ConveySOUTH with WALL
            case 132:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.SOUTH,1));
                tile.addBeforeAttribute(new WallAttribute(Constants.Directions.WEST));
                break;

            //ConveyerEAST with WALL
            case 143:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.EAST,1));
                tile.addBeforeAttribute(new WallAttribute(Constants.Directions.SOUTH));
                break;

            //Dubbelspeed Conveyers
            case 212:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.WEST,2));
                break;

            case 213:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.SOUTH,2));
                break;

            //DubbleSpeed ConveyersSOUTH with WALL
            case 232:
                tile.addAttribute(new ConveyorAttribute(Constants.Directions.SOUTH,2));
                tile.addBeforeAttribute(new WallAttribute(Constants.Directions.WEST));
                break;

            //Turning Conveyers
            case 011:
                tile.addAttribute(new TurnConveyorAttribute(Constants.Directions.NORTH_WEST));
                break;

            //Rotation
            case 21:
                tile.addAttribute(new RotationAttribute(Constants.Directions.EAST));
                break;
            case 22:
                tile.addAttribute((new RotationAttribute(Constants.Directions.WEST)));
                break;

            //Walls
            case 31:
                tile.addAttribute(new BlankAttribute());
                tile.addBeforeAttribute(new WallAttribute(Constants.Directions.NORTH));
                break;
            case 32:
                tile.addAttribute(new BlankAttribute());
                tile.addBeforeAttribute(new WallAttribute(Constants.Directions.WEST));
                break;
            case 33:
                tile.addAttribute(new BlankAttribute());
                tile.addBeforeAttribute(new WallAttribute(Constants.Directions.SOUTH));
                break;
            case 34:
                tile.addAttribute(new BlankAttribute());
                tile.addBeforeAttribute(new WallAttribute(Constants.Directions.EAST));
                break;

            //Pit
            case 4:
                tile.addBeforeAttribute(new PitAttribute());
                break;

            //Repair
            case 6:
                tile.addAttribute(new RepairAttribute());
                break;
            //Repair with WALL
            case 61:
                tile.addAttribute(new BlankAttribute());
                tile.addBeforeAttribute(new WallAttribute(Constants.Directions.NORTH));
                tile.addAttribute(new RepairAttribute());
                break;
            //Checkpoint
            case 70:
                tile.addAttribute(new BlankAttribute());
                tile.addAttribute(new CheckpointAttribute(0));
                break;
            case 71:
                tile.addAttribute(new BlankAttribute());
                tile.addAttribute(new CheckpointAttribute(1));
                break;
            case 72:
                tile.addAttribute(new BlankAttribute());
                tile.addAttribute(new CheckpointAttribute(2));
                break;
            //Final Checkpoint
            case 73:
                tile.addAttribute(new BlankAttribute());
                tile.addAttribute(new CheckpointAttribute(3));
                break;
            //Checkpoint with WALL
            case 703:
                tile.addAttribute(new BlankAttribute());
                tile.addBeforeAttribute(new WallAttribute(Constants.Directions.SOUTH));
                tile.addAttribute(new CheckpointAttribute(0));
                break;
        }
        return tile;
    }

    /**
     * Set priority to tile, priority decides when the action should be executed
     * @param tile
     * @param tileNbr
     */
    private void setPriorityToTile(GameTile tile, int tileNbr) {
        switch(tileNbr) {
            case 11: case 12: case 13: case 14:case 15:case 16:case 17: case 18:case 19:case 120:case 112:case 113:case 114:case 121:case 122:case 123:
                tile.setPriority(2);
                break;
            case 212:case 213:case 232:
                tile.setPriority(1);
                break;
            case 6:case 71:case 72:case 73:
                tile.setPriority(3);
                break;
        }
    }

}
