package edu.chl.roborally.model.cards;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.MovePlayer;
import edu.chl.roborally.model.gameactions.RotatePlayer;

/**
 * Created by fredrikkindstrom on 31/03/15.
 */
public class UTurnCard extends RegisterCard{

    private Constants.Directions d;


    public UTurnCard(int points, boolean isHidden) {
        super(points,isHidden);
        this.d = Constants.Directions.WEST;
    }

    public void doAction(Player p) {
        new RotatePlayer(p,d);
        new RotatePlayer(p,d);
    }
}
