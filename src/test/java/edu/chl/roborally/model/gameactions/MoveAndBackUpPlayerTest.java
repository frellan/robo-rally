package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.robot.Robot;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.Position;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by henriknilson on 27/04/15.
 */
public class MoveAndBackUpPlayerTest {

    private Player player;
    private GameAction action;
    private GameAction nextAction;

    @Before
    public void setUp() throws Exception {
        player = new Player(0, new Robot("Test Robot", Color.ORANGE));
        player.setPosition(new Position(4,6));
        player.setDirection(Constants.Directions.NORTH);
        System.out.println(player.getName() + " starts at position " + player.getPosition());
    }

    @Test
    public void testMovePlayer() throws Exception {
        action = new MovePlayer();
        action.doAction(player);
        assertTrue(player.getPosition().getY() == 5 && player.getPosition().getX() == 4);
    }

    @Test
    public void testBackUpPlayer() throws Exception {
        nextAction = new BackUpPlayer();
        nextAction.doAction(player);
        assertTrue(player.getPosition().getY() == 7 && player.getPosition().getX() == 4);
    }
}