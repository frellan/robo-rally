package edu.chl.roborally.view.gui;

import edu.chl.roborally.EventTram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

/**
 * Created by axel on 2015-04-29.
 */
public class StartPanel extends JPanel implements ActionListener{

    private JButton newGameButton;

    public StartPanel(){

        URL url = this.getClass().getClassLoader().getResource("roborally_start.jpg");

        try {
            JLabel imageLabel = new JLabel(new ImageIcon(url));
            add(imageLabel);
        }catch(NullPointerException e){
            System.out.println("Image Not Found");
        }

        newGameButton = new JButton("Start Game!");

        newGameButton.addActionListener(this);


        add(newGameButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(newGameButton)){
            EventTram.getInstance().publish(EventTram.Event.INIT_GAME, null);
        }
    }
}
