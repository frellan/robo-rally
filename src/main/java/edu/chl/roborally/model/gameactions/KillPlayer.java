package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Player;

/**
 * Created by henriknilson on 31/03/15.
 */
public class KillPlayer extends GameAction{

    public KillPlayer(Player p) {
        super(p);
        action();
    }


    @Override
    public void action() {
        super.player.kill();
    }
}
