package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.model.maps.GameBoard;
import edu.chl.roborally.model.maps.IslandKingMap;
import edu.chl.roborally.model.maps.MapFactory;
import edu.chl.roborally.model.tiles.GameTile;
import edu.chl.roborally.utilities.Position;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Pertta on 15-05-13.
 */
public class CheckpointAttributeTest {

    private Player player;
    private RoboRally model;
    private CheckpointAttribute test;

    public CheckpointAttributeTest() {
        player = new Player(1,"Dave");
        test = new CheckpointAttribute(1);
        GameBoard map = new IslandKingMap();
        ArrayList<Player> players = new ArrayList<>();
        players.add(player);
        model = new RoboRally(players,map);
        System.out.println(player.getName() + " starts at position " + player.getPosition() + " and has checkpoint " + player.getCheckpoint());
    }

    @Test
    public void testDoAction() throws Exception {
        player.setPosition(new Position(9, 5));
        System.out.println("New position " + player.getPosition());
        test.doAction(player);
        System.out.println("New Checkpoint " + player.getCheckpoint());
        assertTrue(player.getCheckpoint() == player.getPosition());
    }
}