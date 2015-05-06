package edu.chl.roborally.model;

import edu.chl.roborally.model.maps.GameBoard;
import edu.chl.roborally.view.*;

import java.util.*;

/**
 * Created by Henrik.
 *
 * Our model which holds the status of the game
 *
 */
public class RoboRally {

    // Variables
    private GameBoard gameBoard;
    public ArrayList<Player> players;
    private CardDeck deck;
    private boolean isGameRunning;

    // Constructor

    public RoboRally(ArrayList<Player> players, GameBoard map) {
        this.players = players;
        this.gameBoard = map;
        // Init all dependencies
        resetDeck();
        //set start positions
        setStartPositions();
        //Init game
        this.isGameRunning = true;
    }

    // Game logic

    private void resetDeck() {
        if (deck == null) {
            deck = new CardDeck();
        } else {
            deck.reset();
        }
    }

    public boolean shouldIContinue() {
        //TODO Check end conditions
        return isGameRunning;
    }

    // Set startpostions and put players on the board
    private void setStartPositions() {
        ArrayList<Position> start = gameBoard.getStartPositions(players.size());
        int index = 0;
        for (Player player : players) {
            player.setCheckpoint(start.get(index));
            player.backToCheckpoint();
            index++;
            System.out.println(player.getName() + " is at " + player.getPosition());
        }
    }

    // Getters

    public CardDeck getDeck() {
        return deck;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }
}