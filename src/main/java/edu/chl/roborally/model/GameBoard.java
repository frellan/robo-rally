package edu.chl.roborally.model;

import edu.chl.roborally.model.tiles.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by axel on 2015-03-26.
 */
public abstract class GameBoard {

    private static final int NUM_ROWS = 16;
    private static final int NUM_COLS = 12;
    private GameTile[][] board;
    private List<Position> startPositions = new ArrayList<>();


    public GameBoard(){

        this.board = new GameTile[NUM_ROWS][NUM_COLS];

        //Fills the board with BlankTiles
        for (int row = 0; row < NUM_ROWS; row ++){
            for(int col = 0; col < NUM_COLS; col++){
                board[row][col] = new BlankTile();
            }
        }

        startPositions.add(new Position(2,6));
        startPositions.add(new Position(2,7));
        startPositions.add(new Position(2,4));
        startPositions.add(new Position(2,9));
        startPositions.add(new Position(2,2));
    }

    //Used to create a specific gameboard
    public abstract void fillGameBoard();


    //Returns startpositions depending on number of players
    public ArrayList<Position> getStartPosition(int nbrOfPlayers){
        ArrayList<Position> tempList = new ArrayList<>();
        for (int i = 0; i <= nbrOfPlayers; i ++){
            tempList.add(startPositions.get(i));
        }
        return tempList;
    }

    //Returns the board
    public GameTile[][] getBoard(){
        return board;
    }

}
