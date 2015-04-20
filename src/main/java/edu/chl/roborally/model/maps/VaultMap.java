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
        board[6][0] = new ConveyorTile(Constants.Directions.EAST);
        board[10][2] = new ConveyorTile(Constants.Directions.EAST);
        board[10][3] = new ConveyorTile(Constants.Directions.EAST);
        board[10][4] = new ConveyorTile(Constants.Directions.EAST);
        board[10][8] = new ConveyorTile(Constants.Directions.EAST);
        board[10][9] = new ConveyorTile(Constants.Directions.EAST);
        board[10][10] = new ConveyorTile(Constants.Directions.EAST);
        board[10][11] = new ConveyorTile(Constants.Directions.EAST);

        //Conveyors West
        board[0][9] = new ConveyorTile(Constants.Directions.WEST);
        board[1][0] = new ConveyorTile(Constants.Directions.WEST);
        board[1][4] = new ConveyorTile(Constants.Directions.WEST);
        board[1][5] = new ConveyorTile(Constants.Directions.WEST);
        board[1][6] = new ConveyorTile(Constants.Directions.WEST);
        board[1][7] = new ConveyorTile(Constants.Directions.WEST);

        //Conveyors North
        board[0][3] = new ConveyorTile(Constants.Directions.NORTH);

        //Conveyors South
        board[0][1] = new ConveyorTile(Constants.Directions.SOUTH);
        board[7][1] = new ConveyorTile(Constants.Directions.SOUTH);
        board[8][1] = new ConveyorTile(Constants.Directions.SOUTH);
        board[9][1] = new ConveyorTile(Constants.Directions.SOUTH);
        board[11][5] = new ConveyorTile(Constants.Directions.SOUTH);


        //Express Conveyors East
        board[6][10] = new ConveyorTile(Constants.Directions.EAST);
        board[6][11] = new ConveyorTile(Constants.Directions.EAST);
        board[3][11] = new ConveyorTile(Constants.Directions.EAST);

        //Express Conveyors South
        board[1][10] = new ConveyorTile(Constants.Directions.SOUTH);
        board[2][10] = new ConveyorTile(Constants.Directions.SOUTH);

        //Rotators Right
        board[1][3] = new RotationTile(Constants.Directions.EAST);
        board[0][10] = new RotationTile(Constants.Directions.EAST);




    }

}
