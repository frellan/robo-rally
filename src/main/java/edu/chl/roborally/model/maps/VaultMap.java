package edu.chl.roborally.model.maps;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.tiles.*;

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

        //Pit
        board[8][2] = new PitTile();
        board[3][2] = new PitTile();
        board[3][11] = new PitTile();
        board[8][11] = new PitTile();

        //Walls
        board[2][0] = new WallTile(Constants.Directions.WEST);
        board[4][0] = new WallTile(Constants.Directions.WEST);
        board[7][0] = new WallTile(Constants.Directions.WEST);
        board[9][0] = new WallTile(Constants.Directions.WEST);

        board[0][2] = new WallTile(Constants.Directions.NORTH);
        board[0][4] = new WallTile(Constants.Directions.NORTH);
        board[0][7] = new WallTile(Constants.Directions.NORTH);
        board[0][9] = new WallTile(Constants.Directions.NORTH);

        board[11][2] = new WallTile(Constants.Directions.SOUTH);
        board[11][4] = new WallTile(Constants.Directions.SOUTH);
        board[11][7] = new WallTile(Constants.Directions.SOUTH);
        board[11][9] = new WallTile(Constants.Directions.SOUTH);

        board[2][11] = new WallTile(Constants.Directions.WEST);
        board[4][11] = new WallTile(Constants.Directions.WEST);
        board[7][11] = new WallTile(Constants.Directions.WEST);
        board[9][11] = new WallTile(Constants.Directions.WEST);

        board[12][2] = new WallTile(Constants.Directions.NORTH);
        board[12][4] = new WallTile(Constants.Directions.NORTH);
        board[12][7] = new WallTile(Constants.Directions.NORTH);
        board[12][9] = new WallTile(Constants.Directions.NORTH);

        board[15][2] = new WallTile(Constants.Directions.SOUTH);
        board[15][4] = new WallTile(Constants.Directions.SOUTH);
        board[15][7] = new WallTile(Constants.Directions.SOUTH);
        board[15][9] = new WallTile(Constants.Directions.SOUTH);

        board[14][1] = new WallTile(Constants.Directions.WEST);
        board[14][3] = new WallTile(Constants.Directions.WEST);
        board[14][5] = new WallTile(Constants.Directions.WEST);
        board[14][6] = new WallTile(Constants.Directions.WEST);
        board[14][7] = new WallTile(Constants.Directions.WEST);
        board[14][9] = new WallTile(Constants.Directions.WEST);
        board[14][11] = new WallTile(Constants.Directions.WEST);

        board[5][3] = new WallTile(Constants.Directions.EAST);
        board[6][3] = new WallTile(Constants.Directions.EAST);
        board[5][9] = new WallTile(Constants.Directions.WEST);
        board[6][9] = new WallTile(Constants.Directions.WEST);

        board[2][5] = new WallTile(Constants.Directions.SOUTH);
        board[2][6] = new WallTile(Constants.Directions.SOUTH);
        board[8][5] = new WallTile(Constants.Directions.SOUTH);
        board[8][6] = new WallTile(Constants.Directions.SOUTH);

        board[2][3] = new WallTile(Constants.Directions.EAST);

        //Two Directions Wall
        board[4][4] = new WallTile(Constants.Directions.WEST, Constants.Directions.NORTH);
        board[7][4] = new WallTile(Constants.Directions.WEST, Constants.Directions.SOUTH);
        board[4][7] = new WallTile(Constants.Directions.EAST, Constants.Directions.NORTH);
        board[7][7] = new WallTile(Constants.Directions.EAST, Constants.Directions.SOUTH);

    }
}
