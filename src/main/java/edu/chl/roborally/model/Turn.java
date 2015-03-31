package edu.chl.roborally.model;

import edu.chl.roborally.controller.Controller;
import edu.chl.roborally.model.cards.RegisterCard;
import edu.chl.roborally.model.cards.RegisterCardCompare;
import edu.chl.roborally.model.gameactions.GameAction;
import edu.chl.roborally.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by henriknilson on 31/03/15.
 */
public class Turn {

    private RoboRally model;
    private Controller controller;
    private View view;
    private CardDeck deck;
    private ArrayList<Player> players;
    private ArrayList<RegisterCard> activeCards;
    private Map<RegisterCard,Player> activeCardPlayer = new HashMap<>();

    private int index;

    public Turn(RoboRally r, int index) {
        model = r;
        controller = model.getController();
        view = model.getView();
        deck = model.getDeck();
        players = model.getPlayers();
        this.index = index;
        startTurn();
    }

    private void startTurn() {
        revealProgrammedCards();
        sortActiveCards();
        executeActiveCards();
    }

    private void revealProgrammedCards() {
        for (Player player : players) {
            RegisterCard card = player.getProgrammedCard(index);
            card.setHidden(false);
            activeCards.add(card);
            activeCardPlayer.put(card,player);
        }
    }

    private void sortActiveCards() {
        Collections.sort(activeCards, new RegisterCardCompare());
    }

    private void executeActiveCards() {
        for (RegisterCard card : activeCards) {
            Player player = activeCardPlayer.get(card);
            // c.doAction(p);
        }
    }
}
