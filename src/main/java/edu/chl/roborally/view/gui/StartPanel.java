package edu.chl.roborally.view.gui;

import edu.chl.roborally.EventTram;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

/**
 * Created by axel on 2015-04-29.
 */
public class StartPanel extends JPanel implements ActionListener{

    private JButton newGameButton;
    private BufferedImage bi;

    public StartPanel(){

        URL url = this.getClass().getClassLoader().getResource("roborally_start.jpg");

        try {
            bi = ImageIO.read(url);
        }catch(java.io.IOException e){
            System.out.println("Image could not be read");
        }

        newGameButton = new JButton("Start Game!");

        newGameButton.addActionListener(this);


        add(newGameButton);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bi, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(newGameButton)){
            EventTram.getInstance().publish(EventTram.Event.INIT_GAME, null);
        }
    }
}
