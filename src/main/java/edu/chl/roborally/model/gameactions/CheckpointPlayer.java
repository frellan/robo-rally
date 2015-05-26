package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Player;

/**
 * Created by Pertta on 15-05-13.
 */
public class CheckpointPlayer implements GameAction {

    @Override
<<<<<<< HEAD
    public void doAction(Player p) {
=======
    public void action(Player p) {
>>>>>>> SMall fix
        p.setCheckpoint(p.getPosition());
    }
}
