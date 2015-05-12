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

    private ChooseCardsView chooseCardsView;
    private CardView cardView;

    public ControlView(){
        setLayout(null);
        setSize(984, 170);
    }

    public void pickCards(Player player) {
        chooseCardsView = new ChooseCardsView(player.getDealtCards());
        add(chooseCardsView);
        chooseCardsView.setLocation(4, 5);
        revalidate();
        repaint();
    }
}
