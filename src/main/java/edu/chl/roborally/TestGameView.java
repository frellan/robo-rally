package edu.chl.roborally;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.model.maps.*;
import edu.chl.roborally.view.gui.GameView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by fredrikkindstrom on 05/05/15.
 */
public class TestGameView {

    public TestGameView() {
        Player player1 = new Player(1,"Dave");
        Player player2 = new Player(2,"Bob");
        GameBoard map = new VaultMap();
        RoboRally model = new RoboRally();
        model.setPlayer(player1);
        model.setPlayer(player2);
        model.setMap(map);
        model.setupGame();
        JFrame frame = new JFrame();
        GameView test = new GameView(model);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1000, 720);
        frame.setLayout(new BorderLayout());
        frame.add(test);
        frame.setVisible(true);
    }
}
