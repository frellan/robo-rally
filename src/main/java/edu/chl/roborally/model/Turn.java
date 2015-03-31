package edu.chl.roborally.model;

import edu.chl.roborally.controller.Controller;
import edu.chl.roborally.view.View;

import java.util.ArrayList;

/**
 * Created by henriknilson on 31/03/15.
 */
public class Turn {

    private RoboRally model;
    private Controller controller;
    private View view;
    private CardDeck deck;
    private ArrayList<Player> players;

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
        // TODO Loop the players and their cards
    }
}
