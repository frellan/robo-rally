package edu.chl.roborally.controller;

import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.model.gameactions.GameAction;
import edu.chl.roborally.view.MainWindow;
import edu.chl.roborally.view.TerminalOutput;

import java.util.Scanner;

public class Controller {

	private RoboRally model;
    private MainWindow mainWindow;
    private TerminalOutput terminal;
    private GameController gameController;
    private boolean runApplication;

	public Controller() {
        mainWindow = new MainWindow(this);
        terminal = new TerminalOutput(this);
        this.runApplication = true;
        welcomeMessage();
	}

    public void newGame() {
        if (gameController == null) {
            gameController = new GameController(terminal);
            mainWindow.initGameScreen(model);
        } else {
            System.out.println("Game already running");
        }
    }

    public void endApplication() {
        this.runApplication = false;
        System.exit(0);
    }

    // Console methods
    private void welcomeMessage(){
        System.out.println("ROBORALLY MADNESS!!!");
        System.out.println("type Help if you get stuck!");

        while(runApplication) {
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
                endApplication();
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