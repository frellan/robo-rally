package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.robot.Robot;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class RotatePlayerTest {

    @Test
    public void testAction() throws Exception {
        Player p = new Player(0, new Robot("Test Robot"));

        p.setDirection(Constants.Directions.EAST);

        new RotatePlayer(p, Constants.Directions.WEST);

        assertTrue(p.getDirection() == Constants.Directions.NORTH);
    }
}