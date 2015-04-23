package edu.chl.roborally.view;

import edu.chl.roborally.controller.*;

/**
 * Created by fredrikkindstrom on 23/04/15.
 */
public abstract class UI {

    private AppController appController;
    // private GameController gameController;

    public abstract void startMsg();

    public abstract void menu();

    protected AppController getAppController() {
        return appController;
    }


}
