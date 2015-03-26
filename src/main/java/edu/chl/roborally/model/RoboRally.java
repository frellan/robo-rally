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

    public int getNumbersOfPlayers() {
        return numbersOfPlayers;
    }

    public void setNumbersOfPlayers(int i) {
        this.numbersOfPlayers = i;
    }
}
