package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.Position;
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
        player = new Player(0, "MoveAndBackUpPlayer");
        player.setPosition(new Position(4,6));
        player.setDirection(Constants.Directions.NORTH);
        System.out.println(player.getRobot() + " starts at position " + player.getPosition());
    }

    @Test
    public void testMovePlayer() throws Exception {
        new MovePlayer(player);
        assertTrue(player.getPosition().getY() == 7 && player.getPosition().getX() == 4);
    }

    @Test
    public void testBackUpPlayer() throws Exception {
        new BackUpPlayer(player);
        assertTrue(player.getPosition().getY() == 5 && player.getPosition().getX() == 4);
    }
}