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
 */

public class Round implements IEventHandler {

    private RoboRally model;
    private CardDeck deck;
    private ArrayList<Player> players;
    final int STANDARD_CARD_AMOUNT = 9;
    private Player chooser;
    private int chooserIndex = 0;

    public Round(RoboRally r) {
        this.model = r;
        this.deck = model.getDeck();
        this.players = model.getPlayers();
        EventTram.getInstance().register(this);
        startRound();
    }

    /*
    Main method
     */
    public void startRound() {
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
    private void putBackPlayers() {
        for (Player p : players) {
            if (!p.isKaput() && p.isDead()) {
                p.setStatus(Constants.Status.ALIVE);
                p.backToCheckpoint();
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
    private void makePlayerPickCards() {
        if (chooserIndex < players.size()) {
            chooser = model.getPlayers().get(chooserIndex);
            EventTram.getInstance().publish(EventTram.Event.PICK_CARDS,chooser, null);
        } else {
            prepareForFirstTurn();
        }
    }
    private void prepareForFirstTurn() {
        for (Player player : players) {
            // TODO
        }
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
