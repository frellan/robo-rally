package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.Constants;

/**
 * Created by Pertta on 15-05-12.
 */
public class StopPlayer extends GameAction {

    private Constants.Directions d;

    public StopPlayer(Constants.Directions d) {
        this.d = d;
    }

    @Override
    public void doAction(Player player) {
        System.out.println("Kasta wall");
    }
}
