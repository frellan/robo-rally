package edu.chl.roborally.model.cards;

import edu.chl.roborally.model.gameactions.*;

import javax.imageio.ImageIO;

/**
 * Created by fredrikkindstrom on 31/03/15.
 *
 * Represents a backup card that makes a player move back one step in the game.
 */
class BackupCard extends RegisterCard{

    /**
     * Takes a parameter for how many priority points the card should have and sets
     * the appropriate action to the superclass, also sets the images for the card.
     * @param points The priority points for the card.
     */
    BackupCard(int points) {
        super(points, "Back Up");
        super.setAction(new BackUpPlayer());
        try {
            super.mainImage = ImageIO.read(this.getClass().getClassLoader().getResource("cards/backup.png"));
            super.pickImage = ImageIO.read(this.getClass().getClassLoader().getResource("cards/backup_pick.png"));
            super.pickImageRollover = ImageIO.read(this.getClass().getClassLoader().getResource("cards/backup_pick_rollover.png"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("Card mainImage could not be read");
        }
        cardMessage = "Backed Up";
    }
}
