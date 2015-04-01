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
        super("Vault Map");
        fillGameBoard();
    }

    public void fillGameBoard(){

        //Conveyors East
        board[1][10] = new ConveyorTile(Constants.Directions.EAST);
        board[3][6] = new ConveyorTile(Constants.Directions.EAST);
        board[4][6] = new ConveyorTile(Constants.Directions.EAST);
        board[5][6] = new ConveyorTile(Constants.Directions.EAST);
        board[9][6] = new ConveyorTile(Constants.Directions.EAST);
        board[10][6] = new ConveyorTile(Constants.Directions.EAST);
        board[11][6] = new ConveyorTile(Constants.Directions.EAST);
        board[12][6] = new ConveyorTile(Constants.Directions.EAST);

        //Conveyors West
        board[15][1] = new ConveyorTile(Constants.Directions.WEST);
        board[15][5] = new ConveyorTile(Constants.Directions.WEST);
        board[15][6] = new ConveyorTile(Constants.Directions.WEST);
        board[15][7] = new ConveyorTile(Constants.Directions.WEST);
        board[15][8] = new ConveyorTile(Constants.Directions.WEST);
        board[15][10] = new ConveyorTile(Constants.Directions.WEST);

        //Express Conveyors East
        board[10][11] = new ConveyorTile(Constants.Directions.EAST);
        board[10][12] = new ConveyorTile(Constants.Directions.EAST);
        board[13][12] = new ConveyorTile(Constants.Directions.EAST);

        //Express Conveyors South
        board[15][11] = new ConveyorTile(Constants.Directions.SOUTH);
        board[14][11] = new ConveyorTile(Constants.Directions.SOUTH);

        //Rotators Right
        board[15][4] = new RotationTile(Constants.Directions.EAST);
        board[16][11] = new RotationTile(Constants.Directions.EAST);




    }

}
