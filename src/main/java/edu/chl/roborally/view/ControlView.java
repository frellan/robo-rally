package edu.chl.roborally.view;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.cards.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by axel on 2015-05-06.
 */
public class ControlView extends JPanel {

    private PickNewCardsView pickNewCardsView;
    private CardView cardView;
    private StatusView statusView;

    public ControlView(){
        setLayout(null);
        setSize(984, 170);
    }

    public void pickCards(Player player) {
        pickNewCardsView = new PickNewCardsView(player.getDealtCards());
        removeAll();
        add(pickNewCardsView);

        pickNewCardsView.setLocation(4, 5);
        revalidate();
        repaint();
    }

    public void showCardsAndStatus(Player player) {
        cardView = new CardView(testCards());
        statusView = new StatusView(player);
        add(cardView);
        add(statusView);
        cardView.setLocation(4, 5);
        statusView.setLocation(662, 5);
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

    public StatusView getStatusView() {
        return this.statusView;
    }
}
