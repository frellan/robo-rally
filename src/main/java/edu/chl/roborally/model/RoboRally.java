package edu.chl.roborally.model;

import java.util.*;

public class RoboRally {

    // Variables

    private GameBoard gameBoard;
    private ArrayList<Player> players = new ArrayList<>();
    private int numbersOfPlayers;

    public RoboRally() {
        // TODO gameBoard = new GameBoard();
        // TODO create players
    }

    public void newGame() {
        // TODO place players in start positions on game board
        initRound();
    }

    public void initRound() {
        // TODO shuffle cards
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