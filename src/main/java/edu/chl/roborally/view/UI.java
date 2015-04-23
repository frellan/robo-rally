package edu.chl.roborally.view;

import edu.chl.roborally.controller.*;
import edu.chl.roborally.model.maps.GameBoard;

import java.util.ArrayList;

/**
 * Created by fredrikkindstrom on 23/04/15.
 */
public abstract class UI {

    private AppController appController;
    // private GameController gameController;

    public abstract void startMsg();

    public abstract void menu();

    public abstract ArrayList<String> getPlayerNames();

    public abstract GameBoard chooseMap();

    protected AppController getAppController() {
        return appController;
    }

}
