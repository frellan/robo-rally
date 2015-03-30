package edu.chl.roborally.model;

/**
 * Created by fredrikkindstrom on 27/03/15.
 */
public class Constants {

    // Card move types
    protected enum MoveTypes {
        MOVE_ONE,
        MOVE_TWO,
        MOVE_THREE,
        BACKUP,
        ROTATE_LEFT,
        ROTATE_RIGHT,
        U_TURN
    }

    // Player & tile directions
    protected enum Directions {
        NORTH,
        WEST,
        EAST,
        SOUTH,
        NORTH_WEST,
        NORTH_EAST,
        SOUTH_WEST,
        SOUTH_EAST
    }
}
