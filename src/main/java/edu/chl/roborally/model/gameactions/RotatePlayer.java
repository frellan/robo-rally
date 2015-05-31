package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.EventTram;

/**
 * Created by henriknilson on 31/03/15.
 */
public class RotatePlayer extends GameAction {

    private Constants.Directions d;

    public RotatePlayer(Constants.Directions d) {
        this.d = d;
    }

    @Override
    public void doAction(Player player) {
        switch(d) {

            // Turn Right
            case EAST:
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

            // Turn Left
            case WEST:
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
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, " " + d + "\n", null);
        EventTram.getInstance().publish(EventTram.Event.EXECUTE_TILE_ACTION_BEFORE, player,null);
    }
}
