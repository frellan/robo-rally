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
    private Player player3;
    private RoboRally model;
    private GameBoard map;
    private ArrayList<Player> players;

    @Before
    public void setUp() throws Exception {
        player1 = new Player(1,new Robot("Test LaserRobot1", Color.ORANGE));
        player2 = new Player(1,new Robot("Test LaserRobot2", Color.ORANGE));
        player3 = new Player(1,new Robot("Test LaserRobot3", Color.ORANGE));

        map = new IslandKingMap();
        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        model = new RoboRally(players,map);
    }

    @Test
    public void testLaser() throws Exception {
        //Players on same X different Y
        player1.setPosition(new Position(1,3));
        player2.setPosition(new Position(1,4));
        player3.setPosition(new Position(1,5));
        player1.setDirection(Constants.Directions.NORTH);
        player2.setDirection(Constants.Directions.NORTH);
        player3.setDirection(Constants.Directions.NORTH);
        System.out.println("player1 has " + player1.getDamageTokens() + " damageTokens");
        System.out.println("player2 has " + player2.getDamageTokens() + " damageTokens");
        System.out.println("player3 has " + player3.getDamageTokens() + " damageTokens");
        System.out.println(" ");
        fireLasers();
        System.out.println(" ");
        System.out.println("player1 has " + player1.getDamageTokens() + " damageTokens after LASER");
        System.out.println("player2 has " + player2.getDamageTokens() + " damageTokens after LASER");
        System.out.println("player3 has " + player3.getDamageTokens() + " damageTokens after LASER");


        assertTrue(player1.getDamageTokens() == 1);
        assertTrue(player2.getDamageTokens() == 1);
        assertTrue(player3.getDamageTokens() == 0);

        //Players on same Y different X
    }

    private void fireLasers() {
        // Loop all players, all players fire lasers in their direction
        //TODO Stop laser if wall_tile in that direction
        for (Player p : players) {
            switch (p.getDirection()) {
                case NORTH:
                    //If x is equal and y is smaller
                    for (Player enemy : players) {
                        if (enemy.getPosition().getX() == p.getPosition().getX()){
                            for (int i = p.getPosition().getY(); i >= 0; i--) {
                                if (enemy.getPosition().getY() < i) {
                                    enemy.takeDamage(p.getLaserPower());
                                    break;
                                }
                            }
                        }
                    }
                case SOUTH:
                    //If x is equal and y is bigger
                    for (Player enemy : players) {
                        if (enemy.getPosition().getX() == p.getPosition().getX()){
                            for (int i = p.getPosition().getY(); i < Constants.NUM_ROWS; i ++) {
                                if(enemy.getPosition().getY() > i) {
                                    enemy.takeDamage(p.getLaserPower());
                                    break;
                                }
                            }
                        }
                    }
                case EAST:
                    //If y is equal and x is bigger
                    for (Player enemy : players) {
                        if (enemy.getPosition().getY() == p.getPosition().getY()) {
                            for (int i = p.getPosition().getX(); i < Constants.NUM_COLS; i++) {
                                if (enemy.getPosition().getX() > i) {
                                    System.out.println("Player X,Y = " + p.getPosition().getX() + " " + p.getPosition().getY() + " Enemy X,Y= " + enemy.getPosition().getX() + " " + enemy.getPosition().getY() );
                                    enemy.takeDamage(p.getLaserPower());
                                    break;
                                }
                            }
                        }
                    }
                case WEST:
                    //If y is equal and x is smaller
                    for (Player enemy : players) {
                        if (enemy.getPosition().getY() == p.getPosition().getY()) {
                            for (int i = p.getPosition().getX(); i >= 0; i--) {
                                if (enemy.getPosition().getX() < i) {
                                    enemy.takeDamage(p.getLaserPower());
                                    break;
                                }
                            }
                        }
                    }
            }

        }
    }
}