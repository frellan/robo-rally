package edu.chl.roborally.model.cards;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.gameactions.RotatePlayer;

import javax.imageio.ImageIO;

/**
 * Created by fredrikkindstrom on 31/03/15.
 */
class UTurnCard extends RegisterCard{

    UTurnCard(int points) {
        super(points, "U-Turn");
        super.setAction(new RotatePlayer(Constants.Directions.EAST));
        super.setAction(new RotatePlayer(Constants.Directions.EAST));
        try {
            super.mainImage = ImageIO.read(this.getClass().getClassLoader().getResource("cards/u_turn.png"));
            super.pickImage = ImageIO.read(this.getClass().getClassLoader().getResource("cards/u_turn_pick.png"));
            super.pickImageRollover = ImageIO.read(this.getClass().getClassLoader().getResource("cards/u_turn_pick_rollover.png"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("Card mainImage could not be read");
        }
        cardMessage = "Made a U-Turn";
    }
}
