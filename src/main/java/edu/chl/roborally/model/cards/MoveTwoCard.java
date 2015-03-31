package edu.chl.roborally.model.cards;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.MovePlayer;

/**
 * Created by fredrikkindstrom on 31/03/15.
 */
public class MoveTwoCard extends RegisterCard{

    public MoveTwoCard(int points, boolean isHidden) {
        super(points,isHidden, "Move Two");
    }

    public void doAction(Player p) {
        new MovePlayer(p);
        new MovePlayer(p);
    }
}
