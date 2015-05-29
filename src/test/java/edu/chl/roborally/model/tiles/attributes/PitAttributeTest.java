package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.GameAction;
import edu.chl.roborally.model.maps.GameBoard;
import edu.chl.roborally.model.maps.IslandKingMap;
import edu.chl.roborally.model.robot.Robot;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.utilities.Position;
import org.junit.Before;
import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.*;

/**
 * Created by henriknilson on 29/05/15.
 */
public class PitAttributeTest {

    private Player player;
    private GameBoard map;

    @Before
    public void setUp() throws Exception {
        player = new Player(1,new Robot("Test Robot", Color.ORANGE));
        map = new IslandKingMap();
        player.setPosition(new Position(5,1));
        System.out.println(player.getName() + " starts at position " + player.getPosition() + " and is " + player.getStatus());
    }

    @Test
    public void testDoAction() throws Exception {
        for (GameAction action : map.getTile(player.getPosition()).getBeforeAction()) {
            action.doAction(player);
        }
        System.out.println(player.getName() + " is now: " + player.getStatus());
        assertTrue(player.getStatus() == Constants.Status.DEAD);
    }
}