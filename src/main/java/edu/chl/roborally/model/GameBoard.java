package edu.chl.roborally.model;

import java.util.ArrayList;

/**
 * Created by axel on 2015-03-26.
 */
public abstract class GameBoard {


    private GameTile [][] startBoard;

    private static final int NUM_COLS = 12;
    private static final int NUM_ROWS = 16;
    private GameTile [][] board;
    private ArrayList <Position> startPosition;




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



    //returns a number of starttiles depending on number of players
    public Position getStartPosition(int nbrofplayers){

        return null;
    }


}
