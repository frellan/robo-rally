package edu.chl.roborally.model.cards;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.utilities.Position;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Pertta on 15-04-30.
 */
public class MoveThreeCardTest {

    private Player player;
    private MoveThreeCard card;

    @Before
    public void setUp() throws Exception {
        player = new Player(0, "cardMoveThreePlayer");
        player.setPosition(new Position(4,6));
        player.setDirection(Constants.Directions.NORTH);
        System.out.println(player.getName() + " starts at position " + player.getPosition());
    }

    @Test
    public void testDoAction() throws Exception {
        card = new MoveThreeCard(10,false);
        card.doAction(player);
        assertTrue(player.getPosition().getY() == 9 && player.getPosition().getX() == 4);

    }
}