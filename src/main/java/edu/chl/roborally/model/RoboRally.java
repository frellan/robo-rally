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
 * Our model which holds the status of the game
 *
 */
public class RoboRally implements IEventHandler{

    // Variables
    private GameBoard gameBoard;
    private ArrayList<Player> players;
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

        EventTram.getInstance().register(this);
    }

    // Game logic

    private void resetDeck() {
        if (deck == null) {
            deck = new CardDeck();
        } else {
            deck.reset();
        }
    }

    public void returnCardsToDeck() {
        for (Player player : players) {
            for (RegisterCard card : player.getProgrammedCards()) {
                deck.addCard(card);
            }
            player.emptyProgrammedCards();
        }
    }

    public boolean shouldIContinue() {
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

    public ArrayList<String> getPlayerNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Player p : players) {
            names.add(p.getName());
        }
        return names;
    }

    @Override
    public void onEvent(EventTram.Event evt, Object o, Object o2) {
        if(EventTram.Event.VICTORY == evt) {
            isGameRunning = false;
            System.out.println("Player: " + (Player) o + " won the game");
            System.out.println("Fire event so that the GUI know that we should end the game");
        }
    }
}