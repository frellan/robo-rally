package edu.chl.roborally.model.cards;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.RotatePlayer;
import edu.chl.roborally.utilities.EventTram;

import javax.imageio.ImageIO;

/**
 * Created by fredrikkindstrom on 31/03/15.
 */
public class RotateLeftCard extends RegisterCard{

    public RotateLeftCard(int points, boolean isHidden) {
        super(points,isHidden, "Rotate Left");
        try {
            super.mainImage = ImageIO.read(this.getClass().getClassLoader().getResource("cards/rotate_left.png"));
            super.pickImage = ImageIO.read(this.getClass().getClassLoader().getResource("cards/move1_pick.png"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("Card mainImage could not be read");
        }
    }

    public void doAction(Player p) {
        new RotatePlayer(p,Constants.Directions.WEST);
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, "CardPriority " + getPoints() + ": Rotating ", null);
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, p.getName() , p.getColor());
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, " One Left" + "\n", null);
    }
}
