package edu.chl.roborally.view;

import edu.chl.roborally.controller.*;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.maps.GameBoard;
import edu.chl.roborally.model.maps.MapFactory;

import java.util.ArrayList;

/**
 * Created by fredrikkindstrom on 23/04/15.
 */
public abstract class UI {

    protected AppController appController;
    // private GameController gameController;

    public abstract void startMsg();

    public abstract void menu();

    public abstract ArrayList<String> getPlayerNames();

    public abstract int chooseMap(ArrayList<String> maps);

    public abstract void chooseCards(Player p);

    protected AppController getAppController() {
        return appController;
    }

}
