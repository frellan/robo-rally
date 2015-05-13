package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Player;

/**
 * Created by Pertta on 15-05-13.
 */
public class CheckpointPlayer extends GameAction {

    public CheckpointPlayer(Player player) {
        super(player);
        action();
    }

    @Override
    void action() {
        super.player.setCheckpoint(super.player.getPosition());
    }
}
