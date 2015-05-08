package edu.chl.roborally.model.maps;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.tiles.*;

/**
 * Created by axel on 2015-03-30.
 */
public class VaultMap extends GameBoard {

    private GameTile[][] board = getBoard();
    private int[][] map;
    public VaultMap() {
        super("Vault map");

        /**
         * Blank = 0
         * ConVey N,W,S,E = 11,12,13,14
         * RotTile W,E = 21,22
         * WallTile N,W,S,E = 31,32,33,34
         * PitTile = 4
         */              //1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16
        map = new int[][]{{0, 0, 0, 0, 0, 0, 31, 0, 31, 13, 0, 31, 0, 31, 11, 0},
                          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                          {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        generateMap(map);
    }
}
