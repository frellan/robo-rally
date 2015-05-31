package edu.chl.roborally.model.cards;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.GameAction;
import edu.chl.roborally.model.robot.Robot;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.utilities.Position;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by Pertta on 15-05-31.
 */
public class UTurnCardTest {

    private Player player;
    private UTurnCard card;

    @Before
    public void setUp() throws Exception {
        player = new Player(0, new Robot("Test Robot", Color.ORANGE));
        player.setPosition(new Position(4,6));
        player.setDirection(Constants.Directions.SOUTH);
        System.out.println(player.getName() + " starts at position " + player.getDirection());
    }

    @Test
    public void testDoAction() throws Exception {
        //UTurn player from South to North
        System.out.println("player has direction " + player.getDirection() + " before card");
        card = new UTurnCard(10);
        for (GameAction action : card.getActions()) {
            action.doAction(player);
        }
        System.out.println("player has direction " + player.getDirection() + " after card");
        assertTrue(player.getDirection() == Constants.Directions.NORTH);
    }
}