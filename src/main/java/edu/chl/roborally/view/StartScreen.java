package edu.chl.roborally.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by fredrikkindstrom on 22/04/15.
 */
public class StartScreen extends JPanel {

    // Buttons

    private JButton newGameButton;

    public StartScreen() {
        setLayout(new FlowLayout());
        newGameButton = new JButton("New Game");
        add(newGameButton);
        setVisible(true);
    }
}
