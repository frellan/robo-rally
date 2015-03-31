package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.Position;

/**
 * Created by henriknilson on 31/03/15.
 */
public class MovePlayer implements GameAction {

    private Player p;
    private Constants.Directions d;

    public MovePlayer(Player p, Constants.Directions d) {
        this.p = p;
        this.d = d;
        action();
        System.out.println("Moved " + p.getName());
        System.out.println("New positon " + p.getPosition().toString());
        System.out.println("");
    }

    public MovePlayer(Player p) {
        this(p, p.getDirection());
    }

    @Override
    public void action() {
        switch (d) {
            case NORTH:
                p.setPosition(new Position(p.getPosition().getX(), p.getPosition().getY()+1));
                break;
            case SOUTH:
                p.setPosition(new Position(p.getPosition().getX(), p.getPosition().getY()-1));
            case EAST:
                p.setPosition(new Position(p.getPosition().getX()+1, p.getPosition().getY()));
                break;
            case WEST:
                p.setPosition(new Position(p.getPosition().getX()-1, p.getPosition().getY()));
        }
    }
}
