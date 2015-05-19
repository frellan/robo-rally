package edu.chl.roborally.model.maps;

/**
 * Created by axel on 2015-03-30.
 */
public class IslandKingMap extends GameBoard {

    /**
     * ConVey N,W,S,E : NW,NE,SW,SE = 11,12,13,14 : 15,16,17,18
     * ConVey NORTH with wall W,S,E = 112,113,114
     * ConVey WEST with wall N,S,E = 121,123,124
     * ETC..
     * TurnConVey NW = 011
     *
     * RotTile W,E = 21,22
     * WallTile N,W,S,E = 31,32,33,34
     * PitTile = 4
     * RepairTile = 6
     * Repair with wall N = 61
     * StartCheckpoint = 70
     * FinalCheckpoint = 75
     * Checkpoint 1,2,3,4 = 71,72,73
     * StartCheckpoint with WALL CP1_SOUTH = 703
     */
    private final int[][] map = {   { 0,703,  0,  0,  0,  0, 61,  0, 31,  0,  0, 31,  0, 31,  0,  0},
                                    { 0, 70,  0,  0,  0,  4,  4,  0,  0,  0,  0,  0,  0,  4,  4,  0},
                                    {32, 33,  0, 34,  0,  4, 11, 14, 14, 14,143, 14, 14, 22,  4, 34},
                                    { 0, 70,  0,  0,  0,  0, 11, 21, 12, 12,011, 12, 21, 13,  0,  0},
                                    {32, 33,  0, 34,  0,  0, 11, 13,  4,  4, 11,  0, 11, 13,  0, 34},
                                    { 0, 70,  0,  0,  0,  0, 11, 13,  4, 73, 11, 71,114, 13,  0,  0},
                                    { 0, 70,  0,  0,  0,  0, 11, 13,  0, 13,  6,  4, 11, 13,  0,  0},
                                    {32, 31,  0, 34,  0,  0, 11, 13, 72, 13,  4,  4, 11, 13,  0, 34},
                                    { 0, 70,  0,  0,  0,  0, 11, 21, 14,143, 14, 14, 21, 13,  0,  0},
                                    {32, 31,  0, 34,  0,  4, 12, 12, 12, 12, 12, 12, 12, 22,  4, 34},
                                    { 0, 70,  0,  0,  0,  4,  4,  0,  0,  0,  0,  0,  0,  4,  4,  0},
                                    { 0, 70,  0,  0,  0,  0, 33,  0, 33,  0,  0, 33,  0, 33,  0,  6}};

    public IslandKingMap() {
        super("Island King");
        generateMap(map);
    }
}
