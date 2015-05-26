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
    public void action(Player p) {
        switch (p.getDirection()) {
            case NORTH:
                super.player.setPosition(new Position(super.player.getPosition().getX(), super.player.getPosition().getY() - 1));
                break;
            case SOUTH:
                super.player.setPosition(new Position(super.player.getPosition().getX(), super.player.getPosition().getY() + 1));
                break;
            case EAST:
                super.player.setPosition(new Position(super.player.getPosition().getX() + 1, super.player.getPosition().getY()));
                break;
            case WEST:
                super.player.setPosition(new Position(super.player.getPosition().getX() - 1, super.player.getPosition().getY()));
                break;
            case WEST_NORTH:
                super.player.setPosition(new Position(super.player.getPosition().getX(), super.player.getPosition().getY() - 1));
                break;
            case EAST_NORTH:
                super.player.setPosition(new Position(super.player.getPosition().getX(), super.player.getPosition().getY() - 1));
                break;
            case WEST_SOUTH:
                super.player.setPosition(new Position(super.player.getPosition().getX(), super.player.getPosition().getY() + 1));
                break;
            case EAST_SOUTH:
                super.player.setPosition(new Position(super.player.getPosition().getX(), super.player.getPosition().getY() + 1));
                break;
            case NORTH_EAST:
                super.player.setPosition(new Position(super.player.getPosition().getX() + 1, super.player.getPosition().getY()));
                break;
            case SOUTH_EAST:
                super.player.setPosition(new Position(super.player.getPosition().getX() + 1, super.player.getPosition().getY()));
                break;
            case NORTH_WEST:
                super.player.setPosition(new Position(super.player.getPosition().getX() - 1, super.player.getPosition().getY()));
                break;
            case SOUTH_WEST:
                super.player.setPosition(new Position(super.player.getPosition().getX() - 1, super.player.getPosition().getY()));
                break;
        }
        EventTram.getInstance().publish(EventTram.Event.EXECUTE_TILE_ACTION_BEFORE,p,null);
    }
}
