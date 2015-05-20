package edu.chl.roborally.model.cards;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.robot.Robot;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.utilities.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pertta on 15-04-30.
 */
public class MoveOneCardTest {

    private Player player;
    private MoveOneCard card;

    @Before
    public void setUp() throws Exception {
        player = new Player(0, new Robot("Test Robot"));
        player.setPosition(new Position(4,6));
        player.setDirection(Constants.Directions.NORTH);
        System.out.println(player.getName() + " starts at position " + player.getPosition());
    }

    @Test
    public void testDoAction() throws Exception {
        card = new MoveOneCard(10,false);
        card.doAction(player);
        assertTrue(player.getPosition().getY() == 5 && player.getPosition().getX() == 4);
    }
}