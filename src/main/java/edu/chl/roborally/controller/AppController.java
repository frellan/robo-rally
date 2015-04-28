package edu.chl.roborally.controller;

import edu.chl.roborally.view.Terminal;
import edu.chl.roborally.view.UI;
import edu.chl.roborally.view.gui.GUIController;

public class AppController {

    /**
     * @var ui
     *  The ui variable holds the chosen user interface
     */
    private final UI ui;
    private GameController gameController;
    private boolean appRunning;

	public AppController() {

        this.appRunning = true;
        ui = new GUIController(this);
        ui.menu();
	}

    public boolean isAppRunning() {
        return appRunning;
    }

    public void initGameController() {
        if (gameController == null) {
            gameController = new GameController(ui);
        } else {
            System.out.println("Game already running");
        }
    }
    public void endGame() {
        this.appRunning = false;
    }

}