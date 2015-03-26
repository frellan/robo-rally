package edu.chl.roborally.model;

import java.util.*;

public class RoboRally {
    private int numbersOfPlayers;
    private ArrayList<Player> players = new ArrayList<Player>();

    protected void newGame() {
        for (int i = 0; i < numbersOfPlayers; i++) {
            players.add(new Player());
        }
    }

    protected int getNumbersOfPlayers() {
        return numbersOfPlayers;
    }

    protected void setNumbersOfPlayers(int i) {
        this.numbersOfPlayers = i;
    }
}
