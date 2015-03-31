package edu.chl.roborally.model;

import edu.chl.roborally.controller.Controller;
import edu.chl.roborally.view.View;

import java.util.ArrayList;

/**
 * Created by henriknilson on 31/03/15.
 */
public class Turn {

    private Controller controller;
    private View view;
    private GameBoard gameBoard;
    public ArrayList<Player> players = new ArrayList<>();
    private CardDeck deck;

    public Turn(Controller c, View v, GameBoard g, ArrayList<Player> p, CardDeck d) {
        this.controller = c;
        this.view = v;
        this.gameBoard = g;
        this.players = p;
        this.deck = d;

        initTurn();
    }

    private initTurn() {
        // TODO Loop the players and their cards 
    }
}
