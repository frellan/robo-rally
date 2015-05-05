package edu.chl.roborally.view.gui;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.model.maps.GameBoard;
import edu.chl.roborally.model.tiles.BlankTile;
import edu.chl.roborally.model.tiles.GameTile;

import javax.swing.*;
import java.awt.*;

/**
 * Created by fredrikkindstrom on 21/04/15.
 */
public class GameView extends JComponent {

    private final RoboRally model;

    private GameBoard board;

    public GameView(RoboRally model) {
        this.model = model;
        board = model.getGameBoard();
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int width = getWidth();
        int height = getHeight();

        int cellWidth = width / Constants.NUM_COLS;
        int cellHeight = height / Constants.NUM_ROWS;

        int xOffset = (width - (Constants.NUM_COLS * cellWidth)) / 2;
        int yOffset = (height - (Constants.NUM_ROWS * cellHeight)) / 2;

        for (int x = 0; x < board.getHeight(); x++) {
            for (int y = 0; y < board.getWidth(); y++) {
                if (board.getTile(x,y) == null) {
                    Rectangle cell = new Rectangle(
                        xOffset + (Constants.NUM_COLS * cellWidth),
                        yOffset + (Constants.NUM_ROWS * cellHeight),
                        cellWidth,
                        cellHeight);
                    g2d.setColor(Color.BLUE);
                    g2d.fill(cell);
                    g2d.setColor(Color.GRAY);
                    g2d.draw(cell);
                    g2d.dispose();
                }
            }
        }
    }
}