package edu.chl.roborally.model;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.Position;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by henriknilson on 31/05/15.
 */
public class FireLasers {

    private ArrayList<Player> players;

    public FireLasers(ArrayList<Player> players) {

        this.players = players;

        activateLasers();
    }

    private void activateLasers() {
        // Loop all players, all players fire lasers in their direction
        //TODO Stop laser if wall_tile in that direction
        for (Player p : players) {
            if (p.isAlive()) {
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
    }

    private void aimAndFire(Player player, int playerDirectionPos, int iterationStart) {
        switch (player.getDirection()) {
            case NORTH:
                outerLoop:
                for (int y = playerDirectionPos; y >= iterationStart; y--) {
                    Position firePosition = new Position(player.getPosition().getX(), y);
                    for (Player enemy : players) {
                        if (!player.equals(enemy) && enemy.getPosition().equals(firePosition)) {
                            enemy.takeDamage(player.getLaserPower());
                            printFireMsg(player,enemy);
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
                            printFireMsg(player,enemy);
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
                            printFireMsg(player,enemy);
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
                            printFireMsg(player,enemy);
                            break outerLoop;
                        }
                    }
                }
                break;
        }
    }

    /**
     * Prints fire message by sending events to the console
     *
     * @param p Player, the shooter
     * @param enemy Enemy, the one getting shot at
     */
    private void printFireMsg(Player p, Player enemy) {
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, p.getName(), p.getColor());
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE," shoot in " + p.getDirection() +
                " direction and hit ", Color.RED);
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, enemy.getName(), enemy.getColor());
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE," whom now has " + enemy.getDamageTokens() +
                " damage token(s)" + "\n", Color.RED);
    }
}
