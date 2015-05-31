package edu.chl.roborally.model.cards;

import edu.chl.roborally.model.gameactions.MovePlayer;

import javax.imageio.ImageIO;

/**
 * Created by fredrikkindstrom on 31/03/15.
 *
 * Represents a move three card that makes a player move forward three steps in the game, one step at a time.
 */
class MoveThreeCard extends RegisterCard{

    /**
     * Takes a parameter for how many priority points the card should have and sets
     * the appropriate action to the superclass, also sets the images for the card.
     * @param points The priority points for the card.
     */
    MoveThreeCard(int points) {
        super(points, "Move Three");
        super.setAction(new MovePlayer());
        super.setAction(new MovePlayer());
        super.setAction(new MovePlayer());
        try {
            super.mainImage = ImageIO.read(this.getClass().getClassLoader().getResource("cards/move3.png"));
            super.pickImage = ImageIO.read(this.getClass().getClassLoader().getResource("cards/move3_pick.png"));
            super.pickImageRollover = ImageIO.read(this.getClass().getClassLoader().getResource("cards/move3_pick_rollover.png"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("Card mainImage could not be read");
        }
        cardMessage = "Moved Three Tiles";
    }
}
