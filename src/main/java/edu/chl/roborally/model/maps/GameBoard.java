package edu.chl.roborally.model.maps;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.GameAction;
import edu.chl.roborally.utilities.*;
import edu.chl.roborally.model.tiles.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by axel on 2015-03-26.
 */
public abstract class GameBoard implements IEventHandler{

    private GameTile[][] board;
    protected List<Position> startPositions = new ArrayList<>();

    public GameBoard() {

        this.board = new GameTile[Constants.NUM_COLS][Constants.NUM_ROWS];
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
         return TileFactory.getInstance().createTile(tileNbr);
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

    public abstract String getName();
    public abstract String getDifficulty();
    public abstract String getNbrOfPlayers();
    public abstract String getMapIcon();

    @Override
    public void onEvent(EventTram.Event evt, Object o, Object o2) {
        if (EventTram.Event.EXECUTE_TILE_ACTION == evt) {
            Player player = (Player) o;
            player.setBeforePosition(player.getPosition());
            try {
                ArrayList<GameAction> actions = getTile(player.getPosition()).getActions();
                for (GameAction action : actions) {
                    action.doAction(player);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                // If player is out of bounds we kill him
                System.out.println("Player fell of board and died");
                player.kill();
            }
        } else if (EventTram.Event.EXECUTE_TILE_ACTION_BEFORE == evt) {
            Player player = (Player) o;
            ArrayList<GameAction> actions = getTile(player.getPosition()).getBeforeAction();
            for (GameAction action : actions) {
                try {
                    action.doAction(player);
                } catch(ArrayIndexOutOfBoundsException e){
                    // If player is out of bounds we kill him
                    System.out.println("Player fell of board and died");
                    player.kill();
                }
            }
        }
    }
}

