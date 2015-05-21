package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.RoboRally;
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
    private RoboRally model;
    private GameBoard map;

    @Before
    public void setUp() throws Exception {
        player = new Player(1,new Robot("Test Robot", Color.ORANGE));
        player.setCheckpointId(0);
        map = new IslandKingMap();
        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        model = new RoboRally(players,map);
        System.out.println(player.getName() + " starts at position " + player.getPosition() + " and has checkpoint " + player.getCheckpoint());
    }

    @Test
    public void testDoAction() throws Exception {
        //Player goes to wrong third checkpoint
        player.setPosition(new Position(9, 5));
        System.out.println("New position " + player.getPosition());
        map.getTile(player.getPosition()).getAction(player);
        assertTrue(player.getCheckpoint() != player.getPosition());

        //Player goes to first checkpoint
        player.setPosition(new Position(11, 5));
        System.out.println("New position " + player.getPosition());
        map.getTile(player.getPosition()).getAction(player);
        System.out.println("New Checkpoint " + player.getCheckpoint());
        assertTrue(player.getCheckpoint() == player.getPosition());
    }
}