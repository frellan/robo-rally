package edu.chl.roborally.view;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.model.maps.GameBoard;

import javax.swing.*;
import java.awt.*;

/**
 * Created by fredrikkindstrom on 21/04/15.
 */
public class GameScreen extends JPanel {

    private final RoboRally model;

    private GameBoard board;

    public GameScreen(RoboRally model) {
        this.model = model;
        board = model.getGameBoard();
        setLayout(new GridLayout(Constants.NUM_ROWS,Constants.NUM_COLS));
    }

    protected void paintBoard() {
        for (int i = 0; i < board.getWidth(); i++) {
            for (int j = 0; j < board.getHeight(); j++) {
                System.out.println(board.getTile(i,j).toString());
            }
        }
    }
}
