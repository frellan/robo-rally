package edu.chl.roborally.model.maps;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.GameBoard;
import edu.chl.roborally.model.tiles.ConveyorTile;
import edu.chl.roborally.model.tiles.GameTile;
import edu.chl.roborally.model.tiles.RotationTile;

/**
 * Created by axel on 2015-03-30.
 */
public class VaultMap extends GameBoard {

    private GameTile[][] board = getBoard();


    public VaultMap(){
        super();
        fillGameBoard();
    }

    public void fillGameBoard(){

        //Conveyors East
        board[10][1] = new ConveyorTile(Constants.Directions.EAST, false);
        board[6][3] = new ConveyorTile(Constants.Directions.EAST, false);
        board[6][4] = new ConveyorTile(Constants.Directions.EAST, false);
        board[6][5] = new ConveyorTile(Constants.Directions.EAST, false);
        board[6][9] = new ConveyorTile(Constants.Directions.EAST, false);
        board[6][10] = new ConveyorTile(Constants.Directions.EAST, false);
        board[6][11] = new ConveyorTile(Constants.Directions.EAST, false);
        board[6][12] = new ConveyorTile(Constants.Directions.EAST, false);

        //Conveyors West
        board[1][15] = new ConveyorTile(Constants.Directions.WEST, false);
        board[5][15] = new ConveyorTile(Constants.Directions.WEST, false);
        board[6][15] = new ConveyorTile(Constants.Directions.WEST, false);
        board[7][15] = new ConveyorTile(Constants.Directions.WEST, false);
        board[8][15] = new ConveyorTile(Constants.Directions.WEST, false);
        board[10][15] = new ConveyorTile(Constants.Directions.WEST, false);

        //Express Conveyors East
        board[11][10] = new ConveyorTile(Constants.Directions.EAST, true);
        board[12][10] = new ConveyorTile(Constants.Directions.EAST, true);
        board[12][13] = new ConveyorTile(Constants.Directions.EAST, true);

        //Express Conveyors South
        board[11][15] = new ConveyorTile(Constants.Directions.SOUTH, true);
        board[11][14] = new ConveyorTile(Constants.Directions.SOUTH, true);

        //Rotators Right
        board[4][15] = new RotationTile(true);
        board[11][16] = new RotationTile(true);




    }

}
