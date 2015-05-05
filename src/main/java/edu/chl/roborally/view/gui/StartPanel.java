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
    private JButton optionsButton;
    private JButton exitButton;
    private BufferedImage bi;

    public StartPanel(){

        URL imageUrl = this.getClass().getClassLoader().getResource("roborally_start.jpg");

        try {
            bi = ImageIO.read(imageUrl);
        }catch(java.io.IOException e){
            System.out.println("Image could not be read");
        }

        JPanel buttonPanel = new JPanel(new GridLayout(0,1,0,5));
        buttonPanel.setOpaque(false);

        newGameButton = new Button("start_btn.png", "start_btn_hover.png");

        newGameButton.addActionListener(this);

        optionsButton = new JButton("Options");
        optionsButton.addActionListener(this);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);

        buttonPanel.add(newGameButton);
        buttonPanel.add(optionsButton);
        buttonPanel.add(exitButton);

        add(buttonPanel);
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
        if(e.getSource().equals(exitButton)){
            System.exit(1);
        }
    }
}
