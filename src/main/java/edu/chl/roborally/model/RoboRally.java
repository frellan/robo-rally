package edu.chl.roborally.model;

import edu.chl.roborally.controller.Controller;
import edu.chl.roborally.model.maps.*;

import java.util.*;

public class RoboRally {

    // Variables

    private GameBoard gameBoard;
    public ArrayList<Player> players = new ArrayList<>();
    private int numbersOfPlayers;
    private Controller controller;
    private CardDeck deck;

    // Constructor

    public RoboRally() {

    }

    // Game logic

    public void setController(Controller c) {
        this.controller = c;
    }

    public void newGame() {
        // TODO split up metohod in many methods

        System.out.println("How many players?");
        numbersOfPlayers = controller.userInputInt();
        setNames();
        System.out.println("Starting new game with " + numbersOfPlayers + " players");

        int j = 1;

        for (Player p : players) {
            System.out.println("Player " + j + " : " + p.getName());
            j++;
        }

        deck = new CardDeck();
        gameBoard = new BlankMap();

        initStartPositions();
        initRound();
    }

    private void setNames() {
        for (int i = 1; i < numbersOfPlayers+1; i++) {
            System.out.println("Name on Player " + i + "?");
            players.add(new Player(i, controller.userInputString()));
        }
    }

    private void initStartPositions() {
        ArrayList<Position> start = gameBoard.getStartPosition(numbersOfPlayers);
        for (int i = 0; i<players.size(); i++) {
            players.get(i).setCheckpoint(start.get(i));
        }
    }

    public void initRound() {
        deck.shuffle();
        for (Player p : players) {
            // TODO check p damagetokens and return right nbr of cards
            p.setHand(deck.getCards(9));
        }
        for (Player p : players) {
            for(RegisterCard c : p.getHand()) {
                System.out.println(c.toString() + " | ");
            }
        }
        // TODO wait for players to pick cards
        for (int i = 1; i <= 5; i++) {
            initTurn();
        }
    }

    public void initTurn() {
        // TODO move players in order
        // TODO execute actions on game board
        // TODO update player status (life tokens, damage etc)
    }

    public int getNumbersOfPlayers() {
        return numbersOfPlayers;
    }

    public void setNumbersOfPlayers(int i) {
        this.numbersOfPlayers = i;
    }
}