package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.WallException;

/**
 * Created by henriknilson on 31/03/15.
 */
public interface GameAction {
    void doAction(Player p);

}
