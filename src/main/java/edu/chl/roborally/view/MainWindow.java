package edu.chl.roborally.view;

import edu.chl.roborally.controller.Controller;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.model.cards.RegisterCard;

import javax.swing.*;
import java.awt.*;

/**
 * Created by henriknilson on 26/03/15.
 */
public class MainWindow extends JFrame{

    private final Controller controller;

    public MainWindow(Controller c) {
        controller = c;
        setTitle("RoboRally");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLayout(new BorderLayout());
        add(new StartScreen(controller), BorderLayout.CENTER);
        setVisible(true);
    }

    public void switchToGameScreen(RoboRally model) {
        removeAll();
        add(new GameScreen(model),BorderLayout.CENTER);
        revalidate();
    }

}
