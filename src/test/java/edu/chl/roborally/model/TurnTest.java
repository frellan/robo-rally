package edu.chl.roborally.model;

import edu.chl.roborally.model.maps.GameBoard;
import edu.chl.roborally.model.maps.IslandKingMap;
import edu.chl.roborally.model.robot.Robot;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Pertta on 15-05-26.
 */
public class TurnTest {

    private Player player1;
    private Player player2;
    private RoboRally model;
    private GameBoard map;

    @Before
    public void setUp() throws Exception {
        player1 = new Player(1,new Robot("Test LaserRobot", Color.ORANGE));
        player2 = new Player(1,new Robot("Test Another LaserRobot", Color.ORANGE));
        map = new IslandKingMap();
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        model = new RoboRally(players,map);
    }

    @Test
    public void testLaser() throws Exception {

    }
}