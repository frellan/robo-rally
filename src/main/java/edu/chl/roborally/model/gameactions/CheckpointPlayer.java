package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Player;

/**
 * Created by Pertta on 15-05-13.
 */
public class CheckpointPlayer implements GameAction {

    @Override
    public void action(Player p) {
        p.setCheckpoint(p.getPosition());
    }
}
