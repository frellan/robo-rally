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
 */
public class RoboRally implements IEventHandler{

    private GameBoard gameBoard;
    private ArrayList<Player> players;
    private CardDeck deck;
    private boolean gameRunning;

    public RoboRally(ArrayList<Player> players, GameBoard map) {
        this.players = players;
        this.gameBoard = map;
        EventTram.getInstance().register(gameBoard);
        // Init all dependencies
        resetDeck();
        //set start positions
        setStartPositions();
        //Init game
        this.gameRunning = true;

        EventTram.getInstance().register(this);
    }

    /*
    Game logic
     */
    private void resetDeck() {
        if (deck == null) {
            deck = new CardDeck();
        } else {
            deck.reset();
        }
    }
    private void setStartPositions() {
        ArrayList<Position> start = gameBoard.getStartPositions(players.size());
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
    public void returnCardsToDeck() {
        for (Player player : players) {
            for (RegisterCard card : player.getProgrammedCards()) {
                deck.addCard(card);
            }
            player.emptyProgrammedCards();
        }
    }

    /*
    Getters
     */
    public boolean isGameRunning() {
        return gameRunning;
    }
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

    /*
    Events
     */
    @Override
    public void onEvent(EventTram.Event evt, Object o, Object o2) {
        if(EventTram.Event.VICTORY == evt) {
            gameRunning = false;
            System.out.println("Player: " + (Player) o + " won the game");
            System.out.println("Fire event so that the GUI know that we should end the game");
        }
    }
}