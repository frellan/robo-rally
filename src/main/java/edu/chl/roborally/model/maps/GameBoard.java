package edu.chl.roborally.model.maps;

import edu.chl.roborally.utilities.*;
import edu.chl.roborally.model.tiles.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by axel on 2015-03-26.
 *
 * Superclass fot representing a full game board with tiles.
 */
public abstract class GameBoard{

    private final GameTile[][] board;
    final List<Position> startPositions = new ArrayList<>();

    /**
     * Creates the skeleton array for a board/map.
     */
    GameBoard() {
        this.board = new GameTile[Constants.NUM_COLS][Constants.NUM_ROWS];
    }

    /**
     * This is used to fill the board with tiles.
     * Called from the subclasses with different information depending on the map.
     * @param map
     */
    void generateMap(int[][] map) {
        for (int col = 0; col < Constants.NUM_COLS; col++) {
            for (int row = 0; row < Constants.NUM_ROWS; row++) {
                board[col][row] = TileFactory.getInstance().createTile(map[row][col]);
            }
        }
    }

    /**
     * Returns the startpositions set by the subclass (specific map).
     * @param nbrOfPlayers The ampount of players to return start positions for.
     * @return A list containing the start positions.
     */
    public ArrayList<Position> getStartPositions(int nbrOfPlayers) {
        ArrayList<Position> tempList = new ArrayList<>();
        for (int i = 0; i <= nbrOfPlayers; i++) {
            tempList.add(startPositions.get(i));
        }
        return tempList;
    }

    /**
     * Returns a tile at a given position on the map.
     * @param pos The position to look at.
     * @return The tile at that position.
     * @throws ArrayIndexOutOfBoundsException When the position is not on the board.
     */
    public GameTile getTile(Position pos) throws ArrayIndexOutOfBoundsException {
        return this.board[pos.getX()][pos.getY()];
    }

    /**
     * Returns a tile at a given x and y position.
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @return The tile at that position.
     * @throws ArrayIndexOutOfBoundsException When the position is not on the board.
     */
    public GameTile getTile(int x, int y) throws ArrayIndexOutOfBoundsException {
        return this.board[x][y];
    }

    public abstract String getName();
    public abstract String getDifficulty();
    public abstract String getNbrOfPlayers();
    public abstract String getMapIcon();

}

