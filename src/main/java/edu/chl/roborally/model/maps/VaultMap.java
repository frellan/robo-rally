package edu.chl.roborally.model.maps;

import edu.chl.roborally.model.Constants;
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
        board[0][9] = new ConveyorTile(Constants.Directions.EAST);
        board[2][5] = new ConveyorTile(Constants.Directions.EAST);
        board[3][5] = new ConveyorTile(Constants.Directions.EAST);
        board[4][5] = new ConveyorTile(Constants.Directions.EAST);
        board[8][5] = new ConveyorTile(Constants.Directions.EAST);
        board[9][5] = new ConveyorTile(Constants.Directions.EAST);
        board[10][5] = new ConveyorTile(Constants.Directions.EAST);
        board[11][5] = new ConveyorTile(Constants.Directions.EAST);

        //Conveyors West
        board[14][0] = new ConveyorTile(Constants.Directions.WEST);
        board[14][4] = new ConveyorTile(Constants.Directions.WEST);
        board[14][5] = new ConveyorTile(Constants.Directions.WEST);
        board[14][6] = new ConveyorTile(Constants.Directions.WEST);
        board[14][7] = new ConveyorTile(Constants.Directions.WEST);
        board[14][9] = new ConveyorTile(Constants.Directions.WEST);

        //Express Conveyors East
        board[9][10] = new ConveyorTile(Constants.Directions.EAST);
        board[9][11] = new ConveyorTile(Constants.Directions.EAST);
        board[12][11] = new ConveyorTile(Constants.Directions.EAST);

        //Express Conveyors South
        board[14][10] = new ConveyorTile(Constants.Directions.SOUTH);
        board[13][10] = new ConveyorTile(Constants.Directions.SOUTH);

        //Rotators Right
        board[14][3] = new RotationTile(Constants.Directions.EAST);
        board[15][10] = new RotationTile(Constants.Directions.EAST);




    }

}
