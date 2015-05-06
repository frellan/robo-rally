package edu.chl.roborally.view.gui;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.model.maps.GameBoard;

import javax.swing.*;
import java.awt.*;

/**
 * Created by fredrikkindstrom on 21/04/15.
 */
public class GameView extends JPanel {


    private GameBoard board;
    private int tileSize = Constants.TILE_SIZE;
    private int columns = Constants.NUM_COLS;
    private int rows = Constants.NUM_ROWS;
    private int width = (tileSize * columns) + columns;
    private int height = (tileSize * rows) + rows;

    public GameView(RoboRally model) {
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
        int x = tileSize;
        for (int i = 1; i <= columns; i++) {
            g.drawLine(x+i,0,x+i,height);
            x += tileSize;
        }
        // Horizontal Lines
        g.drawLine(0,0,width,0);
        g.drawLine(0, height, width, height);
        int y = tileSize;
        for (int i = 1; i <= rows; i++) {
            g.drawLine(0,y+i,width,y+i);
            y += tileSize;
        }
    }

    private void drawTiles(Graphics g) {
        for (int i = 0; i < columns; i++) {
            for(int j = 0; j < rows; j++) {
                board.getTile(i,j).draw(g, (i * tileSize) + i + 1, (j * tileSize) + j + 1);
            }
        }
    }
}