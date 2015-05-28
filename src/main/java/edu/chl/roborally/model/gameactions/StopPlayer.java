package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.utilities.WallException;

/**
 * Created by Pertta on 15-05-12.
 */
public class StopPlayer implements GameAction {

    private Constants.Directions d;

    public StopPlayer(Constants.Directions d) {
        this.d = d;
    }

    @Override
    public void doAction(Player p) throws WallException {
        throw new WallException();
    }
}
