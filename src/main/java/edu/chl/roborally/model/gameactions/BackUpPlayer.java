package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.Position;

/**
 * Created by henriknilson on 21/04/15.
 */
public class BackUpPlayer implements GameAction {

    @Override
    public void doAction(Player p) {
        switch (p.getDirection()) {
            case NORTH:
                p.setPosition(new Position(p.getPosition().getX(), p.getPosition().getY() + 1));
                break;
            case SOUTH:
                p.setPosition(new Position(p.getPosition().getX(), p.getPosition().getY() - 1));
                break;
            case EAST:
                p.setPosition(new Position(p.getPosition().getX() - 1, p.getPosition().getY()));
                break;
            case WEST:
                p.setPosition(new Position(p.getPosition().getX() + 1, p.getPosition().getY()));
                break;
        }
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, "Backing up ", null);
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, p.getName() + "\n", p.getColor());
        EventTram.getInstance().publish(EventTram.Event.EXECUTE_TILE_ACTION_BEFORE,p,null);
    }
}
