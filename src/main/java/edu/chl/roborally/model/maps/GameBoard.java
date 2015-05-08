package edu.chl.roborally.model.maps;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.utilities.Position;
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

    public GameBoard(String n) {

        this.board = new GameTile[Constants.NUM_COLS][Constants.NUM_ROWS];
        this.name = n;

        startPositions.add(new Position(14, 5));
        startPositions.add(new Position(14, 6));
        startPositions.add(new Position(14, 3));
        startPositions.add(new Position(14, 8));
        startPositions.add(new Position(14, 1));
    }

    //Used to create a specific gameboard
    public void generateMap(int[][] map) {
        //Fills the board with BlankTiles
        for (int col = 0; col < Constants.NUM_COLS; col++) {
            for (int row = 0; row < Constants.NUM_ROWS; row++) {
                fillGameBoard(map[col][row]);
            }
        }
    }

    private void fillGameBoard(int tileNbr) {
        switch (tileNbr) {
            case 0:
                new BlankTile();
                break;
            case 11:
                new ConveyorTile(Constants.Directions.NORTH);
                break;
            case 12:
                new ConveyorTile(Constants.Directions.WEST);
                break;
            case 13:
                new ConveyorTile(Constants.Directions.SOUTH);
                break;
            case 14:
                new ConveyorTile(Constants.Directions.EAST);
                break;
            case 15:
                new ConveyorTile(Constants.Directions.NORTH_WEST);
                break;
            case 16:
                new ConveyorTile(Constants.Directions.NORTH_EAST);
                break;
            case 17:
                new ConveyorTile(Constants.Directions.SOUTH_WEST);
                break;
            case 18:
                new ConveyorTile(Constants.Directions.SOUTH_EAST);
                break;
            case 21:
                new RotationTile(Constants.Directions.WEST);
                break;
            case 22:
                new RotationTile(Constants.Directions.EAST);
                break;
            case 31:
                new WallTile(Constants.Directions.NORTH);
                break;
            case 32:
                new WallTile(Constants.Directions.WEST);
                break;
            case 33:
                new WallTile(Constants.Directions.SOUTH);
                break;
            case 34:
                new WallTile(Constants.Directions.EAST);
                break;
            case 4:
                new PitTile();
                break;
        }
    }

    //Returns startpositions depending on number of players
    public ArrayList<Position> getStartPositions(int nbrOfPlayers) {
        ArrayList<Position> tempList = new ArrayList<>();
        for (int i = 0; i <= nbrOfPlayers; i++) {
            tempList.add(startPositions.get(i));
        }
        return tempList;
    }

    //Returns the board array
    public GameTile[][] getBoard() {
        return board;
    }

    // Return tile on given Position
    public GameTile getTile(Position pos) throws ArrayIndexOutOfBoundsException {
        return this.board[pos.getX()][pos.getY()];
    }

    // Return tile on given x and y coordinate
    public GameTile getTile(int x, int y) throws ArrayIndexOutOfBoundsException {
        return this.board[x][y];
    }

    public String getName() {
        return this.name;
    }
}

