package edu.chl.roborally.model;

import edu.chl.roborally.controller.Controller;
import edu.chl.roborally.view.View;

import java.util.ArrayList;

/**
 * Created by fredrikkindstrom on 31/03/15.
 */
public class Round {

    private Controller controller;
    private View view;

    private CardDeck deck;
    private ArrayList<Player> players;

    public Round(Controller c, View v, CardDeck d, ArrayList<Player> p) {
        controller = c;
        view = v;
        deck = d;
        players = p;
        initRound();
    }

    public void initRound() {
        deck.shuffle();
        dealCards();
        chooseCardsToPlay();

        for (int i = 1; i <= Constants.NUMBER_OF_TURNS; i++) {
            // initTurn();
        }
    }

    //Help methods

    private void dealCards() {
        for (Player p : players) {
            // TODO check p damagetokens and return right nbr of cards
            p.setDealtCards(deck.getCards(9));
        }
        printCardsOnHand();
    }

    private void chooseCardsToPlay() {
        view.print("Time to choose cards to play");
        for (Player p : players) {
            view.print(p.getName() + " choose 5 cards.");
            view.print("Type the index of the card in the order you want to place them, separated by commas");
            String[] s = controller.userInputString().split(",");
            for (String value : s) {
                p.setChoosenCard(p.getDealtCard(Integer.parseInt(value)));
            }
            view.print(p.getName() + " have choosen the following cards: " + p.getChoosenCards());
        }

    }

    //View

    private void printCardsOnHand() {
        for (Player p : players) {
            view.printCardOnHand(p);
        }
    }
}
