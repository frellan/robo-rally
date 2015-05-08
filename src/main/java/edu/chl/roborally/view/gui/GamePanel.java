package edu.chl.roborally.view.gui;


import edu.chl.roborally.model.RoboRally;

import javax.imageio.ImageIO;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


/**
 * Created by axel on 2015-05-06.
 */
public class GamePanel extends JPanel {

    private BufferedImage bg;
    private BufferedImage bgText;
    private JPanel gameView;
    private JPanel cardView;

    public GamePanel(RoboRally model){
        initImages();
        setBackground(Color.WHITE);
        setLayout(null);
        setSize(1000, 720);
        gameView = new GameView(model);
        cardView = new ChosenCardsView(model.getPlayers().get(0).getDealtCards());
        add(gameView);
        gameView.setLocation(6,23);
    }

    // Draw background
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
        g.drawImage(bgText, 0, 0, getWidth(), getHeight(), this);

    }

    private void initImages() {
        try {
            bg = ImageIO.read(this.getClass().getClassLoader().getResource("game_background.png"));
            bgText = ImageIO.read(this.getClass().getClassLoader().getResource("game_background_text.png"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("Images could not be read");
        }
    }
}
