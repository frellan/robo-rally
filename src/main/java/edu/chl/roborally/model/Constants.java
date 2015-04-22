package edu.chl.roborally.model;

/**
 * Created by fredrikkindstrom on 27/03/15.
 */
public class Constants {

    //RoboRally
    public static final int NUMBER_OF_TURNS = 5;

    // GameBoard
    public static final int NUM_ROWS = 16;
    public static final int NUM_COLS = 12;

    // Card move types
    public enum MoveTypes {
        MOVE_ONE,
        MOVE_TWO,
        MOVE_THREE,
        BACKUP,
        ROTATE_LEFT,
        ROTATE_RIGHT,
        U_TURN
    }

    // Player & tile directions
    public enum Directions {
        NORTH,
        WEST,
        EAST,
        SOUTH,
        NORTH_WEST,
        NORTH_EAST,
        SOUTH_WEST,
        SOUTH_EAST
    }

    // The status of a player
    public enum Status {
        ALIVE,
        DEAD,
        POWERDOWN,
        KAPUT,
    }
}
