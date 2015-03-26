package edu.chl.roborally.model;

import java.util.*;

public class RoboRally {
    private int numbersOfPlayers;
    public ArrayList<Player> players = new ArrayList<>();

    public void newGame() {

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