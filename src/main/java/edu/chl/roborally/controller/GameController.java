package edu.chl.roborally.controller;

import edu.chl.roborally.model.robot.RobotFactory;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.IEventHandler;
import edu.chl.roborally.model.*;
import edu.chl.roborally.model.maps.MapFactory;
import java.util.ArrayList;

/**
 * Created by Pertta on 15-04-23.
 *
 * This class is the game master. The flow of the game is controlled here.
 */
public class GameController extends Thread implements IEventHandler {

    private RoboRally model = null;
    private MapFactory mapFactory;

    private Integer tempMapIndex = null;
    private Integer tempNbrOfPlayers = null;
    private int turnIndex = 0;
    private boolean readyForNewTurn = false;
    private boolean readyForNewRound = true;

    /**
     * Creates the class and registers it as a listener for events coming from the model and view packages.
     */
    public GameController() {
        this.mapFactory = new MapFactory();
        EventTram.getInstance().register(this);
    }

    /*
    Class methods
     */

    /**
     * Takes the number of players to be created and then creates that many new players.
     * @param amountOfPlayers The amount of players to be created.
     * @return A list containing the players created.
     */
    private ArrayList<Player> createPlayers(Integer amountOfPlayers) {
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < amountOfPlayers; i++) {
            players.add(new Player(i, RobotFactory.getInstance().constructRobot(i)));
            System.out.println("NEW PLAYER NAMED: " + players.get(i).getName());
        }
        return players;
    }

    /**
     * Checks if there is enough data to create a model and then creates it if there is.
     */
    private void tryToCreateModel() {
        if (tempNbrOfPlayers != null && tempMapIndex != null && model == null) {
            this.model = new RoboRally(createPlayers(tempNbrOfPlayers), MapFactory.getInstance().getMap(tempMapIndex));
            EventTram.getInstance().publish(EventTram.Event.MODEL_CREATED, model, null);
        }
    }

    /**
     * Runs the game loop and keeps track of rounds and turns.
     * When a round is over it returns the cards to the deck etc.
     */
    private void runGame() {
        if (!model.isGameRunning()) {
            System.out.println("Model did not think that the game should continue");
        } else if (readyForNewRound) {
            EventTram.getInstance().publish(EventTram.Event.NEW_ROUND,null,null);
            new Round(model);
            readyForNewRound = false;
            turnIndex = 0;
        } else if (turnIndex < 5 && readyForNewTurn) {
            new Turn(model, turnIndex);
            EventTram.getInstance().publish(EventTram.Event.NEW_TURN,null,null);
            turnIndex++;
            readyForNewTurn = false;

            if (turnIndex == 5) {
                model.returnCardsToDeck();
                readyForNewRound = true;
            }
        }
    }

    @Override
    public void onEvent(EventTram.Event evt, Object o, Object o2) {
        switch (evt) {
            case PLAYERS_SELECTED:
                tempNbrOfPlayers = (Integer) o;
                tryToCreateModel();
                break;
            case MAP_SELECTED:
                tempMapIndex = (Integer) o;
                tryToCreateModel();
                break;
            case START_GAME:
                EventTram.getInstance().publish(EventTram.Event.SHOW_GAMEPANEL, null, null);
                readyForNewRound = true;
                runGame();
                break;
            case READY_FOR_NEW_TURN:
                readyForNewTurn = true;
                runGame();
                break;
        }
    }
}
