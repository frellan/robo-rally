package edu.chl.roborally.model.cards;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.gameactions.RotatePlayer;

import javax.imageio.ImageIO;

/**
 * Created by fredrikkindstrom on 31/03/15.
 *
 * Represents a U-Turn card in the game that makes a player do a u turn and face the opposite direction.
 */
class UTurnCard extends RegisterCard{

    /**
     * Takes a parameter for how many priority points the card should have and sets
     * the appropriate action to the superclass, also sets the images for the card.
     * @param points The priority points for the card.
     */
    UTurnCard(int points) {
        super(points, "U-Turn");
        super.setAction(new RotatePlayer(Constants.Directions.LEFT));
        super.setAction(new RotatePlayer(Constants.Directions.LEFT));
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
