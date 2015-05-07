package edu.chl.roborally.model;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.view.UI;

import java.util.ArrayList;

/**
 * Created by fredrikkindstrom on 31/03/15.
 */
public class Round {

    private RoboRally model;
    private UI ui;
    private CardDeck deck;
    private ArrayList<Player> players;

    final int STANDARD_CARD_AMOUNT = 9;

    public Round(RoboRally r, UI ui) {
        this.model = r;
        this.ui = ui;
        this.deck = model.getDeck();
        this.players = model.getPlayers();
        startRound();
    }

    public void startRound() {
        deck.shuffle();
        dealCards();
        chooseCardsToPlay();
        putBackPlayers();
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
        for (Player p : players) {
            ui.chooseCards(p);
        }
    }
}
