package edu.chl.roborally;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.cards.*;
import edu.chl.roborally.view.gui.CardView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by axel on 2015-05-07.
 */
public class TestCardView {

    public TestCardView(){

        Player player1 = new Player(1,"Dave");
        RegisterCard card1 = new BackupCard(430, false);
        RegisterCard card2 = new MoveOneCard(270, false);
        RegisterCard card3 = new MoveTwoCard(670, false);
        RegisterCard card4 = new RotateLeftCard(200, false);
        RegisterCard card5 = new RotateRightCard(230, false);
        ArrayList<RegisterCard> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        player1.setDealtCards(cards);

        CardView testCardView = new CardView(cards);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1000, 700);
        frame.setLayout(new BorderLayout());
        frame.add(testCardView);
        frame.setVisible(true);
    }
}
