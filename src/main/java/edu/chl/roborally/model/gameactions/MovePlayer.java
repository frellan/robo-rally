package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.Position;

/**
 * Created by henriknilson on 31/03/15.
 *
 * This class represents the gameaction to change a players position on the
 * gameboard. The new position is validated by the turn class
 */
public class MovePlayer implements GameAction {

    /**
     * The direction variable indicates in which direction the player should move in.
     */
    private Constants.Directions direction;

    /**
     * Default constructor, sets the direction varible to null
     * and uses the players movingDirection instead.
     */
    public MovePlayer() {
        this.direction = null;
    }

    /**
     * Constructor which takes a direction as argument and moves the player
     * in the given direction.
     * @param direction in which the player should move.
     */
    public MovePlayer(Constants.Directions direction) {
        this.direction = direction;
    }

    @Override
    public void doAction(Player player) {
        if (direction == null) {
            // Card move and push
            direction = player.getMovingDirection();
        } else {
            // For tile action
            player.setMovingDirection(direction);
        }
        switch (direction) {
            case NORTH:
                player.setNextPosition(new Position(player.getPosition().getX(), player.getPosition().getY() - 1));
                break;
            case SOUTH:
                player.setNextPosition(new Position(player.getPosition().getX(), player.getPosition().getY() + 1));
                break;
            case EAST:
                player.setNextPosition(new Position(player.getPosition().getX() + 1, player.getPosition().getY()));
                break;
            case WEST:
                player.setNextPosition(new Position(player.getPosition().getX() - 1, player.getPosition().getY()));
                break;
            case WEST_NORTH:
                player.setNextPosition(new Position(player.getPosition().getX(), player.getPosition().getY() - 1));
                break;
            case EAST_NORTH:
                player.setNextPosition(new Position(player.getPosition().getX(), player.getPosition().getY() - 1));
                break;
            case WEST_SOUTH:
                player.setNextPosition(new Position(player.getPosition().getX(), player.getPosition().getY() + 1));
                break;
            case EAST_SOUTH:
                player.setNextPosition(new Position(player.getPosition().getX(), player.getPosition().getY() + 1));
                break;
            case NORTH_EAST:
                player.setNextPosition(new Position(player.getPosition().getX() + 1, player.getPosition().getY()));
                break;
            case SOUTH_EAST:
                player.setNextPosition(new Position(player.getPosition().getX() + 1, player.getPosition().getY()));
                break;
            case NORTH_WEST:
                player.setNextPosition(new Position(player.getPosition().getX() - 1, player.getPosition().getY()));
                break;
            case SOUTH_WEST:
                player.setNextPosition(new Position(player.getPosition().getX() - 1, player.getPosition().getY()));
                break;
        }
    }
}
