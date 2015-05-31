package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.EventTram;

/**
 * Created by Pertta on 15-05-13.
 */
public class CheckpointPlayer extends GameAction {

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
            if (id < 3) {
                player.setCheckpointID(id);
                player.setCheckpoint(player.getPosition());
                System.out.println("It worked, new checkpoint set");
            }
            else if (id == 3) {
                player.setCheckpointID(id);
                EventTram.getInstance().publish(EventTram.Event.VICTORY, player, null);
            }
        }
        else if (player.getCheckpointID() > id) {
            System.out.println("You've already been on this checkpoint");
        } else {
            System.out.println("Wrong checkpoint, go to " + (player.getCheckpointID() + 1) + " first");
        }
    }
}
