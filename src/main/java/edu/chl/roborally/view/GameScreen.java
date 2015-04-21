package edu.chl.roborally.view;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.tiles.GameTile;

import javax.swing.*;
import java.awt.*;

/**
 * Created by fredrikkindstrom on 21/04/15.
 */
public class GameScreen extends JPanel {

    private GameTile[][] board;

    public GameScreen() {
        board = new GameTile[Constants.NUM_ROWS][Constants.NUM_COLS];
        setLayout(new GridLayout(Constants.NUM_ROWS,Constants.NUM_COLS));

    }
}
