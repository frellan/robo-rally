package edu.chl.roborally.model.cards;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Created by henriknilson on 21/05/15.
 */
public class RegisterCardCompareTest {

    private RegisterCard card1;
    private RegisterCard card2;
    private ArrayList<RegisterCard> soretedCards= new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        RegisterCard card1 = new MoveOneCard(170);
        RegisterCard card2 = new MoveOneCard(150);
        RegisterCard card3 = new MoveOneCard(350);
        RegisterCard card4 = new MoveOneCard(20);
        RegisterCard card5 = new MoveOneCard(890);

        soretedCards.add(card1);
        soretedCards.add(card2);
        soretedCards.add(card3);
        soretedCards.add(card4);
        soretedCards.add(card5);
    }

    @Test
    public void testCompare() throws Exception {
        Collections.sort(soretedCards, new RegisterCardCompare());

        for (RegisterCard card : soretedCards) {
            System.out.println("Card " + soretedCards.indexOf(card) + " Points: " + card.getPoints());
        }

        assertTrue(soretedCards.get(0).getPoints() > soretedCards.get(1).getPoints());
        assertTrue(soretedCards.get(0).getPoints() > soretedCards.get(2).getPoints());
        assertTrue(soretedCards.get(1).getPoints() > soretedCards.get(4).getPoints());
        assertTrue(soretedCards.get(2).getPoints() > soretedCards.get(3).getPoints());
        assertTrue(soretedCards.get(3).getPoints() > soretedCards.get(4).getPoints());

    }
}