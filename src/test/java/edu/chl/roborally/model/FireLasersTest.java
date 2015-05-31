package edu.chl.roborally.model;

import edu.chl.roborally.model.robot.Robot;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.utilities.Position;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by henriknilson on 31/05/15.
 */
public class FireLasersTest {

    private ArrayList<Player> players;
    private Player twitch;
    private Player hank;

    @Before
    public void setUp() throws Exception {
        players = new ArrayList<>();

        twitch = new Player(0, new Robot("Twitch", Color.BLACK));
        hank = new Player(1, new Robot("Hank", Color.BLUE));

        players.add(twitch);
        players.add(hank);

        twitch.setPosition(new Position(3, 5));
        hank.setPosition(new Position(3, 6));

        twitch.setDirection(Constants.Directions.SOUTH);
        hank.setDirection(Constants.Directions.NORTH);
    }

    @Test
    public void testFireLasers() {
        new FireLasers(players);

        assertTrue(hank.getDamageTokens() == 1);
        assertTrue(twitch.getDamageTokens() == 1);
    }
}