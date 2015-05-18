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
    private ActiveRegisterView activeRegisterView;
    private StatusView statusView;

    public ControlView(){
        setLayout(null);
        setSize(984, 170);
    }

    public void showPickNewCards(Player player) {
        pickNewCardsView = new PickNewCardsView(player.getDealtCards());
        removeAll();
        add(pickNewCardsView);

        pickNewCardsView.setLocation(4, 5);
        revalidate();
        repaint();
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
