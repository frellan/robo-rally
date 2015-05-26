package edu.chl.roborally.model.cards;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.RotatePlayer;
import edu.chl.roborally.utilities.EventTram;

import javax.imageio.ImageIO;

/**
 * Created by fredrikkindstrom on 31/03/15.
 */
public class UTurnCard extends RegisterCard{

    public UTurnCard(int points, boolean isHidden) {
        super(points,isHidden, "U-Turn");
        super.setAction(new RotatePlayer(Constants.Directions.EAST));
        super.setAction(new RotatePlayer(Constants.Directions.EAST));
        try {
            super.mainImage = ImageIO.read(this.getClass().getClassLoader().getResource("cards/u_turn.png"));
            super.pickImage = ImageIO.read(this.getClass().getClassLoader().getResource("cards/u_turn_pick.png"));
            super.pickImageRollover = ImageIO.read(this.getClass().getClassLoader().getResource("cards/u_turn_pick_rollover.png"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("Card mainImage could not be read");
        }
    }
}
