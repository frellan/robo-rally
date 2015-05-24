package edu.chl.roborally.model.cards;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.RotatePlayer;
import edu.chl.roborally.utilities.EventTram;

import javax.imageio.ImageIO;

/**
 * Created by fredrikkindstrom on 31/03/15.
 */
public class UTurnCard extends RegisterCard{

    public UTurnCard(int points, boolean isHidden) {
        super(points,isHidden, "U-Turn");
        try {
            super.mainImage = ImageIO.read(this.getClass().getClassLoader().getResource("cards/u_turn.png"));
            super.pickImage = ImageIO.read(this.getClass().getClassLoader().getResource("cards/u_turn_pick.png"));
            super.pickImageRollover = ImageIO.read(this.getClass().getClassLoader().getResource("cards/u_turn_pick_rollover.png"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("Card mainImage could not be read");
        }
    }

    public void doAction(Player p) {
        new RotatePlayer(p, Constants.Directions.EAST);
        new RotatePlayer(p, Constants.Directions.EAST);

        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, "Priority " + getPoints() + ": ", null);
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, p.getName(), p.getColor());
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, " made a U-Turn" + "\n", null);
    }
}
