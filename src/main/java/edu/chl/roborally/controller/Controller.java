package edu.chl.roborally.controller;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.view.View;

import java.util.Scanner;

    public class Controller {
	private final RoboRally roboRally;
    private final View view;

    private boolean run;

	public static Controller create(RoboRally roboRally, View view) {

        return new Controller(roboRally, view);
	}

	private Controller(RoboRally roboRally, View view) {
		this.roboRally = roboRally;
        this.view = view;
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

    private void setNames() {
        for (int i = 1; i < roboRally.getNumbersOfPlayers()+1; i++) {
            System.out.println("Name on Player " + i + "?");
            roboRally.players.add(new Player(userInputString()));
        }
    }

    private void actionFromInput(String s) {
        if(s.equals("New Game")) {
            System.out.println("How many players?");
            roboRally.setNumbersOfPlayers(userInputInt());
            setNames();
            System.out.println("Starting new game with " + roboRally.getNumbersOfPlayers() + " players");
            int i = 1;
            for (Player p : roboRally.players) {
                System.out.println("Player " + i + " : " + p.getName());
                i++;
            }
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

        System.out.println("ROBORALLY MADNESS!!!");
        System.out.println("type Help if you get stuck!");

        while(run) {
            actionFromInput(userInputString());
        }

        System.out.println("Game Ended");
    }

}