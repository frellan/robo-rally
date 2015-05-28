package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.EventTram;

/**
 * Created by Pertta on 15-05-13.
 */
public class CheckpointPlayer implements GameAction {

    private final int id;

    public CheckpointPlayer(int id) {
        this.id = id;
    }

    @Override
    public void doAction(Player player) {
        if (id == 0) {
            System.out.println("Standing on START-tile");
        }
        else if (player.getCheckpointID() == (id - 1)) {
            if (id < 5) {
                player.setCheckpointID(id);
                player.setCheckpoint(player.getPosition());
                System.out.println("It worked, new checkpoint set");
            }
            else if (id == 5) {
                EventTram.getInstance().publish(EventTram.Event.VICTORY, player, null);
            }
        } else {
            System.out.println("Wrong checkpoint, go to " + (id - 1) + " first");
        }
    }
}
