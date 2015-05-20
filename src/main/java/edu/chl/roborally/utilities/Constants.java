package edu.chl.roborally.utilities;

import java.awt.*;

/**
 * Created by fredrikkindstrom on 27/03/15.
 */
public class Constants {

    // RoboRally
    public static final int NUMBER_OF_TURNS = 5;

    // GameBoard
    public static final int TILE_SIZE = 40;
    public static final int NUM_COLS = 16;
    public static final int NUM_ROWS = 12;

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
