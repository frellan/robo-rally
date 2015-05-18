package edu.chl.roborally.view;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.IEventHandler;
import edu.chl.roborally.utilities.Position;
import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.model.maps.GameBoard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by fredrikkindstrom on 21/04/15.
 */
public class BoardView extends JPanel {
    
    private GameBoard board;
    private ArrayList<Player> players;
    private int tileSize = Constants.TILE_SIZE;
    private int columns = Constants.NUM_COLS;
    private int rows = Constants.NUM_ROWS;
    private int width = (tileSize * columns) + columns;
    private int height = (tileSize * rows) + rows;

    public BoardView(RoboRally model) {
        board = model.getGameBoard();
        players = model.getPlayers();
        setSize(width, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
        drawTiles(g);
        drawPlayers(g);
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
        g.drawLine(0, 0, width, 0);
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

    private void drawPlayers(Graphics g) {
        for (Player player : players) {
            Position pos = player.getPosition();
            if(player.isAlive()){
                player.draw(g, (pos.getX() * tileSize) + pos.getX() + 1, (pos.getY() * tileSize) + pos.getY() + 1);
            }
        }
    }
}