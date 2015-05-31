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
 * Created by Pertta on 15-05-13.
 */
public class CheckpointAttributeTest {

    private Player player;
    private Player player2;
    private RoboRally model;
    private GameBoard map;

    @Before
    public void setUp() throws Exception {
        player = new Player(1,new Robot("TestRobot1", Color.ORANGE));
        player2 = new Player(1,new Robot("TestRobot2", Color.ORANGE));
        player.setCheckpointID(0);
        map = new IslandKingMap();
        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        model = new RoboRally(players,map);
        System.out.println(player.getName() + " starts at position " + player.getPosition() + " and has checkpoint " + player.getCheckpoint());
    }

    public void executeAction(Player player) {
        for (GameAction action : map.getTile(player.getPosition()).getActions()) {
            action.doAction(player);
        }
    }

    @Test
    public void testDoAction() throws Exception {
        //Player goes to third checkpoint
        player.setPosition(new Position(9, 5));
        System.out.println(player.getName() + "New position " + player.getPosition());
        executeAction(player);
        assertTrue(player.getCheckpoint() != player.getPosition());
        System.out.println("  ");

        //Player goes to first checkpoint
        player.setPosition(new Position(11, 5));
        System.out.println("New position " + player.getPosition());
        executeAction(player);
        System.out.println("New Checkpoint " + player.getCheckpoint());
        assertTrue(player.getCheckpoint() == player.getPosition());

        System.out.println("  ");

        //Player2 goes to first checkpoint
        player2.setPosition(new Position(11, 5));
        System.out.println(player2.getName() + " New position " + player2.getPosition());
        executeAction(player2);
        System.out.println("New Checkpoint " + player2.getCheckpoint());
        assertTrue(player2.getCheckpoint() == player2.getPosition());

        System.out.println("  ");

        //Player2 goes to second checkpoint
        player2.setPosition(new Position(8, 7));
        System.out.println(player2.getName() + "New position " + player2.getPosition());
        executeAction(player2);
        assertTrue(player2.getCheckpoint() == player2.getPosition());

        System.out.println("  ");

        //Player2 goes to first checkpoint
        player2.setPosition(new Position(11, 5));
        System.out.println(player2.getName() + "New position " + player2.getPosition());
        executeAction(player2);
        assertTrue(player2.getCheckpoint() != player2.getPosition());

        //Player2 goes to final checkpoint
        player2.setPosition(new Position(9, 5));
        System.out.println(player2.getName() + "New position " + player2.getPosition());
        executeAction(player2);
        assertTrue(model.isGameRunning() == false);



    }
}