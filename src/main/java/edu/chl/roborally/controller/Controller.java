package edu.chl.roborally.controller;

import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.view.View;

import java.util.Scanner;

public class Controller {

	private RoboRally model;
    private View view;
    private boolean run;

	public Controller() {
        this.run = true;
        view = new View(model);
        play();
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
                if (model == null) {
                    model = new RoboRally(this,view);
                } else {
                    System.out.println("Game already running");
                }
                break;
            case "end":
                stopGame();
                break;
            case "help":
                System.out.println("Commands: 'new Game', 'end'");
                break;
            default:
                System.out.println(s + " not a command");
                break;
        }
    }
    private void stopGame() {
        this.run = false;
    }
    private void play(){
        System.out.println("ROBORALLY MADNESS!!!");
        System.out.println("type Help if you get stuck!");

        while(run) {
            actionFromInput(userInputString());
        }

        System.out.println("Game Ended");
    }

}