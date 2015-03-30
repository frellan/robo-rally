package edu.chl.roborally.model;

import java.util.ArrayList;

/**
 * Created by axel on 2015-03-26.
 */
public abstract class GameBoard {

    private static final int NUM_COLS = 12;
    private static final int NUM_ROWS = 16;
    private GameTile [][] board;
    private ArrayList<Position> startPositions = new ArrayList<>(new Position(2,6), new Position(2,7),
    new Position(2,4), new Position(2,9), new Position(2,2));


    public GameBoard (){

        this.board = new GameTile[NUM_COLS][NUM_ROWS];

        //fills the gameboard with blanktiles
        for (int row = 0; row <= NUM_ROWS; row ++){
            for(int col = 0; col <= NUM_COLS; col++){
                board[row][col] = new BlankTile();
            }
        }
    }

    //used to create a specific gameboard
    public abstract void fillGameBoard();


    //returns startpositions depending on number of players
    public ArrayList<Position> getStartPosition(int nbrOfPlayers){
        ArrayList<Position> tempList = new ArrayList<>();
        for (int i = 0; i <= nbrOfPlayers; i ++){
            tempList.add(startPositions.get(i));
        }
        return tempList;
    }
}
