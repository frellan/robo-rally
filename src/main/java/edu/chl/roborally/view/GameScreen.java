package edu.chl.roborally.view;

import edu.chl.roborally.model.Constants;
import edu.chl.roborally.model.maps.GameBoard;

import javax.swing.*;
import java.awt.*;

/**
 * Created by fredrikkindstrom on 21/04/15.
 */
public class GameScreen extends JPanel {

    public GameScreen() {
        setLayout(new GridLayout(Constants.NUM_ROWS,Constants.NUM_COLS));

    }
}
