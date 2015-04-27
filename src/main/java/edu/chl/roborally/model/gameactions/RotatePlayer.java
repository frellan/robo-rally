package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.Player;

/**
 * Created by henriknilson on 31/03/15.
 */
public class RotatePlayer extends GameAction {

    private Constants.Directions d;

    public RotatePlayer(Player p, Constants.Directions d){
        super(p);
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
