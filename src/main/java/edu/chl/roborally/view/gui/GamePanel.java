package edu.chl.roborally.view.gui;

import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.model.cards.*;

import javax.imageio.ImageIO;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

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
        setOpaque(false);
        setLayout(null);
        setSize(1000, 750);
        gameView = new GameView(model);
        cardView = new ChosenCardsView(testCards());
        add(gameView);
        gameView.setLocation(6, 24);
        add(cardView);
        cardView.setLocation(6, 552);
    }

    // Draw background
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }

    // Draw background
    @Override
    public void paintChildren(Graphics g) {
        super.paintChildren(g);
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

    private ArrayList<RegisterCard> testCards() {
        RegisterCard card1 = new BackupCard(430, false);
        RegisterCard card2 = new MoveOneCard(270, false);
        RegisterCard card3 = new MoveTwoCard(670, false);
        RegisterCard card4 = new RotateLeftCard(200, false);
        RegisterCard card5 = new RotateRightCard(230, false);
        ArrayList<RegisterCard> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);
        cards.add(card5);
        return cards;
    }
}
