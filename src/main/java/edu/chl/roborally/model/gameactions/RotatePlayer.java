package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.Player;

/**
 * Created by henriknilson on 31/03/15.
 */
public class RotatePlayer implements GameAction {

    private Player p;
    private Constants.Directions d;

    public RotatePlayer(Player p, Constants.Directions d){
        this.p = p;
        this.d = d;
        action();
        System.out.println("Rotated " + p.getName());
        System.out.println("New direction " + p.getDirection().toString());
        System.out.println("");
    }

    @Override
    public void action() {
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
