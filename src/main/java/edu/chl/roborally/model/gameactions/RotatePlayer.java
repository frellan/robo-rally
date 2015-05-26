package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.EventTram;

/**
 * Created by henriknilson on 31/03/15.
 */
public class RotatePlayer implements GameAction {

    @Override
    public void action(Player p) {
        switch(p.getDirection()) {

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
