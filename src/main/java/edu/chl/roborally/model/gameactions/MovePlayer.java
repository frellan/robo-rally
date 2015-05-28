package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.Position;

/**
 * Created by henriknilson on 31/03/15.
 */
public class MovePlayer implements GameAction {

    private Constants.Directions direction;

    public MovePlayer() {
        this.direction = null;
    }

    public MovePlayer(Constants.Directions direction) {
        this.direction = direction;
    }

    @Override
    public void doAction(Player p) {
        if (direction == null) {
            direction = p.getMovingDirection();
        }
        switch (direction) {
            case NORTH:
                p.setNextPosition(new Position(p.getPosition().getX(), p.getPosition().getY() - 1));
                break;
            case SOUTH:
                p.setNextPosition(new Position(p.getPosition().getX(), p.getPosition().getY() + 1));
                break;
            case EAST:
                p.setNextPosition(new Position(p.getPosition().getX() + 1, p.getPosition().getY()));
                break;
            case WEST:
                p.setNextPosition(new Position(p.getPosition().getX() - 1, p.getPosition().getY()));
                break;
            case WEST_NORTH:
                p.setNextPosition(new Position(p.getPosition().getX(), p.getPosition().getY() - 1));
                break;
            case EAST_NORTH:
                p.setNextPosition(new Position(p.getPosition().getX(), p.getPosition().getY() - 1));
                break;
            case WEST_SOUTH:
                p.setNextPosition(new Position(p.getPosition().getX(), p.getPosition().getY() + 1));
                break;
            case EAST_SOUTH:
                p.setNextPosition(new Position(p.getPosition().getX(), p.getPosition().getY() + 1));
                break;
            case NORTH_EAST:
                p.setNextPosition(new Position(p.getPosition().getX() + 1, p.getPosition().getY()));
                break;
            case SOUTH_EAST:
                p.setNextPosition(new Position(p.getPosition().getX() + 1, p.getPosition().getY()));
                break;
            case NORTH_WEST:
                p.setNextPosition(new Position(p.getPosition().getX() - 1, p.getPosition().getY()));
                break;
            case SOUTH_WEST:
                p.setNextPosition(new Position(p.getPosition().getX() - 1, p.getPosition().getY()));
                break;
        }
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, "Moving ", null);
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, p.getName() + "\n" , p.getColor());
        EventTram.getInstance().publish(EventTram.Event.EXECUTE_TILE_ACTION_BEFORE,p,null);
    }
}
