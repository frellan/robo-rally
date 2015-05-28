package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Player;

/**
 * Created by henriknilson on 31/03/15.
 *
 * This interface is used to describe how a GameAction should work.
 */

public interface GameAction {

    /**
     * This method is called when a action should be executed.
     * @param player is the player who is affected by the gameaction.
     */
    void doAction(Player player);

}
