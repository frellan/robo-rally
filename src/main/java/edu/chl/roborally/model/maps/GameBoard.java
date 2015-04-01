package edu.chl.roborally.model.maps;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.Position;
import edu.chl.roborally.model.tiles.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by axel on 2015-03-26.
 */
public abstract class GameBoard {

    private GameTile[][] board;
    private List<Position> startPositions = new ArrayList<>();
    private String name;


    public GameBoard(String n){

        this.board = new GameTile[Constants.NUM_ROWS][Constants.NUM_COLS];
        this.name = n;

        //Fills the board with BlankTiles
        for (int row = 0; row < Constants.NUM_ROWS; row ++){
            for(int col = 0; col < Constants.NUM_COLS; col++){
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
    public ArrayList<Position> getStartPositions(int nbrOfPlayers){
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

    // Print board
    public void printBoard() {
        System.out.println("-------------------------");
        System.out.println("Board = " + name);
        System.out.println("-------------------------");
        for (int i = 0; i<this.board.length; i++) {
            System.out.print("|");
            for (int j = 0; j<this.board[i].length; j++) {
                System.out.print(this.board[i][j].toString() + "|");
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }

}
