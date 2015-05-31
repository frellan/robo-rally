package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.Position;

/**
 * Created by henriknilson on 21/04/15.
 */
public class BackUpPlayer extends GameAction {

    public BackUpPlayer() {}

    @Override
    public void doAction(Player player) {
        player.setMovingDirection(player.getDirection().getOpposite());
        new MovePlayer().doAction(player);
    }
}
