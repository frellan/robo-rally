package edu.chl.roborally.controller;

import edu.chl.roborally.EventTram;
import edu.chl.roborally.IEventHandler;
import edu.chl.roborally.model.*;
import edu.chl.roborally.model.maps.MapFactory;
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
    private RoboRally model;
    private MapFactory mapFactory;

    public GameController(UI ui) {
        this.mapFactory = new MapFactory();
        this.ui = ui;

        EventTram.getInstance().register(this);

    }

    /**
     * The initGame method setups up all the
     * dependencies for the game
     */
    private void initGame(){

        System.out.println("New roborally");
        this.model = new RoboRally();
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
                // TODO check end conditions befre new turn
                new Turn(model, i, ui);
            }
        }
    }

    private void createPlayers(ArrayList<String> names) {
        for (int i = 0; i<names.size(); i++) {
            model.setPlayer(new Player(i,names.get(i)));
        }
    }

    @Override
    public void onEvent(EventTram.Event evt, Object o) {
        if(evt == EventTram.Event.INIT_GAME) {
            this.initGame();
        } else if (evt == EventTram.Event.SET_MAP) {
            this.model.setMap(mapFactory.createMap((Integer) o));
        } else if (evt == EventTram.Event.SET_NAMES) {
            createPlayers((ArrayList<String>) o);
        }
    }
}
