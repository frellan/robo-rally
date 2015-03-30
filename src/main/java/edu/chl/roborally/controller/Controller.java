package edu.chl.roborally.controller;

import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.view.View;

import java.nio.ReadOnlyBufferException;
import java.util.Scanner;

public class Controller {

	private RoboRally roboRally;
    private final View view;
    private boolean run;

	public Controller(View view) {
        this.view = view;
        this.run = true;
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
                if (!roboRally.running) {
                    roboRally = new RoboRally(this, this.view);
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