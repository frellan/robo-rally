package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.Position;

/**
 * Created by henriknilson on 31/03/15.
 */
public class MovePlayer extends GameAction {

    private Constants.Directions d;

    public MovePlayer(Player p, Constants.Directions d) {
        super(p);
        this.d = d;
        action();

        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE,"Moved " + p.getName() + "\n" +
                                        "New position " + p.getPosition().toString() + "\n", null);
    }

    public MovePlayer(Player p) {
        this(p, p.getDirection());
    }

    @Override
    public void action() {
        switch (d) {
            case NORTH:
                super.player.setPosition(new Position(super.player.getPosition().getX(), super.player.getPosition().getY() - 1));
                break;
            case SOUTH:
                super.player.setPosition(new Position(super.player.getPosition().getX(), super.player.getPosition().getY() + 1));
                break;
            case EAST:
                super.player.setPosition(new Position(super.player.getPosition().getX()+1, super.player.getPosition().getY()));
                break;
            case WEST:
                super.player.setPosition(new Position(super.player.getPosition().getX()-1, super.player.getPosition().getY()));
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
                super.player.setPosition(new Position(super.player.getPosition().getX()+1, super.player.getPosition().getY()));
                break;
            case SOUTH_EAST:
                super.player.setPosition(new Position(super.player.getPosition().getX()+1, super.player.getPosition().getY()));
                break;
            case NORTH_WEST:
                super.player.setPosition(new Position(super.player.getPosition().getX()-1, super.player.getPosition().getY()));
                break;
            case SOUTH_WEST:
                super.player.setPosition(new Position(super.player.getPosition().getX()-1, super.player.getPosition().getY()));
                break;
        }
    }
}
