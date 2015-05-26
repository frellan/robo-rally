package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.model.gameactions.GameAction;
import edu.chl.roborally.model.maps.GameBoard;
import edu.chl.roborally.model.maps.IslandKingMap;
import edu.chl.roborally.model.robot.Robot;
import edu.chl.roborally.utilities.Position;
import edu.chl.roborally.utilities.WallException;
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
        player = new Player(1,new Robot("Test Robot", Color.ORANGE));
        player2 = new Player(1,new Robot("Test Another Robot", Color.ORANGE));
        player.setCheckpointId(0);
        map = new IslandKingMap();
        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        model = new RoboRally(players,map);
        System.out.println(player.getName() + " starts at position " + player.getPosition() + " and has checkpoint " + player.getCheckpoint());
    }

    public void executeAction(Player player) {
        for (GameAction action : map.getTile(player.getPosition()).getActions()) {
            try {
                action.doAction(player);
            } catch (WallException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testDoAction() throws Exception {
        //Player goes to third checkpoint
        player.setPosition(new Position(9, 5));
        System.out.println(player.getName() + "New position " + player.getPosition());
<<<<<<< HEAD
        executeAction(player);
=======
        map.getTile(player.getPosition()).getAction(player);
>>>>>>> 1245c9740ba977b91852639790422ef0d16dcdae
        assertTrue(player.getCheckpoint() != player.getPosition());
        System.out.println("  ");

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
<<<<<<< HEAD
        executeAction(player2);
=======
        map.getTile(player2.getPosition()).getAction(player2);
>>>>>>> 1245c9740ba977b91852639790422ef0d16dcdae
        System.out.println("New Checkpoint " + player2.getCheckpoint());
        assertTrue(player2.getCheckpoint() == player2.getPosition());

        System.out.println("  ");

        //Player2 goes to second checkpoint
        player2.setPosition(new Position(8, 7));
        System.out.println(player2.getName() + "New position " + player2.getPosition());
<<<<<<< HEAD
        executeAction(player2);
=======
        map.getTile(player2.getPosition()).getAction(player2);
>>>>>>> 1245c9740ba977b91852639790422ef0d16dcdae
        assertTrue(player2.getCheckpoint() == player2.getPosition());

        System.out.println("  ");

        //Player2 goes to first checkpoint
        player2.setPosition(new Position(11, 5));
        System.out.println(player2.getName() + "New position " + player2.getPosition());
<<<<<<< HEAD
        executeAction(player2);
=======
        map.getTile(player2.getPosition()).getAction(player2);
>>>>>>> 1245c9740ba977b91852639790422ef0d16dcdae
        assertTrue(player2.getCheckpoint() != player2.getPosition());


    }
}