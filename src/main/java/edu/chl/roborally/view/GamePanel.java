package edu.chl.roborally.view;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.maps.GameBoard;
import edu.chl.roborally.utilities.GlobalImageHolder;

import javax.imageio.ImageIO;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by axel on 2015-05-06.
 */
public class GamePanel extends JPanel {

    private BufferedImage imageBG;
    private BufferedImage textBG;
    private BoardView boardView;
    private ConsoleView consoleView;
    private ControlView controlView;
    private Player player;

    /**
     * Creates the game panel which is unique for every player and contains the board,
     * the controls, the console and the status for a given player.
     * @param board The board to be drawn inside the panel. Is unique for the game and the same for all players.
     * @param players The list of players that are in the game. This is used to be able to draw them.
     * @param player The unique player to create components for.
     */
    public GamePanel(GameBoard board, ArrayList<Player> players, Player player){
        imageBG = GlobalImageHolder.getInstance().getMainBackgroundImage();
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

    /**
     * Return the board within the game panel.
     * @return The board view within the game panel.
     */
    public BoardView getBoardView(){
        return this.boardView;
    }

    /**
     * Return the control view within the game panel.
     * @return The control view within the game panel.
     */
    public ControlView getControlView(){
        return this.controlView;
    }

    /**
     * Return the player associated with the game panel.
     * @return The player associated with the game panel.
     */
    public Player getPlayer() {
        return player;
    }

    /*
    Help methods and classes
     */

    /**
     * Sets the image variables used in the game panel.
     */
    private void initImages() {
        imageBG = GlobalImageHolder.getInstance().getMainBackgroundImage();
        try {
            textBG = ImageIO.read(this.getClass().getClassLoader().getResource("game_background_text.png"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("Images could not be read");
        }
    }

    /**
     * Paints the black outlines of the components inside the game panel.
     * @param g The graphics object to use when painting.
     */
    private void paintBorders(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(4, 19, 664, 500);
        g.fillRect(674, 19, 322, 500);
        g.fillRect(4, 539, 992, 179);
    }

    /*
    Painters
     */

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageBG, 0, 0, 1001, 730, this);
        paintBorders(g);
    }
    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g);
        g.drawImage(textBG, 0, 1, 1000, 730, this);
    }
}
