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
        player1 = new Player(1, new Robot("Test LaserRobot1", Color.ORANGE));
        player2 = new Player(1, new Robot("Test LaserRobot2", Color.ORANGE));
        player3 = new Player(1, new Robot("Test LaserRobot3", Color.ORANGE));

        map = new IslandKingMap();
        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        model = new RoboRally(players, map);
    }

    @Test
    public void testLaser() throws Exception {

        //Players on same X different Y

        player1.setPosition(new Position(1, 3));
        player2.setPosition(new Position(1, 4));
        player3.setPosition(new Position(1, 5));
        player1.setDirection(Constants.Directions.NORTH);
        player2.setDirection(Constants.Directions.NORTH);
        player3.setDirection(Constants.Directions.NORTH);
        System.out.println("player1 has " + player1.getDamageTokens() + " damageTokens");
        System.out.println("player2 has " + player2.getDamageTokens() + " damageTokens");
        System.out.println("player3 has " + player3.getDamageTokens() + " damageTokens");

        activateLasers();
        System.out.println(player1.getName() + " " + player1.getDamageTokens() + " damageTokens after LASER");
        System.out.println(player2.getName() + " " + player2.getDamageTokens() + " damageTokens after LASER");
        System.out.println(player3.getName() + " " + player3.getDamageTokens() + " damageTokens after LASER");


        assertTrue(player1.getDamageTokens() == 0);
        assertTrue(player2.getDamageTokens() == 1);
        assertTrue(player3.getDamageTokens() == 0);
    }

    private void activateLasers() {
        // Loop all players, all players fire lasers in their direction
        //TODO Stop laser if wall_tile in that direction
        for (Player p : players) {
            System.out.println("Lasertracking" + p.getName());
            switch (p.getDirection()) {
                case NORTH:
                    aimAndFire(p, p.getPosition().getY(), 0);
                    break;
                case SOUTH:
                    aimAndFire(p, p.getPosition().getY(), Constants.NUM_ROWS);
                    break;
                case EAST:
                    aimAndFire(p, p.getPosition().getX(), Constants.NUM_COLS);
                    break;
                case WEST:
                    aimAndFire(p, p.getPosition().getX(), 0);
                    break;
            }
        }
    }

    public void aimAndFire(Player player, int playerDirectionPos, int iterationStart) {
        switch (player.getDirection()) {
            case NORTH:
                outerLoop:
                for (int y = playerDirectionPos; y >= iterationStart; y--) {
                    Position firePosition = new Position(player.getPosition().getX(), y);
                    for (Player enemy : players) {
                        if (!player.equals(enemy) && enemy.getPosition().equals(firePosition)) {
                            enemy.takeDamage(player.getLaserPower());
                            break outerLoop;
                        }
                    }
                }
                break;
            case SOUTH:
                outerLoop:
                for (int y = playerDirectionPos; y <= iterationStart; y++) {
                    Position firePosition = new Position(player.getPosition().getX(), y);
                    for (Player enemy : players) {
                        if (!player.equals(enemy) && enemy.getPosition().equals(firePosition)) {
                            enemy.takeDamage(player.getLaserPower());
                            break outerLoop;
                        }
                    }
                }
                break;
            case EAST:
                outerLoop:
                for (int x = playerDirectionPos; x <= iterationStart; x++) {
                    Position firePosition = new Position(x, player.getPosition().getY());
                    for (Player enemy : players) {
                        if (!player.equals(enemy) && enemy.getPosition().equals(firePosition)) {
                            enemy.takeDamage(player.getLaserPower());
                            break outerLoop;
                        }
                    }
                }
                break;
            case WEST:
                outerLoop:
                for (int x = playerDirectionPos; x >= iterationStart; x--) {
                    Position firePosition = new Position(x, player.getPosition().getY());
                    for (Player enemy : players) {
                        if (!player.equals(enemy) && enemy.getPosition().equals(firePosition)) {
                            enemy.takeDamage(player.getLaserPower());
                            break outerLoop;
                        }
                    }
                }
                break;
        }
    }
}