package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Player;

/**
 * Created by Pertta on 15-05-12.
 */
public class RepairPlayer extends GameAction {

    @Override
    public void doAction(Player player) {
        player.repair();
    }
}
