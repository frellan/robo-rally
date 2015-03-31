package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.Player;

/**
 * Created by henriknilson on 31/03/15.
 */
public class KillPlayer implements GameAction{

    private Player p;

    private KillPlayer(Player p) {
        this.p = p;
    }


    @Override
    public void action() {
        // Set status to Dead
        p.setStatus(Constants.Status.DEAD);
        // Reset all damgetokens
        p.resetDamgetokens();
        // Move player back to last checkpoint
        p.backToCheckpoint();
        // TODO Remove one lifetoken
    }
}
