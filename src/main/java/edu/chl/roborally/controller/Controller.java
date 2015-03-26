package edu.chl.roborally.controller;

import edu.chl.roborally.model.RoboRally;
import java.util.Scanner;

public class Controller {
	private final RoboRally roboRally;

    private boolean run;

	public static Controller create(RoboRally roboRally) {
		return new Controller(roboRally);
	}

	private Controller(RoboRally roboRally) {
		this.roboRally = roboRally;
        this.run = true;
        play();
	}

    private String userInputString() {
        Scanner in = new Scanner(System.in);
        System.out.print(">");
        String s = in.nextLine();
        return s;
    }

    private int userInputInt() {
        Scanner in = new Scanner(System.in);
        System.out.print(">");
        int i = in.nextInt();
        return i;
    }


    private void actionFromInput(String s) {
        if(s.equals("New Game")) {
            System.out.println("How many players?");
            roboRally.setNumbersOfPlayers(userInputInt());
            System.out.println("Starting new game with " + roboRally.getNumbersOfPlayers() + " players");
        }
        else if (s.equals("End") || s.equals("end")) {
            stopGame();
        }
        else if(s.equals("Help")) {
            System.out.println("Commands: 'New Game', 'End'");
        }
        else {
            System.out.println(s + " not a command");
        }
    }

    private void stopGame() {
        this.run = false;
    }

    private void play(){

        System.out.println("Running");
        System.out.println("ROBORALLY MADNESS!!!");
        System.out.println("type Help if you get stuck!");

        while(run) {
            actionFromInput(userInputString());
        }

        System.out.println("Game Ended");
    }

}
