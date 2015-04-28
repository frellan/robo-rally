package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class RotatePlayerTest {

    @Test
    public void testAction() throws Exception {
        Player p = new Player(0, "Name");

        p.setDirection(Constants.Directions.EAST);

        new RotatePlayer(p, Constants.Directions.WEST);

        assertTrue(p.getDirection() == Constants.Directions.NORTH);
    }
}