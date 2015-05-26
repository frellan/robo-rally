package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;

/**
 * Created by henriknilson on 31/03/15.
 */
public class RotatePlayer implements GameAction {

    private Constants.Directions d;

    public RotatePlayer(Constants.Directions d) {
        this.d = d;
    }

    @Override
    public void doAction(Player p) {
        switch(d) {
            // Turn Right
            case EAST:
                switch (p.getDirection()) {
                    case NORTH:
                        p.setDirection(Constants.Directions.EAST);
                        break;
                    case EAST:
                        p.setDirection(Constants.Directions.SOUTH);
                        break;
                    case SOUTH:
                        p.setDirection(Constants.Directions.WEST);
                        break;
                    case WEST:
                        p.setDirection(Constants.Directions.NORTH);
                }
                break;

            // Turn Left
            case WEST:
                switch (p.getDirection()) {
                    case NORTH:
                        p.setDirection(Constants.Directions.WEST);
                        break;
                    case WEST:
                        p.setDirection(Constants.Directions.SOUTH);
                        break;
                    case SOUTH:
                        p.setDirection(Constants.Directions.EAST);
                        break;
                    case EAST:
                        p.setDirection(Constants.Directions.NORTH);
                        break;
                }
                break;
        }
    }
}
