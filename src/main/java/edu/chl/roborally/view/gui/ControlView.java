package edu.chl.roborally.view.gui;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.cards.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by axel on 2015-05-06.
 */
public class ControlView extends JPanel {

    private Player player;
    private CardsView cardsView;

    public ControlView(Player player){
        this.player = player;
        setLayout(null);
        setSize(984, 170);
        cardsView = new CardsView(testCards());
        add(cardsView);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
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
