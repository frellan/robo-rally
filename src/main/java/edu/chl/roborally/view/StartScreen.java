package edu.chl.roborally.view;

import edu.chl.roborally.controller.Controller;
import edu.chl.roborally.model.RoboRally;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by fredrikkindstrom on 22/04/15.
 */
public class StartScreen extends JPanel implements ActionListener{

    private Controller controller;


    // Buttons

    private JButton newGameButton;

    public StartScreen(Controller controller) {
        this.controller = controller;

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
            controller.newGame();
        }
    }
}
