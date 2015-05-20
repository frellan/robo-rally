package edu.chl.roborally.model.maps;

import edu.chl.roborally.utilities.Constants;

/**
 * Created by Pertta on 15-05-20.
 */
public class RiskyExchangeMap extends GameBoard {

    private final Constants.Difficulty difficulty;
    private final String players;
    private final String name;
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
    private final int[][] map = {   {  0, 13,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    {  0, 13,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 19, 15,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 13, 70,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 13, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    {703, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 70, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 11, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 11, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    {  0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    {  0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    {  0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0}};

    public RiskyExchangeMap(){
        this.name = "Risky Exchange";
        this.difficulty = Constants.Difficulty.EASY;
        this.players = "2-8";
        generateMap(map);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDifficulty() {
        return this.difficulty.toString();
    }

    @Override
    public String getNbrOfPlayers() {
        return players;
    }
}
