package edu.chl.roborally.model;

import edu.chl.roborally.controller.AppController;
import edu.chl.roborally.view.Terminal;

import java.util.ArrayList;

/**
 * Created by fredrikkindstrom on 31/03/15.
 */
public class Round {

    private RoboRally model;
    private AppController appController;
    private Terminal terminal;
    private CardDeck deck;
    private ArrayList<Player> players;

    final int STANDARD_CARD_AMOUNT = 9;

    public Round(RoboRally r) {
        this.model = r;
        this.appController = model.getAppController();
        this.terminal = model.getTerminal();
        this.deck = model.getDeck();
        this.players = model.getPlayers();
        startRound();
    }

    public void startRound() {
        deck.shuffle();
        dealCards();
        chooseCardsToPlay();
        putBackPlayers();
        for (int i = 0; i <= Constants.NUMBER_OF_TURNS-1; i++) {
            terminal.printHeader("Starting turn " + Integer.toString(i + 1));
            new Turn(model, i);
            terminal.printHeader("End turn " + Integer.toString(i + 1));
            terminal.print("Press enter to init next turn");
            appController.userInputString();
        }
    }

    //Help methods

    /**
    * If player is dead, we put them back on the last checkpoint
    * when we newGame a new round
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
            if (p.isPowerDown() == true) {
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
            terminal.printDealtCards(p);
            terminal.print("");
            terminal.print("Choose 5 cards");
            terminal.print("Type the index of the card in the order you want to place them, separated by commas");
            String[] s = appController.userInputString().split(",");
            int index = 0;
            for (String value : s) {
                int nr = Integer.parseInt(value);
                p.setProgrammedCard(index, p.getDealtCard(nr));
                index++;
            }
            terminal.print(p.getName() + " have choosen the following cards:");
            terminal.printActiveCards(p);
            terminal.print("");
        }
    }
}
