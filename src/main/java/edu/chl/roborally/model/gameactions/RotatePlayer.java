package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.EventTram;

/**
 * Created by henriknilson on 31/03/15.
 *
 * This action rotates a player to the left or to the right.
 */
public class RotatePlayer extends GameAction {

    private final Constants.Directions direction;

    public RotatePlayer(Constants.Directions direction) {
        this.direction = direction;
    }

    @Override
    public void doAction(Player player) {
        switch(direction) {
            case RIGHT:
                switch (player.getDirection()) {
                    case NORTH:
                        player.setDirection(Constants.Directions.EAST);
                        break;
                    case EAST:
                        player.setDirection(Constants.Directions.SOUTH);
                        break;
                    case SOUTH:
                        player.setDirection(Constants.Directions.WEST);
                        break;
                    case WEST:
                        player.setDirection(Constants.Directions.NORTH);
                }
                break;
            case LEFT:
                switch (player.getDirection()) {
                    case NORTH:
                        player.setDirection(Constants.Directions.WEST);
                        break;
                    case WEST:
                        player.setDirection(Constants.Directions.SOUTH);
                        break;
                    case SOUTH:
                        player.setDirection(Constants.Directions.EAST);
                        break;
                    case EAST:
                        player.setDirection(Constants.Directions.NORTH);
                        break;
                }
                break;
        }
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, "Rotating ", null);
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, player.getName() , player.getColor());
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, " " + direction + "\n", null);
        EventTram.getInstance().publish(EventTram.Event.EXECUTE_TILE_ACTION_BEFORE, player,null);
    }
}
