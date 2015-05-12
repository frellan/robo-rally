package edu.chl.roborally.utilities;

import java.awt.*;

/**
 * Created by fredrikkindstrom on 27/03/15.
 */
public class Constants {

    //RoboRally
    public static final int NUMBER_OF_TURNS = 5;

    // GameBoard
    public static final int TILE_SIZE = 40;
    public static final int NUM_COLS = 16;
    public static final int NUM_ROWS = 12;

    //CardView
    public static final int CARD_SLOT_WIDTH = 105;
    public static final int CARD_SLOT_HEIGHT = 152;
    public static final int CARD_SLOT_ARC = 5;
    public static final int CARD_WIDTH = 100;
    public static final int CARD_HEIGHT = 150;
    public static final int CARD_GAP = 18;

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
        SOUTH_EAST,
        WEST_NORTH,
        WEST_SOUTH,
        EAST_NORTH,
        EAST_SOUTH,
        LEFT,
        RIGHT
    }

    // The status of a player
    public enum Status {
        ALIVE,
        DEAD,
        POWERDOWN,
        KAPUT,
    }
}
