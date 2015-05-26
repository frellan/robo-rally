package edu.chl.roborally.model.cards;

import edu.chl.roborally.model.gameactions.MovePlayer;

import javax.imageio.ImageIO;

/**
 * Created by fredrikkindstrom on 31/03/15.
 */
public class MoveOneCard extends RegisterCard{

    public MoveOneCard(int points) {
        super(points, "Move One");
        super.setAction(new MovePlayer());
        try {
            super.mainImage = ImageIO.read(this.getClass().getClassLoader().getResource("cards/move1.png"));
            super.pickImage = ImageIO.read(this.getClass().getClassLoader().getResource("cards/move1_pick.png"));
            super.pickImageRollover = ImageIO.read(this.getClass().getClassLoader().getResource("cards/move1_pick_rollover.png"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("Move one card images could not be read");
        }
    }
}
