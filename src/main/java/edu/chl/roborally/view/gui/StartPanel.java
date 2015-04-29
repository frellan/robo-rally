package edu.chl.roborally.view.gui;

import edu.chl.roborally.EventTram;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by axel on 2015-04-29.
 */
public class StartPanel extends JPanel implements ActionListener{

    private JButton newGameButton;

    public StartPanel(){

        JLabel welcomeLabel = new JLabel("Welcome to Robo-Rally");
        newGameButton = new JButton("Start Game!");

        newGameButton.addActionListener(this);

        add(welcomeLabel);
        add(newGameButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(newGameButton)){
            EventTram.getInstance().publish(EventTram.Event.INIT_SETUP, null);
        }
    }
}
