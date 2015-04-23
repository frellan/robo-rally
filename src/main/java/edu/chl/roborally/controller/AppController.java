package edu.chl.roborally.controller;

import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.view.MainWindow;
import edu.chl.roborally.view.Terminal;
import edu.chl.roborally.view.UI;

import java.util.Scanner;

public class AppController {

    private final UI ui = new Terminal();
	private RoboRally model;
    private MainWindow mainWindow;
    private Terminal terminal;
    private boolean appRunning;

	public AppController() {
        this.appRunning = true;
        ui.menu();
	}

    public boolean isAppRunning() {
        return appRunning;
    }

    public void newGame() {
        if (model == null) {
            model = new RoboRally(this,terminal);
            mainWindow.switchToGameScreen(model);
        } else {
            System.out.println("Game already runnings");
        }
    }
    public void endGame() {
        this.appRunning = false;
    }

}