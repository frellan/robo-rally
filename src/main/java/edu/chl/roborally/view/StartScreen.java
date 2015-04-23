package edu.chl.roborally.view;

import edu.chl.roborally.controller.AppController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by fredrikkindstrom on 22/04/15.
 */
public class StartScreen extends JPanel implements ActionListener{

    private AppController appController;


    // Buttons

    private JButton newGameButton;

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
            appController.newGame();
        }
    }
}
