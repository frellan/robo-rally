package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.tiles.GameTile;

/**
 * Created by Pertta on 15-05-12.
 */
public class RepairPlayer extends GameAction {

    public RepairPlayer(Player p) {
        super(p);
        action();
    }

    @Override
    public void action() {
        super.player.repair();
    }
}
