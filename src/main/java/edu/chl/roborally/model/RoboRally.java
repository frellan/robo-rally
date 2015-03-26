package edu.chl.roborally.model;

import java.util.*;

public class RoboRally {
    private int numbersOfPlayers;
    private ArrayList<Player> players = new ArrayList<>();

    public void newGame() {
        for (int i = 0; i < numbersOfPlayers; i++) {
            players.add(new Player("Kalle2"));
        }
    }

    public void initRound() {
        // TODO shuffle cards
        // TODO deal cards to players
        // TODO wait for players to pick cards
        initTurn();
        // Wait
        initTurn();
    }

    public void initTurn() {

    }

    public int getNumbersOfPlayers() {
        return numbersOfPlayers;
    }

    public void setNumbersOfPlayers(int i) {
        this.numbersOfPlayers = i;
    }
}
