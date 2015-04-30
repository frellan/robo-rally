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


        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon("C:\\Users\\Axel Aringskog\\Documents\\GitHub\\robo-rally\\src\\main\\resources\\roborally_start.jpg"));
        newGameButton = new JButton("Start Game!");

        newGameButton.addActionListener(this);

        add(imageLabel);
        add(newGameButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(newGameButton)){
            EventTram.getInstance().publish(EventTram.Event.INIT_SETUP, null);
        }
    }
}
