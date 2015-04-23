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

    /**
     *
     */
    public abstract void menu();

    /**
     * Ask the UI for how many players a game should have
     * and sets the temporary names
     * @return An arraylist with names to the controller
     */
    public abstract ArrayList<String> getPlayerNames();

    /**
     *
     * @param maps String array with all the names on the maps
     * @return an int that the controller uses to create a map with.
     */
    public abstract int chooseMap(ArrayList<String> maps);

    public abstract void chooseCards(Player p);

    protected AppController getAppController() {
        return appController;
    }

}
