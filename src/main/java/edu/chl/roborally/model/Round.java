package edu.chl.roborally.model;

import edu.chl.roborally.controller.Controller;
import edu.chl.roborally.view.View;

import java.util.ArrayList;

/**
 * Created by fredrikkindstrom on 31/03/15.
 */
public class Round {

    private RoboRally model;
    private Controller controller;
    private View view;
    private CardDeck deck;
    private ArrayList<Player> players;

    public Round(RoboRally r) {
        this.model = r;
        this.controller = model.getController();
        this.view = model.getView();
        this.deck = model.getDeck();
        this.players = model.getPlayers();
        startRound();
    }

    public void startRound() {
        deck.shuffle();
        dealCards();
        chooseCardsToPlay();
        for (int i = 0; i <= Constants.NUMBER_OF_TURNS-1; i++) {
            view.printHeader("Starting turn " + Integer.toString(i + 1));
            new Turn(model, i);
            view.printHeader("End turn " + Integer.toString(i + 1));
            view.print("Press enter to init next turn");
            controller.userInputString();
        }
    }

    //Help methods

    private void dealCards() {
        for (Player p : players) {
            // TODO check p damagetokens and return right nbr of cards
            p.setDealtCards(deck.getCards(9));
        }
    }

    private void chooseCardsToPlay() {
        for (Player p : players) {
            view.printDealtCards(p);
            view.print("");
            view.print("Choose 5 cards");
            view.print("Type the index of the card in the order you want to place them, separated by commas");
            String[] s = controller.userInputString().split(",");
            int index = 0;
            for (String value : s) {
                int nr = Integer.parseInt(value);
                p.setProgrammedCard(index, p.getDealtCard(nr));
                index++;
            }
            view.print(p.getName() + " have choosen the following cards:");
            view.printActiveCards(p);
            view.print("");
        }
    }
}
