package edu.chl.roborally.view;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.EventTram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by axel on 2015-05-06.
 */
public class ControlView extends JPanel implements ActionListener{

    private CardsView cardsView;
    private StatusView statusView;
    private Player player;

    public ControlView(Player player) {
        this.player = player;
        setLayout(null);
        setSize(984, 170);
        cardsView = new CardsView();
        statusView = new StatusView(player);
        add(cardsView).setLocation(0, 0);
        add(statusView).setLocation(668, 0);
        statusView.done.addActionListener(this);
    }

    public void newCardsToPick(Player player) {
        cardsView.newCardsToPick(player.getDealtCards());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == statusView.done){
            if (cardsView.programmedCardsIsValid()) {
                EventTram.getInstance().publish(EventTram.Event.PLAYER_CHOOSEN_CARDS, cardsView.getProgrammedCards(), null);
                statusView.nextTurn.setEnabled(true);
            } else {
                EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, "Please choose 5 cards", null);
            }
        }
    }
}
