package edu.chl.roborally.controller;

/**
 * Controller class that initiates the entire application, is called from the main method.
 */
public class AppController {

    private GameController gameController;

	public AppController() {
        initGameController();
	}

    private void initGameController() {
        if (gameController == null) {
            gameController = new GameController();
        } else {
            System.out.println("Game already running");
        }
    }

}