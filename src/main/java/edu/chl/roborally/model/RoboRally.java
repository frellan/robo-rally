package edu.chl.roborally.model;

import edu.chl.roborally.controller.*;
import edu.chl.roborally.view.*;
import edu.chl.roborally.model.maps.*;

import java.util.*;

public class RoboRally {

    // Variables

    private Controller controller;
    private View view;
    private GameBoard gameBoard;
    public boolean running;
    public ArrayList<Player> players = new ArrayList<>();
    private int numbersOfPlayers;
    private CardDeck deck;

    // Constructor

    public RoboRally(Controller c, View v) {
        this.controller = c;
        this.view = v;

        newGame();
    }

    // Game logic

    public void newGame() {
        running = true;
        view.print("How many players?");

        numbersOfPlayers = controller.userInputInt();

        setPlayersNames();

        view.print("Starting new game with " + numbersOfPlayers + " players");

        for (Player p : players) {
            view.print("Player " + players.indexOf(p) + " : " + p.getName());
        }

        // Init all dependencies
        resetDeck();
        initMap("Blank");
        initStartPositions();
        // Start round
        initRound();
    }


    private void resetDeck() {
        if (deck == null) {
            deck = new CardDeck();
        } else {
            deck.reset();
        }
    }

    // Create a new map, input should be a name on the map
    private void initMap(String map) {
        if (map.equals("Blank")) {
            gameBoard = new BlankMap();
        }
    }

    // Set startpostions and put players on the board
    private void initStartPositions() {
        ArrayList<Position> start = gameBoard.getStartPosition(numbersOfPlayers);
        for (int i = 0; i<players.size(); i++) {
            players.get(i).setCheckpoint(start.get(i));
            System.out.println(players.get(i).getPlayerPos());
        }
    }

    // Start a round
    private void initRound() {
        deck.shuffle();
        // Set players Hand
        for (Player p : players) {
            // TODO check that 5 damgetokens is the limit, maybe it should be 4?
            if (p.getDamageTokens() > 5) {
                p.setHand(deck.getCards(9 - p.getDamageTokens()));
            } else {
                p.setHand(deck.getCards(9));
            }
        }

        for (Player p : players) {
            printCardOnHand(p);
        }

        chooseCardsToPlay();

        for (int i = 1; i <= 5; i++) {
            initTurn();
        }
    }
    // TODO maybe better to have this in the player class?
    private void printCardOnHand(Player p) {
        for(RegisterCard c : p.getHand()) {
            System.out.println(p.getHand().indexOf(c) + " " + c.toString() + " | ");
        }
    }
    private void chooseCardsToPlay() {
        System.out.println("Time to choose cards to play");
        for (Player p : players) {
            System.out.println(p.getName() + " time to choose five cards, type index of card in your hand to place it.");
            for (int i = 0; i<5; i++) {
                int j = i+1;
                System.out.print("Card number " + j  + " ");
                // TODO check so index that player choice are not out of bounds and not already picked
                p.setChoosenCards(p.getCardFromHand(controller.userInputInt()));
            }
            System.out.println(p.getName() + " have choosen the following cards: " + p.getChoosenCards());
        }

    }

    private void initTurn() {
        // TODO move players in order
        // TODO execute actions on game board
        // TODO update player status (life tokens, damage etc)
    }

    // Getters

    // Setters

    private void setPlayersNames() {
        for (int i = 1; i < numbersOfPlayers+1; i++) {
            System.out.println("Name on Player " + i + "?");
            players.add(new Player(i, controller.userInputString()));
        }
    }
}