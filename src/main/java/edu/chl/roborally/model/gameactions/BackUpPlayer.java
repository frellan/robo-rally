package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.Position;

/**
 * Created by henriknilson on 21/04/15.
 */
public class BackUpPlayer implements GameAction {

    @Override
    public void action(Player p) {
        switch (p.getDirection()) {
            case NORTH:
                p.setPosition(new Position(p.getPosition().getX(), p.getPosition().getY() + 1));
                break;
            case SOUTH:
                p.setPosition(new Position(p.getPosition().getX(), p.getPosition().getY() - 1));
            case EAST:
                p.setPosition(new Position(p.getPosition().getX()-1, p.getPosition().getY()));
                break;
            case WEST:
                p.setPosition(new Position(p.getPosition().getX()+1, p.getPosition().getY()));
        }
    }
}
