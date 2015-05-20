package edu.chl.roborally.model.maps;

import edu.chl.roborally.utilities.Constants;

/**
 * Created by axel on 2015-03-30.
 */
public class BlankMap extends GameBoard implements IMap{

    private final Constants.Difficulty difficulty;
    private final String players;
    private final String name;
    private final int[][] map = {   { 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0}};

    public BlankMap(){
        this.name = "";
        this.difficulty = Constants.Difficulty.HARD;
        this.players = "2-4";
        generateMap(map);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDifficulty() {
        return null;
    }

    @Override
    public String getNbrOfPlayers() {
        return null;
    }
}
