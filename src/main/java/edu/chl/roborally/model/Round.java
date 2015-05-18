package edu.chl.roborally.model;

import edu.chl.roborally.model.cards.CardDeck;
import edu.chl.roborally.model.cards.RegisterCard;
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
    private boolean nextPlayer = false;
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
        System.out.println("Number of players " + model.getPlayers().size());
        if (chooserIndex < model.getPlayers().size()) {
            chooser = model.getPlayers().get(chooserIndex);
            EventTram.getInstance().publish(EventTram.Event.CHOOSE_CARDS,chooser, null);
        } else {
            System.out.println("All Players have choosen their cards, fire event");
            EventTram.getInstance().publish(EventTram.Event.NEW_TURN, null, null);
        }
    }

    @Override
    public void onEvent(EventTram.Event evt, Object o, Object o2) {
        if (EventTram.Event.PLAYER_CHOOSEN_CARDS == evt) {
            ArrayList<RegisterCard> cards = (ArrayList<RegisterCard>) o;
            for (int i = 0; i<cards.size(); i++) {
                chooser.setProgrammedCard(i,cards.get(i));
            }
            chooserIndex++;
            chooseCardsToPlay();
        }
    }
}
