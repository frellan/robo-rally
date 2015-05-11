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
                board[col][row] = generateTile(map[row][col]);
            }
        }
    }

    private GameTile generateTile(int tileNbr) {
        switch (tileNbr) {
            case 0:
                return new BlankTile();
            case 11:
                return new ConveyorTile(Constants.Directions.NORTH);
            case 12:
                return new ConveyorTile(Constants.Directions.WEST);
            case 13:
                return new ConveyorTile(Constants.Directions.SOUTH);
            case 14:
                return new ConveyorTile(Constants.Directions.EAST);
            case 15:
                return new ConveyorTile(Constants.Directions.NORTH_WEST);
            case 16:
                return new ConveyorTile(Constants.Directions.NORTH_EAST);
            case 17:
                return new ConveyorTile(Constants.Directions.SOUTH_WEST);
            case 18:
                return new ConveyorTile(Constants.Directions.SOUTH_EAST);
            case 21:
                return new RotationTile(Constants.Directions.WEST);
            case 22:
                return new RotationTile(Constants.Directions.EAST);
            case 31:
                return new WallTile(Constants.Directions.NORTH);
            case 32:
                return new WallTile(Constants.Directions.WEST);
            case 33:
                return new WallTile(Constants.Directions.SOUTH);
            case 34:
                return new WallTile(Constants.Directions.EAST);
            case 4:
                return new PitTile();
            case 5:
                return new StartTile();
        }
        return new BlankTile();
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

