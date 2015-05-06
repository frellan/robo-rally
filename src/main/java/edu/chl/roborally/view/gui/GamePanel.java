package edu.chl.roborally.view.gui;

import edu.chl.roborally.model.RoboRally;

import javax.swing.*;
import java.awt.*;

/**
 * Created by axel on 2015-05-06.
 */
public class GamePanel extends JPanel {

    private JPanel gameView;
    private JPanel cardView;

    public GamePanel(RoboRally model){
        gameView = new GameView(model);
        cardView = new CardView(model);

        setLayout(new FlowLayout());
        setSize(1000,700);
        add(gameView);
        add(cardView);
    }
}
