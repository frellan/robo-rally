package edu.chl.roborally.model.cards;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.gameactions.RotatePlayer;

import javax.imageio.ImageIO;

/**
 * Created by fredrikkindstrom on 31/03/15.
 *
 * Represents a rotate left card that makes a player rotate one step to the left in the game.
 */
class RotateLeftCard extends RegisterCard{

    /**
     * Takes a parameter for how many priority points the card should have and sets
     * the appropriate action to the superclass, also sets the images for the card.
     * @param points The priority points for the card.
     */
    RotateLeftCard(int points) {
        super(points, "Rotate Left");
        super.setAction(new RotatePlayer(Constants.Directions.WEST));
        try {
            super.mainImage = ImageIO.read(this.getClass().getClassLoader().getResource("cards/rotate_left.png"));
            super.pickImage = ImageIO.read(this.getClass().getClassLoader().getResource("cards/rotate_left_pick.png"));
            super.pickImageRollover = ImageIO.read(this.getClass().getClassLoader().getResource("cards/rotate_left_pick_rollover.png"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("Card mainImage could not be read");
        }
        cardMessage = "Rotated Left";
    }
}
