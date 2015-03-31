package edu.chl.roborally.model;

import edu.chl.roborally.controller.Controller;
import edu.chl.roborally.model.cards.RegisterCard;
import edu.chl.roborally.view.View;

import java.util.ArrayList;
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
    }

    private void revealProgrammedCards() {
        for (Player p : players) {
            RegisterCard c = p.getProgrammedCard(index);
            c.setHidden(false);
            activeCards.add(c);
            activeCardPlayer.put(c,p);
        }
    }

    private void sortActiveCards() {
        java.util.Collections.sort(activeCards,);
    }
}
