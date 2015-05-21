package edu.chl.roborally.model.maps;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.utilities.Position;

/**
 * Created by axel on 2015-03-30.
 */
public class IslandKingMap extends GameBoard {

    private final Constants.Difficulty difficulty;
    private final String players;
    private final String name;
    private final int[][] map = {   { 0,703,  0,  0,  0,  0, 61,  0, 31,  0,  0, 31,  0, 31,  0,  0},
                                    { 0, 70,  0,  0,  0,  4,  4,  0,  0,  0,  0,  0,  0,  4,  4,  0},
                                    {32, 33,  0, 34,  0,  4, 11, 14, 14, 14,143, 14, 14, 22,  4, 34},
                                    { 0, 70,  0,  0,  0,  0, 11, 21, 12, 12,011, 12, 21, 13,  0,  0},
                                    {32, 33,  0, 34,  0,  0, 11, 13,  4,  4, 11,  0, 11, 13,  0, 34},
                                    { 0, 70,  0,  0,  0,  0, 11, 13,  4, 75, 11, 71,114, 13,  0,  0},
                                    { 0, 70,  0,  0,  0,  0, 11, 13,  0, 13,  6,  4, 11, 13,  0,  0},
                                    {32, 31,  0, 34,  0,  0, 11, 13, 72, 13,  4,  4, 11, 13,  0, 34},
                                    { 0, 70,  0,  0,  0,  0, 11, 21, 14,143, 14, 14, 21, 13,  0,  0},
                                    {32, 31,  0, 34,  0,  4, 12, 12, 12, 12, 12, 12, 12, 22,  4, 34},
                                    { 0, 70,  0,  0,  0,  4,  4,  0,  0,  0,  0,  0,  0,  4,  4,  0},
                                    { 0, 70,  0,  0,  0,  0, 33,  0, 33,  0,  0, 33,  0, 33,  0,  6}};

    public IslandKingMap() {
        //Set startpositions
        startPositions.add(new Position(1, 5));
        startPositions.add(new Position(1, 6));
        startPositions.add(new Position(1, 3));
        startPositions.add(new Position(1, 8));
        startPositions.add(new Position(1, 1));

        this.name = "Island King";
        this.difficulty = Constants.Difficulty.HARD;
        this.players = "5-8";
        generateMap(map);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDifficulty() {
        return difficulty.toString();
    }

    @Override
    public String getNbrOfPlayers() {
        return players;
    }

    @Override
    public String getMapIcon() {
        return "Island.king.png";
    }
}
