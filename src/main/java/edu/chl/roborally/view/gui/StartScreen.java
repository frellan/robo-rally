package edu.chl.roborally.view.gui;

import edu.chl.roborally.EventTram;
import edu.chl.roborally.controller.AppController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by fredrikkindstrom on 22/04/15.
 */
public class StartScreen extends JPanel implements ActionListener{

    // Buttons

    private JButton newGameButton;
    private AppController appController;

    public StartScreen(AppController appController) {
        this.appController = appController;
        setLayout(new FlowLayout());
        newGameButton = new JButton("New Game");
        add(newGameButton);

        newGameButton.addActionListener(this);

        setVisible(true);
    }





    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == null) {
            System.out.println("null");
        }
        if (e.getSource().equals(newGameButton)){
            appController.initGameController();
            EventTram.getInstance().publish(EventTram.Event.START_SETUP, null);
        }
    }
}
