package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.Position;

/**
 * Created by Pertta on 15-05-12.
 */
public class StopPlayer extends GameAction {

    public StopPlayer(Player p) {
        super(p);
    }

    @Override
    void action() {
        super.player.setPosition(new Position(super.player.getPosition().getX(), super.player.getPosition().getY()));
    }
}
