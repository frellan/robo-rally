package edu.chl.roborally.controller;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.model.maps.MapFactory;
import edu.chl.roborally.view.UI;

import java.util.ArrayList;

/**
 * Created by Pertta on 15-04-23.
 */
public class GameController {

    private UI ui;
    private RoboRally model;
    private MapFactory mapFactory;

    public GameController(UI ui) {
        mapFactory = new MapFactory();
        this.ui = ui;
        initGame();
    }

    private void initGame(){
        //TODO How many? Names? tempPlayers
        ArrayList<Player> tempPlayers = new ArrayList<>();
        for(int i = 0; i < ui.getPlayerNames().size(); i++){
            tempPlayers.add(new Player(i, ui.getPlayerNames().get(i)));
        }
        //TODO Map?
        int mapId = ui.chooseMap(mapFactory.getMaps());
        this.model = new RoboRally(tempPlayers, mapFactory.createMap(mapId));
    }
}
