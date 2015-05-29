package edu.chl.roborally.model;

import edu.chl.roborally.model.cards.CardDeck;
import edu.chl.roborally.model.cards.RegisterCard;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.IEventHandler;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by fredrikkindstrom on 31/03/15.
 *
 * This part of the model represents and runs a round.
 * It does all the things that need to be done with the game logic for a round to work correctly.
 */
public class Round implements IEventHandler {

    private final int STANDARD_CARD_AMOUNT = 9;
    private final RoboRally model;
    private final CardDeck deck;
    private final ArrayList<Player> players;
    private Player chooser;
    private int chooserIndex = 0;

    /**
     * Creates and starts the round tasks.
     * @param model The top model class of the current game that holds useful information.
     */
    public Round(RoboRally model) {
        this.model = model;
        this.deck = model.getDeck();
        this.players = model.getPlayers();
        EventTram.getInstance().register(this);
        startRound();
    }

    /*
    Main method
     */

    /**
     * Main method that calls all the help methods to perform the tasks needed for a round.
     * Prints to the console that a new round has begun.
     */
    private void startRound() {
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, Constants.UNDER_LINE + "\n" + "New Round" + "\n"
                + Constants.UNDER_LINE + "\n", Color.MAGENTA);
        putBackPlayers();
        deck.shuffle();
        dealCards();
        makePlayerPickCards();
    }

    /*
    Help methods
     */

    /**
     * Moves all players back to their checkpoint positions.
     * If they have died during the previous round they are revived
     * and put back to their checkpoints. Unless they are kaput.
     */
    private void putBackPlayers() {
        for (Player p : players) {
            if (!p.isKaput() && p.isDead()) {
                p.setStatus(Constants.Status.ALIVE);
                p.setDirection(Constants.Directions.EAST);
                p.backToCheckpoint();
            }
        }
    }

    /**
     * Loops through the players and gives them all the correct amount of cards.
     * If a player has damage any tokens the amount is reduced by the number of tokens.
     * If a player is powered down no cards are dealt to that player.
     */
    private void dealCards() {
        for (Player p : players) {
            if (p.isPowerDown()) {
                p.setDealtCards(deck.getCards(0));
            } else {
                int nbrOfCardsGivenToPlayer = STANDARD_CARD_AMOUNT - p.getDamageTokens();
                p.setDealtCards(deck.getCards(nbrOfCardsGivenToPlayer));
            }
        }
    }

    /**
     * Makes all players pick which cards they want to program to their register.
     * This occurs one player at a time.
     */
    private void makePlayerPickCards() {
        if (chooserIndex < players.size()) {
            chooser = model.getPlayers().get(chooserIndex);
            EventTram.getInstance().publish(EventTram.Event.PICK_CARDS, chooser, null);
        } else {
            prepareForFirstTurn();
        }
    }

    /**
     * This is the last method that runs before the round is over.
     * It tells the game controller that the model is finished with this round.
     */
    private void prepareForFirstTurn() {
        EventTram.getInstance().publish(EventTram.Event.READY_FOR_NEW_TURN, null, null);
        EventTram.getInstance().unRegister(this);
    }

    @Override
    public void onEvent(EventTram.Event evt, Object o, Object o2) {
        if (EventTram.Event.PLAYER_PICKED_CARDS == evt) {
            ArrayList<RegisterCard> cards = (ArrayList<RegisterCard>) o;
            for (int i = 0; i<cards.size(); i++) {
                chooser.setProgrammedCard(i,cards.get(i));
            }
            chooserIndex++;
            makePlayerPickCards();
        }
    }
}
