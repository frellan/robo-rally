package edu.chl.roborally.model;

import java.util.*;

public class RoboRally {
    private int numbersOfPlayers;
    public ArrayList<Player> players = new ArrayList<>();

    public void newGame() {

    }

    public int getNumbersOfPlayers() {
        return numbersOfPlayers;
    }

    public void setNumbersOfPlayers(int i) {
        this.numbersOfPlayers = i;
    }
}