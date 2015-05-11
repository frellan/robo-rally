package edu.chl.roborally.model.maps;

/**
 * Created by axel on 2015-03-30.
 */
public class IslandKingMap extends GameBoard {

    /**
     * Blank = 0
     * ConVey N,W,S,E : NW,NE,SW,SE = 11,12,13,14 : 15,16,17,18
     * ConVeyNORTH with wall W,S,E = 112,113,114
     * ConVeyWEST with wall N,S,E = 121,123,124
     * ConveyEAST with wall S = 143
     *
     *
     * RotTile W,E = 21,22
     * WallAttribute N,W,S,E = 31,32,33,34
     * PitAttribute = 4
     * StarTile = 5
     */
    private final int[][] map = {   { 0, 53,  0,  0, 0, 0, 61,  0, 31,  0,  0, 31,  0, 31,  0,  0},
                                    { 0,  5,  0,  0, 0, 4,  4,  0,  0,  0,  0,  0,  0,  4,  4,  0},
                                    {32, 33,  0, 34, 0, 4, 11, 14, 14, 14,143, 14, 14, 22,  4, 34},
                                    { 0,  5,  0,  0, 0, 0, 11, 21, 12, 12, 12, 12, 21, 13,  0,  0},
                                    {32, 33,  0, 34, 0, 0, 11, 13,  4,  4, 11,  0, 11, 13,  0, 34},
                                    { 0,  5,  0,  0, 0, 0, 11, 13,  4,  0, 11,  0,114, 13,  0,  0},
                                    { 0,  5,  0,  0, 0, 0, 11, 13,  0, 13,  6,  4, 11, 13,  0,  0},
                                    {32, 31,  0, 34, 0, 0, 11, 13,  0, 13,  4,  4, 11, 13,  0, 34},
                                    { 0,  5,  0,  0, 0, 0, 11, 21, 14,143, 14, 14, 21, 13,  0,  0},
                                    {32, 31,  0, 34, 0, 4, 12, 12, 12, 12, 12, 12, 12, 22,  4, 34},
                                    { 0,  5,  0,  0, 0, 4,  4,  0,  0,  0,  0,  0,  0,  4,  4,  0},
                                    { 0,  5,  0,  0, 0, 0, 33,  0, 33,  0,  0, 33,  0, 33,  0,  6}
                                };

    public IslandKingMap() {
        super("Island King");
        generateMap(map);
    }
}
