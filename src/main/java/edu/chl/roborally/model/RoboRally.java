package edu.chl.roborally.model;

import edu.chl.roborally.model.cards.CardDeck;
import edu.chl.roborally.model.cards.RegisterCard;
import edu.chl.roborally.model.maps.GameBoard;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.IEventHandler;
import edu.chl.roborally.utilities.Position;
import java.util.*;

/**
 * Created by Henrik.
 *
 * Our top level model class which holds the status of the game.
 * This class mainly sets the ground stones fot the game and hold the card deck.
 */
public class RoboRally implements IEventHandler{

    private final GameBoard board;
    private final ArrayList<Player> players;
    private CardDeck deck;
    private boolean gameIsRunning;

    /**
     * Creates the model for the game and does the required tasks to start the first round.
     * @param players The player that are about to play the game.
     * @param map The map which the game will be played on.
     */
    public RoboRally(ArrayList<Player> players, GameBoard map) {
        this.players = players;
        this.board = map;
        EventTram.getInstance().register(this);
        EventTram.getInstance().register(board);
        resetDeck();
        setStartPositions();
        gameIsRunning = true;
    }

    /*
    Class methods
     */

    /**
     * Creates a new deck if there is not one already and resets it of there is one.
     */
    private void resetDeck() {
        if (deck == null) {
            deck = new CardDeck();
        } else {
            deck.reset();
        }
    }

    /**
     * Gets the start positions from the current map and sets them to all the players.
     */
    private void setStartPositions() {
        ArrayList<Position> start = board.getStartPositions(players.size());
        int index = 0;
        for (Player player : players) {
            player.setCheckpoint(start.get(index));
            player.backToCheckpoint();
            index++;
        }
    }

    /*
    Commands
     */

    /**
     * Returns the cards in a players register back to the deck.
     * If it encounters a locked card, it leaves it be.
     */
    public void returnCardsToDeck() {
        for (Player player : players) {
            for (RegisterCard card : player.getProgrammedCards()) {
                if (!card.isLocked()) {
                    deck.addCard(card);
                }
            }
            player.emptyProgrammedCards();
        }
    }

    /*
    Getters
     */

    /**
     * Returns all players that are in the game.
     * @return A list containing all players in the game.
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Returns the game board that the game is played on.
     * @return The game board that the game is played on.
     */
    public GameBoard getBoard() {
        return board;
    }

    /**
     * Returns the card deck as it currently is in the game.
     * @return The card deck in the game.
     */
    public CardDeck getDeck() {
        return deck;
    }

    /**
     * Returns true if the game loop is still running.
     * @return True if the game is running, false if not.
     */
    public boolean isGameRunning() {
        return gameIsRunning;
    }

    @Override
    public void onEvent(EventTram.Event evt, Object o, Object o2) {
        if(EventTram.Event.VICTORY == evt) {
            gameIsRunning = false;
            System.out.println("Player: " + ((Player) o).getName() + " won the game");
            System.out.println("Fire event so that the GUI know that we should end the game");
        }
    }
}