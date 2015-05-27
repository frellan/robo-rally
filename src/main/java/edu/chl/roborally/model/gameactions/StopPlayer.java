package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.WallException;

/**
 * Created by Pertta on 15-05-12.
 */
public class StopPlayer implements GameAction {

    @Override
    public void doAction(Player p) throws WallException {
        //p.setPosition(new Position(p.getPosition().getX(), p.getPosition().getY()));
        throw new WallException();
    }
}
