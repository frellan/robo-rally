package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KillPlayerTest {

    private Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player(0, "KillPlayer");
        player.setPosition(new Position(3,5));
    }
    @Test
    public void testKillPlayer() throws Exception {
        new KillPlayer(player);
        assertTrue(player.getLifeTokens() == 2);
        assertTrue(player.getStatus() == Constants.Status.DEAD);
        assertTrue(player.getPosition().getX() == 3 && player.getPosition().getY() == 5);
        assertTrue(player.getDamageTokens() == 0);
    }
}