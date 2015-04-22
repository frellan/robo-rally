package edu.chl.roborally.model;

import edu.chl.roborally.controller.*;
import edu.chl.roborally.model.maps.BlankMap;
import edu.chl.roborally.model.maps.GameBoard;
import edu.chl.roborally.model.maps.VaultMap;
import edu.chl.roborally.view.*;

import java.util.*;

public class RoboRally {

    // Variables

    private Controller controller;
    private MainWindow mainWindow;
    private GameBoard gameBoard;
    public ArrayList<Player> players = new ArrayList<>();
    private int numbersOfPlayers;
    private CardDeck deck;

    // Constructor

    public RoboRally(Controller c, MainWindow v) {
        this.controller = c;
        this.mainWindow = v;

        newGame();
    }

    // Game logic

    private void newGame() {
        mainWindow.print("How many players?");
        numbersOfPlayers = controller.userInputInt();
        setPlayerNames();
        mainWindow.print("Starting new game with " + numbersOfPlayers + " players");
        mainWindow.print("------------------------------");

        // Init all dependencies
        mainWindow.initGameScreen(this);
        resetDeck();
        initMap();
        initStartPositions();
        mainWindow.printHeader("Starting round");

        // Start round
        new Round(this);
    }

    private void resetDeck() {
        if (deck == null) {
            deck = new CardDeck();
        } else {
            deck.reset();
        }
    }

    // Create a new map, input should be a name on the map
    private void initMap() {
        mainWindow.print("Choose Board");
        mainWindow.print("Type 1: Blank Map");
        mainWindow.print("Type 2: Vault Map");
        int input = controller.userInputInt();
        if (input == 1) {
            gameBoard = new BlankMap();
        } else if (input == 2) {
            gameBoard = new VaultMap();
        }
        // Print Board
        gameBoard.printBoard();
    }

    // Set startpostions and put players on the board
    private void initStartPositions() {
        ArrayList<Position> start = gameBoard.getStartPositions(numbersOfPlayers);
        int index = 0;
        for (Player player : players) {
            player.setCheckpoint(start.get(index));
            player.backToCheckpoint();
            index++;
            System.out.println(player.getName() + " is at " + player.getPosition());
        }
    }

    // Getters

    public Controller getController() {
        return controller;
    }

    public MainWindow getMainWindow() {
        return mainWindow;
    }

    public CardDeck getDeck() {
        return deck;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    // Setters

    private void setPlayerNames() {
        for (int i = 1; i <= numbersOfPlayers; i++) {
            System.out.println("Name on Player " + i + "?");
            players.add(new Player(i,controller.userInputString()));
        }
    }
}