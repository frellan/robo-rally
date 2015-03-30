package edu.chl.roborally.model;

import edu.chl.roborally.controller.Controller;

import java.util.*;

public class RoboRally {

    // Variables

    private GameBoard gameBoard;
    private ArrayList<Player> players = new ArrayList<>();
    private int numbersOfPlayers;
    private Controller controller;

    public RoboRally() {
        // TODO gameBoard = new GameBoard();
        // TODO create players
    }

    public void setController(Controller c) {
        this.controller = c;
    }

    public void newGame() {
        // TODO split up metohod in many methods

        System.out.println("How many players?");
        numbersOfPlayers = controller.userInputInt();
        setNames();
        System.out.println("Starting new game with " + numbersOfPlayers + " players");
        int i = 1;
        for (Player p : players) {
            System.out.println("Player " + i + " : " + p.getName());
            i++;
        }

        Position[] start = gameBoard.getStartPositions(numbersOfPlayers);
        for (int i = 0; i<players.size(); i++) {
            players.indexOf(i).setCheckpoint(start[i]);
        }

        initRound();
    }

    private void setNames() {
        for (int i = 1; i < getNumbersOfPlayers()+1; i++) {
            System.out.println("Name on Player " + i + "?");
            players.add(new Player(controller.userInputString()));
        }
    }

    public void initRound() {
        // TODO shuffle cards
        CardDeck deck = new CardDeck();
        deck.shuffle();
        // TODO deal cards to players
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