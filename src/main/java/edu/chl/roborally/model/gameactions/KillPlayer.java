package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.Player;

/**
 * Created by henriknilson on 31/03/15.
 */
public class KillPlayer implements GameAction{

    private Player p;
    public KillPlayer(Player p) {
        this.p = p;
        action();
    }


    @Override
    public void action() {
        p.kill();
    }
}
