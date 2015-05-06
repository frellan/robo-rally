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
public class GameView extends JPanel {

    private RoboRally model;
    private GameBoard board;
    private int width = Constants.TILE_SIZE*Constants.NUM_COLS;
    private int height = Constants.TILE_SIZE*Constants.NUM_ROWS;

    public GameView(RoboRally model) {
        this.model = model;
        board = model.getGameBoard();
        setSize(width,height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
        drawTiles(g);
    }

    private void drawGrid(Graphics g) {
        // Vertical Lines
        g.drawLine(0,0,0,height);
        g.drawLine(width,0,width,height);
        int x = Constants.TILE_SIZE;
        for (int i = 1; i <= Constants.NUM_COLS; i++) {
            g.drawLine(x,0,x,height);
            x += Constants.TILE_SIZE;
        }
        // Horizontal Lines
        g.drawLine(0,0,width,0);
        g.drawLine(0, height, width, height);
        int y = Constants.TILE_SIZE;
        for (int i = 1; i <= Constants.NUM_ROWS; i++) {
            g.drawLine(0,y,width,y);
            y += Constants.TILE_SIZE;
        }
    }

    private void drawTiles(Graphics g) {
        int x = 0;
        for (int i = 0; i < Constants.NUM_COLS; i++) {
            int y = 0;
            for(int j = 0; j < Constants.NUM_ROWS; j++) {
                board.getTile(i,j).paintComponent(g);
                y += Constants.TILE_SIZE;
            }
            x += Constants.TILE_SIZE;
        }
    }
}