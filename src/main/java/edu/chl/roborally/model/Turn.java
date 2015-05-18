package edu.chl.roborally.model;

import edu.chl.roborally.model.cards.RegisterCard;
import edu.chl.roborally.model.cards.RegisterCardCompare;
import edu.chl.roborally.utilities.EventTram;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by henriknilson on 31/03/15.
 */
public class Turn{

    private RoboRally model;
    private ArrayList<Player> players;
    private ArrayList<RegisterCard> activeCards = new ArrayList<>();
    private Map<RegisterCard,Player> activeCardPlayer = new HashMap<>();

    /**
    * The index of the turn, given by round
    */
    private final int turnIndex;

    public Turn(RoboRally r, int turnIndex) {
        this.model = r;
        this.players = model.getPlayers();
        this.turnIndex = turnIndex;
        startTurn();
    }

    private void startTurn() {
        revealProgrammedCards();
        sortActiveCards();
        executeActiveCards();
        executeBoardElements();
        fireLasers();

        EventTram.getInstance().publish(EventTram.Event.UPDATE_BOARD, null);
        EventTram.getInstance().publish(EventTram.Event.UPDATE_STATUS, null);
    }

    // Executing methods

    /**
     * Loop through all player and their cards and set card with the turnIndex
     * to visible for all players
     */
    private void revealProgrammedCards() {
        for (Player player : players) {
            RegisterCard card = player.getProgrammedCard(turnIndex);
            card.setHidden(false);
            activeCards.add(card);
            activeCardPlayer.put(card,player);
        }
    }

    private void sortActiveCards() {
        Collections.sort(activeCards, new RegisterCardCompare());
    }

    private void executeActiveCards() {
        System.out.println("----------------------------");
        System.out.println("------- Card Actions -------");
        for (RegisterCard card : activeCards) {
            Player player = activeCardPlayer.get(card);
            if (player.isAlive()) {
                card.doAction(player);
            }
        }
        System.out.println("------ End card Actions -----");
    }

    // TODO Give priority to gametiles so we can execute some tiles before others
    private void executeBoardElements() {
        System.out.println("----------------------------");
        System.out.println("------- Tile Actions -------");
        for (Player player : players) {
            if (player.isAlive()) {
                EventTram.getInstance().publish(EventTram.Event.EXECUTE_TILE_ACTION, player);
            }
        }
        System.out.println("----- End tile actions -----");
    }

    private void fireLasers() {
        // Loop all players, all players fire lasers in their direction
        //TODO Stop laser if wall_tile in that direction
        //TODO Stop when other player is hit
        for (Player p : players) {
            //Get current laser power for the player
            int playerLaserPower = p.getLaserPower();
            switch (p.getDirection()) {
                case NORTH:
                    //If x is equal and y is bigger
                    for (Player enemy : players) {
                        if (enemy.getPosition().getX() == p.getPosition().getX() && enemy.getPosition().getY() > p.getPosition().getY()) {
                            enemy.takeDamage(playerLaserPower);
                            printFireMsg(p, enemy);
                        }
                    }
                    break;
                case SOUTH:
                    //If x is equal and y is smaller
                    for (Player enemy : players) {
                        if (enemy.getPosition().getX() == p.getPosition().getX() && enemy.getPosition().getY() < p.getPosition().getY()) {
                            enemy.takeDamage(playerLaserPower);
                            printFireMsg(p,enemy);
                        }
                    }
                    break;
                case EAST:
                    //If y is equal and x is bigger
                    for (Player enemy : players) {
                        if (enemy.getPosition().getY() == p.getPosition().getY() && enemy.getPosition().getX() > p.getPosition().getX()) {
                            enemy.takeDamage(playerLaserPower);
                            printFireMsg(p,enemy);
                        }
                    }
                    break;
                case WEST:
                    //If y is equal and x is smaller
                    for (Player enemy : players) {
                        if (enemy.getPosition().getY() == p.getPosition().getY() && enemy.getPosition().getX() < p.getPosition().getX()) {
                            enemy.takeDamage(playerLaserPower);
                            printFireMsg(p,enemy);
                        }
                    }
                    break;
            }
        }
    }

    private void printFireMsg(Player p, Player enemy) {
        System.out.println(p.getName() + " shoot in " + p.getDirection() + " and hit " + enemy.getName());
        System.out.println(enemy.getName() + " now has " + enemy.getDamageTokens() + " damage tokens");
    }
}