package edu.chl.roborally.model;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.IEventHandler;

import java.util.ArrayList;

/**
 * Created by fredrikkindstrom on 31/03/15.
 */

public class Round implements IEventHandler {

    private RoboRally model;
    private CardDeck deck;
    private ArrayList<Player> players;

    final int STANDARD_CARD_AMOUNT = 9;

    public Round(RoboRally r) {
        this.model = r;
        this.deck = model.getDeck();
        this.players = model.getPlayers();

        EventTram.getInstance().register(this);

        startRound();
    }

    public void startRound() {
        deck.shuffle();
        dealCards();
        putBackPlayers();
        chooseCardsToPlay();
    }

    //Help methods

    /**
    * If player is dead, we put them back on the last checkpoint
    * when we initGameController a new round
    */
    private void putBackPlayers() {
        for (Player p : players) {
            if(!p.isAlive()) {
                p.backToCheckpoint();
                p.setStatus(Constants.Status.ALIVE);
            }
        }
    }

    private void dealCards() {
        for (Player p : players) {
            if (p.isPowerDown()) {
                p.setDealtCards(deck.getCards(0));
            } else {
                // Number of cards given to player are reduced by the number of damagetokens
                int nbrOfCardsGivenToPlayer = STANDARD_CARD_AMOUNT - p.getDamageTokens();
                p.setDealtCards(deck.getCards(nbrOfCardsGivenToPlayer));
            }
        }
    }

    private void chooseCardsToPlay() {
        for (Player player : players) {
            EventTram.getInstance().publish(EventTram.Event.CHOOSE_CARDS, player);
        }
    }

    @Override
    public void onEvent(EventTram.Event evt, Object o) {
        if (EventTram.Event.PLAYER_CHOOSE_CARDS == evt) {
        }
    }
}
