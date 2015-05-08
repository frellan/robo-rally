package edu.chl.roborally;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.model.maps.*;
import edu.chl.roborally.view.gui.GamePanel;
import edu.chl.roborally.view.gui.GameView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by fredrikkindstrom on 05/05/15.
 */
public class TestGameView {

    public TestGameView() {
        Player player1 = new Player(1,"Dave");
        Player player2 = new Player(2,"Bob");
        GameBoard map = new VaultMap();
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        RoboRally model = new RoboRally(players,map);
        JFrame frame = new JFrame();
        GamePanel main = new GamePanel(model);
        //GameView test = new GameView(model);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1000, 760);
        frame.setLayout(new BorderLayout());
        frame.add(main);
        //frame.add(test);
        frame.setVisible(true);
    }
}
