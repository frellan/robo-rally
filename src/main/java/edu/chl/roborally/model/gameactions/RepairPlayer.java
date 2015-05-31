package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Player;

/**
 * Created by Pertta on 15-05-12.
 *
 * This action repars a player, it removes one damage token from the player.
 */
public class RepairPlayer extends GameAction {

    @Override
    public void doAction(Player player) {
        player.repair();
    }
}
