package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Player;

/**
 * Created by henriknilson on 21/04/15.
 *
 * This action sets a new position for a player that the Turn class checks and sets if valid on the board.
 * Makes the player back up one step using the other move player action to not replicate code.
 */
public class BackUpPlayer extends GameAction {

    public BackUpPlayer() {}

    @Override
    public void doAction(Player player) {
        player.setMovingDirection(player.getDirection().getOpposite());
        new MovePlayer().doAction(player);
    }
}
