package edu.chl.roborally.model.cards;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.RotatePlayer;

import javax.imageio.ImageIO;

/**
 * Created by fredrikkindstrom on 31/03/15.
 */
public class RotateLeftCard extends RegisterCard{

    public RotateLeftCard(int points, boolean isHidden) {
        super(points,isHidden, "Rotate Left");
        try {
            super.image = ImageIO.read(this.getClass().getClassLoader().getResource("tupp.jpg"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("Card image could not be read");
        }
    }

    public void doAction(Player p) {
        new RotatePlayer(p,Constants.Directions.EAST);
    }
}
