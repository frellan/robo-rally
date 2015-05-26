package edu.chl.roborally.model.maps;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.utilities.Position;

/**
 * Created by axel on 2015-03-30.
 */
public class BlankMap extends GameBoard {

    private final Constants.Difficulty difficulty;
    private final String players;
    private final String name;
    private final int[][] map = {   { 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 0, 0,  4,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0},
                                    { 0, 0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 0}};

    public BlankMap(){
        //Set startpositions
        startPositions.add(new Position(1, 5));
        startPositions.add(new Position(1, 6));
        startPositions.add(new Position(1, 3));
        startPositions.add(new Position(1, 8));
        startPositions.add(new Position(1, 1));

        this.name = "Blank Map";
        this.difficulty = Constants.Difficulty.MEDIUM;
        this.players = "2-4";
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
