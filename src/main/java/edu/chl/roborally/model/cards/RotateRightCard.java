package edu.chl.roborally.model.cards;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.RotatePlayer;

/**
 * Created by fredrikkindstrom on 31/03/15.
 */
public class RotateRightCard extends RegisterCard{

    private Constants.Directions d;

    public RotateRightCard(int points, boolean isHidden) {
        super(points,isHidden, "Rotate Right");
        this.d = Constants.Directions.EAST;
    }

    public void doAction(Player p) {
        new RotatePlayer(p,d);
    }
}
