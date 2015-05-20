package edu.chl.roborally.model.maps;

import edu.chl.roborally.utilities.Constants;

/**
 * Created by Pertta on 15-05-20.
 */
public class RiskyExchangeMap extends GameBoard {

    private final Constants.Difficulty difficulty;
    private final String players;
    private final String name;
    private final int[][] map = {   {  0, 13, 33, 70,  0,  4, 31, 11, 31,  0, 11, 31, 13, 31, 11, 6},
                                    {  0, 13,703,  0,  0, 32,  0, 11,  0, 13, 11, 75, 13,  0,  0, 0},
                                    { 19, 15,  0, 34,  0,  0,  0, 11,  0, 13, 11,  0, 13,  0,  4,34},
                                    { 13, 70,  0, 33, 14, 14, 14, 21,  0, 13, 11,  0, 21, 14, 14,14},
                                    { 13,  0,  0, 34,  0,  0,  0,  0, 33,132, 11, 32,  0,  0,  0,34},
                                    {703, 33,  0,  0,212,212,212,212,212,  0,  0,121, 12, 12, 12,12},
                                    { 70,  0,  0,  0,  0, 14, 14, 14, 14,  0,  0, 14, 14, 14, 14,14},
                                    { 11,  0,  0, 34,  0,  0,  0,  0, 61,232,114, 31,  0,  0, 71,34},
                                    { 11, 70,  0, 31, 12, 12, 12, 21,  0,213, 11,  0, 12, 12, 12,12},
                                    {120, 15, 33, 34,  0,  0,  0, 11, 72,213, 11,  0,213, 31,  0,34},
                                    {  0, 11,703,  0, 14, 22, 34, 11,  0,213, 11,  0,213,  0, 22,14},
                                    {  0, 11,  0, 70, 61, 13, 33, 11, 33,213, 11, 33,213, 33, 11, 0}};

    public RiskyExchangeMap() {
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

    @Override
    public String getMapIcon() {
        return "tupp.jpg";
    }
}
