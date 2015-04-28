package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by henriknilson on 27/04/15.
 */
public class MoveAndBackUpPlayerTest {

    private Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player(0, "name");
        player.setPosition(new Position(4,6));
        player.setDirection(Constants.Directions.NORTH);
    }

    @Test
    public void testMovePlayer() throws Exception {
        new MovePlayer(player);
        assertTrue(player.getPosition().getY() == 7);
        assertTrue(player.getPosition().getX() == 4);
    }

    @Test
    public void testBackUpPlayer() throws Exception {
        new BackUpPlayer(player);
        assertTrue(player.getPosition().getY() == 5);
        assertTrue(player.getPosition().getX() == 4);
    }
}