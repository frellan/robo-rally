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
        model = r;
        controller = model.getController();
        view = model.getView();
        deck = model.getDeck();
        players = model.getPlayers();
        startRound();
    }

    public void startRound() {
        deck.shuffle();
        dealCards();
        chooseCardsToPlay();
        for (int i = 0; i <= Constants.NUMBER_OF_TURNS-1; i++) {
            new Turn(model,i);
        }
    }

    //Help methods

    private void dealCards() {
        for (Player p : players) {
            // TODO check p damagetokens and return right nbr of cards
            p.setDealtCards(deck.getCards(9));
        }
        printDealtCards();
    }

    private void chooseCardsToPlay() {
        for (Player p : players) {
            view.print(p.getName() + " choose 5 cards.");
            view.print("Type the index of the card in the order you want to place them, separated by commas");
            String[] s = controller.userInputString().split(",");
            int index = 0;
            for (String value : s) {
                int nr = Integer.parseInt(value);
                p.setProgrammedCard(index,p.getDealtCard(nr));
                System.out.println("added card" + index);
                index++;
            }
            view.print(p.getName() + " have choosen the following cards:");
            view.printActiveCards(p);
        }
    }

    //View

    private void printDealtCards() {
        for (Player p : players) {
            view.printDealtCards(p);
        }
    }
}
