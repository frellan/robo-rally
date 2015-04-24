package edu.chl.roborally.model;

import edu.chl.roborally.model.cards.RegisterCard;
import edu.chl.roborally.model.cards.RegisterCardCompare;
import edu.chl.roborally.view.UI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by henriknilson on 31/03/15.
 */
public class Turn {

    private RoboRally model;
    private ArrayList<Player> players;
    private ArrayList<RegisterCard> activeCards = new ArrayList<>();
    private Map<RegisterCard,Player> activeCardPlayer = new HashMap<>();
    private UI ui;

    /**
    * The index of the turn, given by round
    */
    private final int index;

    public Turn(RoboRally r, int index, UI ui) {
        this.model = r;
        this.players = model.getPlayers();
        this.ui = ui;
        this.index = index;
        startTurn();
    }

    private void startTurn() {
        revealProgrammedCards();
        sortActiveCards();
        executeActiveCards();
        executeBoardElements();
        fireLasers();
    }

    // Executing methods

    private void revealProgrammedCards() {
        for (Player player : players) {
            RegisterCard card = player.getProgrammedCard(index);
            card.setHidden(false);
            activeCards.add(card);
            activeCardPlayer.put(card,player);
        }
    }

    private void sortActiveCards() {
        Collections.sort(activeCards, new RegisterCardCompare());
    }

    private void executeActiveCards() {
        System.out.println("Card Actions");
        for (RegisterCard card : activeCards) {
            Player player = activeCardPlayer.get(card);
            if (player.isAlive()) {
                card.doAction(player);
            }
        }
    }
    // TODO Give priority to gametiles so we can execute some tiles before others
    private void executeBoardElements() {
        System.out.println("Tile Actions");
        for (Player p : players) {
            if (p.isAlive()) {
                try {
                    model.getGameBoard().getTile(p.getPosition()).doAction(p);
                } catch (ArrayIndexOutOfBoundsException e) {
                    // If player is out of bounds we kill him
                    System.out.println("Player fell of board and died");
                    p.kill();
                }
            }
        }
    }

    private void fireLasers() {
        // Loop all players, all players fire lasers in their direction
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