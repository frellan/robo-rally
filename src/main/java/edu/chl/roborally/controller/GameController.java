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
 * The GameController is the game master. The flow of the game
 * is controlled here.
 *
 */
public class GameController extends Thread implements IEventHandler {

    private RoboRally model = null;
    private MapFactory mapFactory;

    // Collect information to init model
    private Integer tempMapIndex = null;
    private Integer tempNbrOfRobots = null;
    private boolean mapReady = false;
    private boolean robotsReady = false;
    private int turnIndex = 0;
    private boolean newTurn = false;
    private boolean newRound = true;

    public GameController() {
        this.mapFactory = new MapFactory();
        EventTram.getInstance().register(this);
    }

    /**
     * The createModel method setups up all the
     * dependencies for the game
     */
    private void createModel() {
        if (tempNbrOfRobots != null && tempMapIndex != null && model == null) {
            this.model = new RoboRally(createRobots(tempNbrOfRobots), MapFactory.getInstance().getMap(tempMapIndex));
            EventTram.getInstance().publish(EventTram.Event.NEW_MODEL_CREATED, model, null);
        }
    }

    /**
     * runGame keeps track of rounds and turns
     * asks the model if the game
     * should continue
     */
    private void runGame() {
        if (!model.shouldIContinue()) {
            System.out.println("The model did not think that the game should continue");
        }
        else if (newRound) {
            EventTram.getInstance().publish(EventTram.Event.NEW_ROUND,null,null);
            new Round(model);
            newRound = false;
            turnIndex = 0;
        } else if (turnIndex < 5 && newTurn) {
            new Turn(model,turnIndex);
            EventTram.getInstance().publish(EventTram.Event.NEW_TURN,null,null);
            turnIndex++;
            newTurn = false;

            if(turnIndex == 5) {
                model.returnCardsToDeck();
                newRound = true;
            }
        }
    }

    private ArrayList<Player> createRobots(Integer j) {
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i<j; i++) {
            players.add(new Player(i, RobotFactory.getInstance().constructRobot(i)));
            System.out.println("Created new Player named: " + players.get(i).getName());
        }
        return players;
    }

    private boolean readyForGame() {
        if (mapReady && robotsReady) {
            EventTram.getInstance().publish(EventTram.Event.CREATE_MODEL, null, null);
            return true;
        }
        return false;
    }

    @Override
    public void onEvent(EventTram.Event evt, Object o, Object o2) {
        switch (evt) {
            case SET_ROBOTS:
                this.tempNbrOfRobots = (Integer) o;
                robotsReady = true;
                readyForGame();
                break;
            case SET_MAP:
                this.tempMapIndex = (Integer) o;
                mapReady = true;
                readyForGame();
                break;
            case CREATE_MODEL:
                this.createModel();
                break;
            case RUN_GAME:
                EventTram.getInstance().publish(EventTram.Event.SHOW_GAMEPANEL, null, null);
                newRound = true;
                this.runGame();
                break;
            case READY_FOR_NEW_TURN:
                newTurn = true;
                runGame();
                break;
        }
    }
}
