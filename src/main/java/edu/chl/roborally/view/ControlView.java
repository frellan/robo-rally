package edu.chl.roborally.view;

import edu.chl.roborally.model.Player;

import javax.swing.*;
import java.awt.*;

/**
 * Created by axel on 2015-05-06.
 */
public class ControlView extends JPanel {

    private CardLayout cardLayout = new CardLayout();
    private PickNewCardsView pickNewCardsView;
    private JPanel pickNewCardsViewHolder = new JPanel(new BorderLayout());
    private ActiveRegisterView activeRegisterView;
    private JPanel activeRegisterAndStatusViewsHolder = new JPanel();
    private StatusView statusView;

    public ControlView(){
        setLayout(cardLayout);
        setSize(984, 170);
        pickNewCardsView = new PickNewCardsView();
        pickNewCardsViewHolder.setSize(984, 170);
        pickNewCardsViewHolder.add(pickNewCardsView, BorderLayout.CENTER);
        add(pickNewCardsViewHolder,"PickNewCards");
    }

    public void showPickNewCards(Player player) {
        pickNewCardsView.setCards(player.getDealtCards());
        cardLayout.show(this,"PickNewCards");
    }

    public void showActiveRegisterAndStatus(Player player) {
        activeRegisterView = new ActiveRegisterView(player.getProgrammedCards());
        statusView = new StatusView(player);
        add(activeRegisterView);
        add(statusView);
        activeRegisterView.setLocation(4, 5);
        statusView.setLocation(662, 5);
    }
}
