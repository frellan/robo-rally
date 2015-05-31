package edu.chl.roborally.model.cards;

import edu.chl.roborally.model.gameactions.MovePlayer;

import javax.imageio.ImageIO;

/**
 * Created by fredrikkindstrom on 31/03/15.
 */
class MoveTwoCard extends RegisterCard{

    MoveTwoCard(int points) {
        super(points, "Move Two");
        super.setAction(new MovePlayer());
        super.setAction(new MovePlayer());
        try {
            super.mainImage = ImageIO.read(this.getClass().getClassLoader().getResource("cards/move2.png"));
            super.pickImage = ImageIO.read(this.getClass().getClassLoader().getResource("cards/move2_pick.png"));
            super.pickImageRollover = ImageIO.read(this.getClass().getClassLoader().getResource("cards/move2_pick_rollover.png"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("Card mainImage could not be read");
        }
        cardMessage = "Moved Two Tiles";
    }
}
