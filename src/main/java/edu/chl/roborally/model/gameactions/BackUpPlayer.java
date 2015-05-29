package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.Position;

/**
 * Created by henriknilson on 21/04/15.
 */
public class BackUpPlayer implements GameAction {

    @Override
    public void doAction(Player player) {
        switch (player.getDirection()) {
            case NORTH:
                player.setPosition(new Position(player.getPosition().getX(), player.getPosition().getY() + 1));
                break;
            case SOUTH:
                player.setPosition(new Position(player.getPosition().getX(), player.getPosition().getY() - 1));
                break;
            case EAST:
                player.setPosition(new Position(player.getPosition().getX() - 1, player.getPosition().getY()));
                break;
            case WEST:
                player.setPosition(new Position(player.getPosition().getX() + 1, player.getPosition().getY()));
                break;
        }
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, "Backing up ", null);
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, player.getName() + "\n", player.getColor());
        EventTram.getInstance().publish(EventTram.Event.EXECUTE_TILE_ACTION_BEFORE, player,null);
    }
}
