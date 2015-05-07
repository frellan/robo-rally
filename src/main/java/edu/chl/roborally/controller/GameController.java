package edu.chl.roborally.controller;

import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.IEventHandler;
import edu.chl.roborally.model.*;
import edu.chl.roborally.model.maps.MapFactory;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.view.UI;
import java.util.ArrayList;

/**
 * Created by Pertta on 15-04-23.
 *
 * The GameController is the game master. The flow of the game
 * is controlled here.
 *
 */
public class GameController implements IEventHandler {

    private UI ui;
    private RoboRally model = null;
    private MapFactory mapFactory;

    // Collect information to init model
    private ArrayList<String> tempNames = null;
    private String tempMap = null;

    private boolean mapReady = false;
    private boolean nameReady = false;

    public GameController(UI ui) {
        this.mapFactory = new MapFactory();
        this.ui = ui;

        EventTram.getInstance().register(this);

    }

    /**
     * The initGame method setups up all the
     * dependencies for the game
     */
    private void initGame() {
        if (tempNames != null && tempMap != null && model == null) {
            this.model = new RoboRally(createPlayers(tempNames), mapFactory.createMap(tempMap));
            System.out.println("New roborally created");
            EventTram.getInstance().publish(EventTram.Event.NEW_MODEL, model);
        }

        System.out.println("Could not start a new model");
    }

    /**
     * runGame keeps track of rounds and turns
     * asks the model if the game
     * should continue
     */
    private void runGame() {
        //TODO Ask model if i should run the game
        while(model.shouldIContinue()) {

            new Round(model, ui);

            for (int i = 1; i< Constants.NUMBER_OF_TURNS; i++) {
                // TODO check end conditions before new turn
                new Turn(model, i, ui);
            }
        }
    }

    private ArrayList<Player> createPlayers(ArrayList<String> names) {
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i<names.size(); i++) {
            players.add(new Player(i, names.get(i)));
            System.out.println("Created new Player named: " + names.get(i));
        }
        return players;
    }

    private boolean readyForGame() {
        if (mapReady && nameReady) {
            EventTram.getInstance().publish(EventTram.Event.INIT_GAME, null);
            return true;
        }
        return false;
    }

    @Override
    public void onEvent(EventTram.Event evt, Object o) {
        if(evt == EventTram.Event.INIT_GAME) {
            this.initGame();
        } else if (evt == EventTram.Event.SET_MAP) {
            this.tempMap = (String) o;
            mapReady = true;
            readyForGame();
        } else if (evt == EventTram.Event.SET_NAMES) {
            this.tempNames = (ArrayList<String>) o;
            nameReady = true;
            readyForGame();
        } else if (evt == EventTram.Event.RUN_GAME) {
            this.runGame();
        }
    }
}
