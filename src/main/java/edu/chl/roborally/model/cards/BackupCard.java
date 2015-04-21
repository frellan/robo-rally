package edu.chl.roborally.model.cards;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.*;

/**
 * Created by fredrikkindstrom on 31/03/15.
 */
public class BackupCard extends RegisterCard{

    public BackupCard(int points, boolean isHidden) {
        super(points,isHidden, "Back Up");
    }

    public void doAction(Player p) {
        //TODO
       new BackUpPlayer(p);
    }
}
