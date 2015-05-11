package edu.chl.roborally;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.model.maps.*;
import edu.chl.roborally.view.gui.GamePanel;

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
        GameBoard map = new IslandKingMap();
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        RoboRally model = new RoboRally(players,map);
        JFrame frame = new JFrame();
        GamePanel main = new GamePanel(model);
        //BoardView test = new BoardView(model);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        if (Main.isWindows()) {
            frame.setSize(1005, 750);
        } else {
            frame.setSize(1000, 740);
        }
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(main);
        //frame.add(test);
        frame.setVisible(true);
    }
}
