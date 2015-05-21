package edu.chl.roborally.model.cards;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.MovePlayer;
import edu.chl.roborally.utilities.EventTram;

import javax.imageio.ImageIO;

/**
 * Created by fredrikkindstrom on 31/03/15.
 */
public class MoveTwoCard extends RegisterCard{

    public MoveTwoCard(int points, boolean isHidden) {
        super(points,isHidden, "Move Two");
        try {
            super.image = ImageIO.read(this.getClass().getClassLoader().getResource("tupp.jpg"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("Card image could not be read");
        }
    }

    public void doAction(Player p) {
        new MovePlayer(p);
        new MovePlayer(p);

        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, "CardPriority " + getPoints() + ": Moving ", null);
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, p.getName() , p.getColor());
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, " Two Tiles" + "\n", null);
    }
}
