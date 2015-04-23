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
    private boolean appIsRunning;

	public AppController() {
        this.appIsRunning = true;

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
        this.appIsRunning = false;
    }
    // Console methods
    private void welcomeMessage(){
        System.out.println("ROBORALLY MADNESS!!!");
        System.out.println("type Help if you get stuck!");

        while(appIsRunning) {
            actionFromInput(userInputString());
        }

        System.out.println("Game Ended");
    }
    public String userInputString() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
    public int userInputInt() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
    private void actionFromInput(String s) {
        switch (s.toLowerCase()) {
            case "new game":
                newGame();
                break;
            case "end":
                endGame();
                break;
            case "help":
                System.out.println("Commands: 'new game', 'end'");
                break;
            default:
                System.out.println(s + " not a command");
                break;
        }
    }

}