package edu.chl.roborally.controller;

import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.view.View;
import java.util.Scanner;

public class Controller {

	private final RoboRally roboRally;
    private final View view;
    private boolean run;

	public Controller(RoboRally roboRally, View view) {
		this.roboRally = roboRally;
        this.view = view;
        this.run = true;
        roboRally.setController(this);
        roboRally.setView(view);
        play();
	}

    public String userInputString() {
        Scanner in = new Scanner(System.in);
        System.out.print(">");
        String s = in.nextLine();
        return s;
    }

    public int userInputInt() {
        Scanner in = new Scanner(System.in);
        System.out.print(">");
        int i = in.nextInt();
        return i;
    }

    private void actionFromInput(String s) {
        s = s.toLowerCase();
        switch (s) {
            case "new game":
                roboRally.newGame();
                break;
            case "end":
                stopGame();
                break;
            case "help":
                System.out.println("Commands: 'New Game', 'End'");
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