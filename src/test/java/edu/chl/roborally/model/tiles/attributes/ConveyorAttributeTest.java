package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.model.gameactions.GameAction;
import edu.chl.roborally.model.maps.GameBoard;
import edu.chl.roborally.model.maps.IslandKingMap;
import edu.chl.roborally.model.robot.Robot;
import edu.chl.roborally.utilities.Position;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Pertta on 15-05-31.
 */
public class ConveyorAttributeTest {

    private Player player;
    private RoboRally model;
    private GameBoard map;

    @Before
    public void setUp() throws Exception {
        player = new Player(1,new Robot("TestRobot1", Color.ORANGE));
        map = new IslandKingMap();
        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        model = new RoboRally(players,map);
        System.out.println(player.getName() + " starts at position " + player.getPosition());
    }

    public void executeAction(Player player) {
        for (GameAction action : map.getTile(player.getPosition()).getActions()) {
            action.doAction(player);

        }
    }

    @Test
    public void testDoAction() throws Exception {
        //Player standing on ConveyerNorth, should move player in direction north
        player.setPosition(new Position(6, 5));
        Position expectedPos = new Position(6,4);
        System.out.println(player.getName() + "New position " + player.getPosition());
        executeAction(player);
        player.setPosition(player.getNextPosition().clone());
        assertTrue(player.getPosition().equals(expectedPos));
        System.out.println("  ");
    }
}