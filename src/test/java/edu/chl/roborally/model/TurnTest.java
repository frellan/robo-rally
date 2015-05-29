package edu.chl.roborally.model;

import edu.chl.roborally.model.maps.GameBoard;
import edu.chl.roborally.model.maps.IslandKingMap;
import edu.chl.roborally.model.robot.Robot;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.utilities.Position;
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
    private ArrayList<Player> players;

    @Before
    public void setUp() throws Exception {
        player1 = new Player(1,new Robot("Test LaserRobot", Color.ORANGE));
        player2 = new Player(1,new Robot("Test Another LaserRobot", Color.ORANGE));
        map = new IslandKingMap();
        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        model = new RoboRally(players,map);
    }

    @Test
    public void testLaser() throws Exception {
        //Players on same X different Y
        player1.setPosition(new Position(5,6));
        player2.setPosition(new Position(1,6));
        player1.setDirection(Constants.Directions.NORTH);
        player2.setDirection(Constants.Directions.NORTH);
        System.out.println("player1 has " + player1.getDamageTokens() + " damageTokens");
        System.out.println("player2 has " + player2.getDamageTokens() + " damageTokens");
        fireLasers();
        System.out.println("player1 has " + player1.getDamageTokens() + " damageTokens after LASER");
        System.out.println("player2 has " + player2.getDamageTokens() + " damageTokens after LASER");

        assertTrue(player1.getDamageTokens() == 0);
        assertTrue(player2.getDamageTokens() == 0);

        //assertTrue(player1.getDamageTokens() == 0);
        //assertTrue(player2.getDamageTokens() == 0);
    }

    private void fireLasers() {
        // Loop all players, all players fire lasers in their direction
        //TODO Stop laser if wall_tile in that direction
        for (Player p : players) {
            //Get current laser power for the player
            int playerLaserPower = p.getLaserPower();
            switch (p.getDirection()) {
                case NORTH:
                    //If x is equal and y is smaller
                    //Calculate how many tiles to loop through

                    for (Player enemy : players) {
                        if (!p.equals(enemy)) {
                            if (enemy.getPosition().getX() == p.getPosition().getX() && enemy.getPosition().getY() < p.getPosition().getY()) {
                                    enemy.takeDamage(playerLaserPower);
                                    break;
                            }
                        }
                    }
                case SOUTH:
                    //If x is equal and y is bigger
                    for (Player enemy : players) {
                        if (!p.equals(enemy)) {
                            if (enemy.getPosition().getX() == p.getPosition().getX() && enemy.getPosition().getY() > p.getPosition().getY()) {
                                enemy.takeDamage(playerLaserPower);
                                break;
                            }
                        }
                    }
                case EAST:
                    //If y is equal and x is bigger
                    for (Player enemy : players) {
                        if (!p.equals(enemy)) {
                            if (enemy.getPosition().getY() == p.getPosition().getY() && enemy.getPosition().getX() > p.getPosition().getX()) {
                                enemy.takeDamage(playerLaserPower);
                                break;
                            }
                        }
                    }
                case WEST:
                    //If y is equal and x is smaller
                    for (Player enemy : players) {
                        if (!p.equals(enemy)) {
                            if (enemy.getPosition().getY() == p.getPosition().getY() && enemy.getPosition().getX() < p.getPosition().getX()) {
                                enemy.takeDamage(playerLaserPower);
                                break;
                            }
                        }
                    }
            }
        }
    }
}