package edu.chl.roborally.model;

import edu.chl.roborally.model.cards.RegisterCard;
import edu.chl.roborally.model.cards.RegisterCardCompare;
import edu.chl.roborally.model.gameactions.GameAction;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.gameactions.MovePlayer;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.WallException;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by henriknilson on 31/03/15.
 *
 * This is the class in the model with the most game logic.
 * Here is where all the players move and interact with each other.
 */
public class Turn {

    private RoboRally model;
    private ArrayList<Player> players;
    private final int turnIndex;
    private ArrayList<RegisterCard> activeCards = new ArrayList<>();
    private Map<RegisterCard,Player> activeCardPlayer = new HashMap<>();

    /**
     * Creates the turn and runs the start method that performs all tasks needed for a turn.
     * @param model The top model class of the current game that holds useful information.
     * @param turnIndex The index of the turn in the current round. Can be 1 to 5.
     */
    public Turn(RoboRally model, int turnIndex) {
        this.model = model;
        this.players = this.model.getPlayers();
        this.turnIndex = turnIndex;
        startTurn();
    }

    /*
    Main method
     */

    /**
     * Main method that calls all the help methods to perform the tasks needed for a turn.
     */
    private void startTurn() {
        revealProgrammedCards();
        sortActiveCards();
        executeActiveCards();
        executeBoardElements();
        fireLasers();
        checkIfOnlyOneSurvivor();
        EventTram.getInstance().publish(EventTram.Event.UPDATE_BOARD, null, null);
        EventTram.getInstance().publish(EventTram.Event.UPDATE_STATUS, null, null);
    }

    /*
    Help methods
     */

    /**
     * Loop through all player and their cards and set card with the turnIndex
     * to visible for all players.
     */
    private void revealProgrammedCards() {
        for (Player player : players) {
            RegisterCard card = player.getProgrammedCard(turnIndex);
            card.setHidden(false);
            activeCards.add(card);
            activeCardPlayer.put(card,player);
            System.out.println("picked card with index " + turnIndex + " from " + player.getName());
        }
    }

    private void sortActiveCards() {
        Collections.sort(activeCards, new RegisterCardCompare());
    }

    private void executeActiveCards() {
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, "ANALYSING CARDS" + "\n", Color.MAGENTA);
        for (RegisterCard card : activeCards) {
            Player player = activeCardPlayer.get(card);
            if (player.isAlive()) {
                ArrayList<GameAction> actions = card.getActions();
                EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, "Priority " + card.getPoints() + ": \n", null);
                EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE,  player.getName() + " ", player.getColor());
                EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE,  card.getCardMessage() + "\n", null);

                for (GameAction action : actions) {
                    player.setMovingDirection(player.getDirection());
                    executeAction(action,player);
                }
            }
        }
    }

    private void executeAction(GameAction action, Player player) {
        if (action instanceof MovePlayer) {
            // Set Players next position
            action.doAction(player);
            if (checkIfVaildPosition(player)) {
                player.setPosition(player.getNextPosition().clone());
            }
        }
    }

    private boolean checkIfVaildPosition(Player player) {
        // Först om en vägg där man lämnar
        if ()
        // Sen om man kommer till en vägg
        return true;
    }

    // TODO Give priority to gametiles so we can execute some tiles before others
    private void executeBoardElements() {
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, "TILE ACTIONS" + "\n" , Color.MAGENTA);
        for (Player player : players) {
            if (player.isAlive()) {
                EventTram.getInstance().publish(EventTram.Event.EXECUTE_TILE_ACTION,player,null);
            }
        }
    }

    private void fireLasers() {
        // Loop all players, all players fire lasers in their direction
        //TODO Stop laser if wall_tile in that direction
        for (Player p : players) {
            //Get current laser power for the player
            int playerLaserPower = p.getLaserPower();
            switch (p.getDirection()) {
                case NORTH:
                    //If x is equal and y is bigger
                    for (Player enemy : players) {
                        if (enemy.getPosition().getX() == p.getPosition().getX() && enemy.getPosition().getY() < p.getPosition().getY()) {
                            enemy.takeDamage(playerLaserPower);
                            printFireMsg(p, enemy);
                            break;
                        }
                    }
                case SOUTH:
                    //If x is equal and y is smaller
                    for (Player enemy : players) {
                        if (enemy.getPosition().getX() == p.getPosition().getX() && enemy.getPosition().getY() > p.getPosition().getY()) {
                            enemy.takeDamage(playerLaserPower);
                            printFireMsg(p, enemy);
                            break;
                        }
                    }
                case EAST:
                    //If y is equal and x is bigger
                    for (Player enemy : players) {
                        if (enemy.getPosition().getY() == p.getPosition().getY() && enemy.getPosition().getX() > p.getPosition().getX()) {
                            enemy.takeDamage(playerLaserPower);
                            printFireMsg(p, enemy);
                            break;
                        }
                    }
                case WEST:
                    //If y is equal and x is smaller
                    for (Player enemy : players) {
                        if (enemy.getPosition().getY() == p.getPosition().getY() && enemy.getPosition().getX() < p.getPosition().getX()) {
                            enemy.takeDamage(playerLaserPower);
                            printFireMsg(p, enemy);
                            break;
                        }
                }
            }
        }
    }

    /**
     * Checks if only one player is alive and all others Kaput
     */
    public void checkIfOnlyOneSurvivor() {
        int nbrPlayersKaput = 0;
        int totalPlayers = players.size();
        for (Player player : players) {
            if (player.isKaput()) {
                nbrPlayersKaput++;
            }
        }
        if ((totalPlayers - nbrPlayersKaput) == 1) {
            endGameSurvivor();
        } else {
            System.out.print("Everybody not dead, continue ");
        }
    }

    /**
     * Method only called when one player is alive
     */
    public void endGameSurvivor() {
        for (Player player : players) {
            if (player.isAlive()) {
                EventTram.getInstance().publish(EventTram.Event.VICTORY, player, null);
            }
        }
    }

    /**
     * Prints fire message by sending events to the console
     *
     * @param p Player, the shooter
     * @param enemy Enemy, the one getting shot at
     */
    private void printFireMsg(Player p, Player enemy) {
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, Constants.UNDER_LINE + "\n", Color.RED);
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, p.getName(), p.getColor());
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE," shoot in " + p.getDirection() + " direction and hit ", Color.RED);
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, enemy.getName(), enemy.getColor());
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE," whom now has " + enemy.getDamageTokens() + " damage token(s)" + "\n"
                                                                      + Constants.UNDER_LINE + "\n", Color.RED);
    }
}