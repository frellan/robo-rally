package edu.chl.roborally.model.gameactions;

import com.sun.tools.javac.code.Attribute;
import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.Position;

/**
 * Created by henriknilson on 31/03/15.
 */
public class MovePlayer {

    private Player p;
    private Constants.Directions d;

    public MovePlayer(Player p, Constants.Directions d) {
        this.p = p;
        this.d = d;
    }

    public MovePlayer(Player p) {
        this.p = p;
        this.d = p.getDirection();
    }

    private void action() {
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
