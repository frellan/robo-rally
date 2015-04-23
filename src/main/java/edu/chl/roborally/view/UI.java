package edu.chl.roborally.view;

import edu.chl.roborally.controller.*;
import edu.chl.roborally.model.Player;

import java.util.ArrayList;

/**
 *
 * This abstract class acts as a blueprint for
 * how the user interface should work.
 *
 * Created by fredrikkindstrom on 23/04/15.
 */
public abstract class UI {

    protected AppController appController;

    public UI(AppController appController) {
        this.appController = appController;
    }

    public abstract void startMsg();

    public abstract void menu();

    public abstract ArrayList<String> getPlayerNames();

    public abstract int chooseMap(ArrayList<String> maps);

    public abstract void chooseCards(Player p);

    protected AppController getAppController() {
        return appController;
    }

}
