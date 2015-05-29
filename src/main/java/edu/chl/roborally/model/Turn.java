package edu.chl.roborally.model;

import edu.chl.roborally.model.cards.RegisterCard;
import edu.chl.roborally.model.cards.RegisterCardCompare;
import edu.chl.roborally.model.gameactions.GameAction;
import edu.chl.roborally.model.tiles.attributes.Attribute;
import edu.chl.roborally.model.tiles.attributes.WallAttribute;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.model.gameactions.MovePlayer;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.Position;

import javax.annotation.Nullable;
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

    private final RoboRally model;
    private final ArrayList<Player> players;
    private final int turnIndex;
    private final ArrayList<RegisterCard> activeCards = new ArrayList<>();
    private final Map<RegisterCard,Player> activeCardPlayer = new HashMap<>();

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
     * to visible for all players. Also adds them to a list for sorting.
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

    /**
     * Sorts the active cards to bring the card with highest priority to the top.
     * This will be the card that will be executed first.
     */
    private void sortActiveCards() {
        Collections.sort(activeCards, new RegisterCardCompare());
    }

    /**
     * Loops through the sorted cards and calls the execute method if a player is alive.
     */
    private void executeActiveCards() {
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, "ANALYSING CARDS" + "\n", Color.MAGENTA);
        for (RegisterCard card : activeCards) {
            Player player = activeCardPlayer.get(card);
            if (player.isAlive()) {
                ArrayList<GameAction> actions = card.getActions();
                EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, "Priority " + card.getPoints() + ": \n", null);
                EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE,  player.getName() + " ", player.getColor());
                EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE,  card.getMessage() + "\n", null);
                for (GameAction action : actions) {
                    player.setMovingDirection(player.getDirection());
                    executeAction(action,player);
                }
            }
        }
    }

    /**
     * Performs the given action for the given player.
     * If the action is a move action the method checks if the player can
     * move there. If it can it checks if there is another player present
     * at the new position. If there is, it calls itself again on that player.
     * This creates the "pushing" logic on the board.
     * If any of these modes fail the methods returns false which causes
     * all of the movement for all players in the chain to be aborted.
     * This creates the "hitting a wall" logic on the board.
     * @param action The game action to be performed.
     * @param player The player to be affected by the action.
     * @return True if all whole action chain is good, false if any action fails.
     */
    private boolean executeAction(GameAction action, Player player) {
        action.doAction(player);
        if (action instanceof MovePlayer) {
            if (!playerIsHittingWall(player)) {
                if (enemyAtNextPosition(player.getNextPosition()) != null) {
                    Player enemy = enemyAtNextPosition(player.getNextPosition());
                    enemy.setMovingDirection(player.getMovingDirection());
                    if (executeAction(new MovePlayer(), enemy)) {
                        player.setPosition(player.getNextPosition().clone());
                        return true;
                    }
                } else {
                    player.setPosition(player.getNextPosition().clone());
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns if a player is hitting a wall when moving to its new position.
     * @param player The player to check.
     * @return True if player would hit a wall, false if not.
     */
    private boolean playerIsHittingWall(Player player) {
        for (Attribute attribute: model.getBoard().getTile(player.getPosition()).getBeforeAttributes()) {
            if (attribute instanceof WallAttribute) {
                if (player.getMovingDirection() == (((WallAttribute) attribute).getDirection())){
                    return true;
                }
            }
        }
        for (Attribute attribute: model.getBoard().getTile(player.getNextPosition()).getBeforeAttributes()) {
            if (attribute instanceof WallAttribute) {
                if (player.getMovingDirection() == (((WallAttribute) attribute).getDirection().getOpposite())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check if there is another player at a position and returns that player if there is.
     * @param position The position to check.
     * @return A player if found, otherwise null.
     */
    @Nullable
    private Player enemyAtNextPosition(Position position) {
        for (Player enemy : players) {
            if (position.equals(enemy.getPosition())) {
                return enemy;
            }
        }
        return null;
    }

    // TODO Give priority to gametiles so we can execute some tiles before others
     private void executeBoardElements() {
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, "TILE ACTIONS" + "\n" , Color.MAGENTA);
        for (Player player : players) {
            if (player.isAlive()) {
                for (GameAction action : model.getBoard().getTile(player.getPosition()).getActions()) {
                    // TODO Set player moving direction from tiles direction
                    executeAction(action, player);
                }
            }
        }
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
                                     printFireMsg(p, enemy);
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
                                    printFireMsg(p, enemy);
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
                                    enemy.takeDamage(p.getLaserPower());
                                    printFireMsg(p, enemy);
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
                                    printFireMsg(p, enemy);
                                    break;
                                }
                            }
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
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, p.getName(), p.getColor());
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE," shoot in " + p.getDirection() + " direction and hit ", Color.RED);
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, enemy.getName(), enemy.getColor());
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE," whom now has " + enemy.getDamageTokens() + " damage token(s)" + "\n"
                                                                      + Constants.UNDER_LINE + "\n", Color.RED);
    }
}