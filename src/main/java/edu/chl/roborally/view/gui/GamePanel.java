package edu.chl.roborally.view.gui;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.RoboRally;

import javax.imageio.ImageIO;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by axel on 2015-05-06.
 */
public class GamePanel extends JPanel {

    private BufferedImage imageBG;
    private BufferedImage componentsBG;
    private BufferedImage textBG;
    private BoardView boardView;
    private ControlView controlView;

    public GamePanel(RoboRally model){
        initImages();
        setOpaque(false);
        setLayout(null);
        boardView = new BoardView(model);
        controlView = new ControlView(model.getPlayers().get(0));
        add(boardView);
        boardView.setLocation(8, 23);
        add(controlView);
        controlView.setLocation(8, 543);
    }

    public void pickCards(Player player) {
        controlView.pickCards(player);
    }

    public void showCards() {
        controlView.showCards();
    }

    // Draw background
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageBG, 0, 0, getWidth(), getHeight(), this);
        g.drawImage(componentsBG, 0, 1, 1000, 730, this);
    }

    // Draw background
    @Override
    public void paintChildren(Graphics g) {
        super.paintChildren(g);
        g.drawImage(textBG, 0, 1, 1000, 730, this);
    }

    private void initImages() {
        try {
            imageBG = ImageIO.read(this.getClass().getClassLoader().getResource("roborally_start.jpg"));
            componentsBG = ImageIO.read(this.getClass().getClassLoader().getResource("game_background.png"));
            textBG = ImageIO.read(this.getClass().getClassLoader().getResource("game_background_text.png"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("Images could not be read");
        }
    }
}
