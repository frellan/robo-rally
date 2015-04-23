package edu.chl.roborally.controller;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.view.UI;

import java.util.ArrayList;

/**
 * Created by Pertta on 15-04-23.
 */
public class GameController {

    private UI ui;
    private RoboRally model;

    public GameController(UI ui) {
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
        ui.chooseMap();
        this.model = new RoboRally(tempPlayers, gameBoard);
    }
}
