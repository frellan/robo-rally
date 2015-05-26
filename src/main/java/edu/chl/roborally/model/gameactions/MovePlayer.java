package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.Position;

/**
 * Created by henriknilson on 31/03/15.
 */
public class MovePlayer implements GameAction {

    @Override
    public void doAction(Player p) {
        switch (p.getDirection()) {
            case NORTH:
                p.setPosition(new Position(p.getPosition().getX(), p.getPosition().getY() - 1));
                break;
            case SOUTH:
                p.setPosition(new Position(p.getPosition().getX(), p.getPosition().getY() + 1));
                break;
            case EAST:
                p.setPosition(new Position(p.getPosition().getX() + 1, p.getPosition().getY()));
                break;
            case WEST:
                p.setPosition(new Position(p.getPosition().getX() - 1, p.getPosition().getY()));
                break;
            case WEST_NORTH:
                p.setPosition(new Position(p.getPosition().getX(), p.getPosition().getY() - 1));
                break;
            case EAST_NORTH:
                p.setPosition(new Position(p.getPosition().getX(), p.getPosition().getY() - 1));
                break;
            case WEST_SOUTH:
                p.setPosition(new Position(p.getPosition().getX(), p.getPosition().getY() + 1));
                break;
            case EAST_SOUTH:
                p.setPosition(new Position(p.getPosition().getX(), p.getPosition().getY() + 1));
                break;
            case NORTH_EAST:
                p.setPosition(new Position(p.getPosition().getX() + 1, p.getPosition().getY()));
                break;
            case SOUTH_EAST:
                p.setPosition(new Position(p.getPosition().getX() + 1, p.getPosition().getY()));
                break;
            case NORTH_WEST:
                p.setPosition(new Position(p.getPosition().getX() - 1, p.getPosition().getY()));
                break;
            case SOUTH_WEST:
                p.setPosition(new Position(p.getPosition().getX() - 1, p.getPosition().getY()));
                break;
        }

        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, "Priority " + getPoints() + ": Moving ", null);
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, p.getName() , p.getColor());
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, " One Tile" + "\n", null);

        EventTram.getInstance().publish(EventTram.Event.EXECUTE_TILE_ACTION_BEFORE,p,null);
    }
}
