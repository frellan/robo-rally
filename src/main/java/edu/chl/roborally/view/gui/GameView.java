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
        setLayout(new GridLayout(Constants.NUM_ROWS,Constants.NUM_COLS));
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.setColor(this.getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());

        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++) {
                board.getTile(i, j).draw();
            }
        }
    }
}
