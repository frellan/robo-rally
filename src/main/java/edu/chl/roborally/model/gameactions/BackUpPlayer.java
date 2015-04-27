package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.Position;

/**
 * Created by henriknilson on 21/04/15.
 */
public class BackUpPlayer extends GameAction {

    private Constants.Directions d;

    public BackUpPlayer(Player p, Constants.Directions d) {
        super(p);
        this.d = d;
        action();
        System.out.println("Backed up " + p.getName());
        System.out.println("New positon " + p.getPosition().toString());
        System.out.println("");
    }

    public BackUpPlayer(Player p) {
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
            case EAST:
                super.player.setPosition(new Position(super.player.getPosition().getX()-1, super.player.getPosition().getY()));
                break;
            case WEST:
                super.player.setPosition(new Position(super.player.getPosition().getX()+1, super.player.getPosition().getY()));
        }
    }
}
