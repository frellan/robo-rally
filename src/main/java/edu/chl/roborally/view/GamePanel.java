package edu.chl.roborally.view;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.maps.GameBoard;
import edu.chl.roborally.utilities.LargeImageHolder;

import javax.imageio.ImageIO;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by axel on 2015-05-06.
 */
public class GamePanel extends JPanel {

    private BufferedImage componentsBG;
    private BufferedImage textBG;
    private BoardView boardView;
    private ConsoleView consoleView;
    private ControlView controlView;
    private Player player;

    public GamePanel(GameBoard board, ArrayList<Player> players, Player player){
        imageBG = LargeImageHolder.getInstance().getMainBackgroundImage();
        initImages();
        setOpaque(false);
        setLayout(null);
        this.player = player;
        boardView = new BoardView(board,players);
        controlView = new ControlView(player);
        consoleView = new ConsoleView();
        add(boardView);
        boardView.setLocation(8, 23);
        add(consoleView);
        consoleView.setLocation(678, 23);
        add(controlView);
        controlView.setLocation(8, 543);
    }

    /*
    Getters
     */
    public BoardView getBoardView(){
        return this.boardView;
    }
    public ControlView getControlView(){
        return this.controlView;
    }
    public Player getPlayer() {
        return player;
    }

    /*
    Painters
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(componentsBG, 0, 1, 1000, 730, this);
    }
    @Override
    public void paintChildren(Graphics g) {
        super.paintChildren(g);
        g.drawImage(textBG, 0, 1, 1000, 730, this);
    }

    private void initImages() {
        try {
            componentsBG = ImageIO.read(this.getClass().getClassLoader().getResource("game_background.png"));
            textBG = ImageIO.read(this.getClass().getClassLoader().getResource("game_background_text.png"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("Images could not be read");
        }
    }
}
