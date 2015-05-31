package edu.chl.roborally.model.cards;

import edu.chl.roborally.model.gameactions.MovePlayer;

import javax.imageio.ImageIO;

/**
 * Created by fredrikkindstrom on 31/03/15.
 *
 * Represents a move one card that makes a player move forward one step in the game.
 */
class MoveOneCard extends RegisterCard{

    /**
     * Takes a parameter for how many priority points the card should have and sets
     * the appropriate action to the superclass, also sets the images for the card.
     * @param points The priority points for the card.
     */
    MoveOneCard(int points) {
        super(points, "Move One");
        super.setAction(new MovePlayer());
        try {
            super.mainImage = ImageIO.read(this.getClass().getClassLoader().getResource("cards/move1.png"));
            super.pickImage = ImageIO.read(this.getClass().getClassLoader().getResource("cards/move1_pick.png"));
            super.pickImageRollover = ImageIO.read(this.getClass().getClassLoader().getResource("cards/move1_pick_rollover.png"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("Move one card images could not be read");
        }
        cardMessage = "Moved One Tile";
    }
}
