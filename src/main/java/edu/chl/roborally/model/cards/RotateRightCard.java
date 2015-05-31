package edu.chl.roborally.model.cards;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.gameactions.RotatePlayer;

import javax.imageio.ImageIO;

/**
 * Created by fredrikkindstrom on 31/03/15.
 */
class RotateRightCard extends RegisterCard{

    RotateRightCard(int points) {
        super(points, "Rotate Right");
        super.setAction(new RotatePlayer(Constants.Directions.EAST));
        try {
            super.mainImage = ImageIO.read(this.getClass().getClassLoader().getResource("cards/rotate_right.png"));
            super.pickImage = ImageIO.read(this.getClass().getClassLoader().getResource("cards/rotate_right_pick.png"));
            super.pickImageRollover = ImageIO.read(this.getClass().getClassLoader().getResource("cards/rotate_right_pick_rollover.png"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("Card mainImage could not be read");
        }
        cardMessage = "Rotated Right";
    }
}
