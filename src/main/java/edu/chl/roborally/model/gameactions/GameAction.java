package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Player;

/**
 * Created by henriknilson on 31/03/15.
 */
public abstract class GameAction {

    protected Player player;

    public GameAction(Player p) {
        this.player = p;
    }

    abstract void action();

}
