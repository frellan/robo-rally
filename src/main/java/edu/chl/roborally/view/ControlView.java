package edu.chl.roborally.view;

import edu.chl.roborally.model.Player;

import javax.swing.*;
import java.awt.*;

/**
 * Created by axel on 2015-05-06.
 */
public class ControlView extends JPanel {

    private CardsView cardsView;

    public ControlView(){
        setLayout(null);
        setSize(984, 170);
        cardsView = new CardsView();
        add(cardsView).setLocation(0, 0);
    }

    public void newCardsToPick(Player player) {
        cardsView.newCardsToPick(player.getDealtCards());
    }
}
