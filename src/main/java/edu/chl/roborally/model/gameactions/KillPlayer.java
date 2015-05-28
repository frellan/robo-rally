package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.EventTram;

import java.awt.*;

/**
 * Created by henriknilson on 31/03/15.
 */
public class KillPlayer implements GameAction{

    @Override
    public void doAction(Player p) {
        p.kill();
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, p.getName(), p.getColor());
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, " HAS DIED" + "\n", Color.RED);
    }
}
