package edu.chl.roborally.controller;

public class AppController {

    private GameController gameController;
    private boolean appRunning;

	public AppController() {

        this.appRunning = true;
        initGameController();

	}

    public boolean isAppRunning() {
        return appRunning;
    }

    private void initGameController() {
        if (gameController == null) {
            gameController = new GameController();
        } else {
            System.out.println("Game already running");
        }
    }
    public void endGame() {
        this.appRunning = false;
    }

}