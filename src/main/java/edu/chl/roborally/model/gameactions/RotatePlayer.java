package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.EventTram;

/**
 * Created by henriknilson on 31/03/15.
 */
public class RotatePlayer extends GameAction {

    private Constants.Directions d;

    public RotatePlayer(Player p, Constants.Directions d){
        super(p);
        this.d = d;
        action();
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, "Rotated " + p.getName() + "\n" +
                "New direction " + p.getDirection().toString() + "\n", null);
    }

    @Override
    public void action() {
        switch(d) {

            // Turn Right
            case EAST:
                switch (super.player.getDirection()) {
                    case NORTH:
                        super.player.setDirection(Constants.Directions.EAST);
                        break;
                    case EAST:
                        super.player.setDirection(Constants.Directions.SOUTH);
                        break;
                    case SOUTH:
                        super.player.setDirection(Constants.Directions.WEST);
                        break;
                    case WEST:
                        super.player.setDirection(Constants.Directions.NORTH);
                }
                break;

            // Turn Left
            case WEST:
                switch (super.player.getDirection()) {
                    case NORTH:
                        super.player.setDirection(Constants.Directions.WEST);
                        break;
                    case WEST:
                        super.player.setDirection(Constants.Directions.SOUTH);
                        break;
                    case SOUTH:
                        super.player.setDirection(Constants.Directions.EAST);
                        break;
                    case EAST:
                        super.player.setDirection(Constants.Directions.NORTH);
                        break;
                }
                break;
        }
    }
}
