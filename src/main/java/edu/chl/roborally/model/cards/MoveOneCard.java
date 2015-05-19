package edu.chl.roborally.model.cards;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.MovePlayer;

import javax.imageio.ImageIO;

/**
 * Created by fredrikkindstrom on 31/03/15.
 */
public class MoveOneCard extends RegisterCard{

    public MoveOneCard(int points, boolean isHidden) {
        super(points,isHidden, "Move One");
        try {
            super.image = ImageIO.read(this.getClass().getClassLoader().getResource("tupp.jpg"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("Card image could not be read");
        }
    }

    public void doAction(Player p) {
        new MovePlayer(p);
    }
}
