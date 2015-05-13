package edu.chl.roborally.view;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.cards.*;
import edu.chl.roborally.utilities.EventTram;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by axel on 2015-05-06.
 */
public class ControlView extends JPanel {

    private ChooseCardsView chooseCardsView;
    private CardView cardView;


    public ControlView(){
        setLayout(null);
        setSize(984, 170);

    }

    public void pickCards(Player player) {
        chooseCardsView = new ChooseCardsView(player.getDealtCards());
        removeAll();
        add(chooseCardsView);

        chooseCardsView.setLocation(4, 5);
        revalidate();
        repaint();
    }

    public void showCards() {
        cardView = new CardView(testCards());
        add(cardView);
        cardView.setLocation(4, 5);
    }

    private ArrayList<RegisterCard> testCards() {
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
        return cards;
    }
}
