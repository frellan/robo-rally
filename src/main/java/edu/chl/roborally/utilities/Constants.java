package edu.chl.roborally.utilities;

/**
 * Created by fredrikkindstrom on 27/03/15.
 */
public class Constants {

    // GameBoard
    public static final int TILE_SIZE = 40;
    public static final int NUM_COLS = 16;
    public static final int NUM_ROWS = 12;

    //Console
    public static final String UNDER_LINE = "--------------------------------------" +
                                            "--------------------------------------";

    // Player & tile directions
    public enum Directions {

        NORTH,
        WEST,
        EAST,
        SOUTH,
        NORTH_WEST,
        NORTH_EAST,
        SOUTH_WEST,
        SOUTH_EAST,
        WEST_NORTH,
        WEST_SOUTH,
        EAST_NORTH,
        EAST_SOUTH,
        LEFT,
        RIGHT;

        private Directions oppositeDirection;

        static {
            NORTH.oppositeDirection = SOUTH;
            SOUTH.oppositeDirection = NORTH;
            WEST.oppositeDirection = EAST;
            EAST.oppositeDirection = WEST;
        }

        public Directions getOpposite(){
            return oppositeDirection;
        }
    }

    // The status of a player
    public enum Status {
        ALIVE,
        DEAD,
        POWERDOWN,
        KAPUT,
    }

    // The level of difficulty
    public enum Difficulty {
        EASY,
        MEDIUM,
        HARD,
    }
}
