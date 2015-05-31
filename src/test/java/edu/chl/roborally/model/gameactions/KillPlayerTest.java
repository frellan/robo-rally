package edu.chl.roborally.model.gameactions;

import edu.chl.roborally.model.cards.CardDeck;
import edu.chl.roborally.model.robot.Robot;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.Position;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class KillPlayerTest {

    private Player player;
    private GameAction action;
    private CardDeck deck;

    @Before
    public void setUp() throws Exception {
        player = new Player(0, new Robot("Test Robot", Color.ORANGE));
        player.setPosition(new Position(3,5));
        deck = new CardDeck();
        player.setProgrammedCard(0, deck.getCards(1).get(0));
        player.setProgrammedCard(1, deck.getCards(1).get(0));
        player.setProgrammedCard(2, deck.getCards(1).get(0));
        player.setProgrammedCard(3, deck.getCards(1).get(0));
        player.setProgrammedCard(4, deck.getCards(1).get(0));
    }
    @Test
    public void testKillPlayer() throws Exception {
        action = new KillPlayer();
        action.doAction(player);
        assertTrue(player.getLifeTokens() == 2);
        assertTrue(player.getStatus() == Constants.Status.DEAD);
        assertTrue(player.getPosition().getX() == 3 && player.getPosition().getY() == 5);
        assertTrue(player.getDamageTokens() == 0);
    }
}