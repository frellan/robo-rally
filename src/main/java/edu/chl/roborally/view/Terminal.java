package edu.chl.roborally.view;

import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.controller.AppController;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.cards.RegisterCard;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by fredrikkindstrom on 22/04/15.
 */
public class Terminal extends UI{

    public Terminal(AppController appController) {
        super(appController);
        startMsg();
    }

    // Inputs
    public String userInputString() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
    public int userInputInt() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    // Commands
    private void actionFromInput(String s) {
        switch (s.toLowerCase()) {
            case "new game":
                super.appController.initGameController();
                EventTram.getInstance().publish(EventTram.Event.INIT_GAME, null);
                break;
            case "end":
                super.appController.endGame();
                break;
            case "help":
                print("Commands: 'new game', 'end'");
                break;
            default:
                print(s + " not a command");
                break;
        }
    }

    // Prints
    public void print(String s) {
        System.out.println(s);
    }
    public void printHeader(String s) {
        print("------------------------------------------------------");
        print(s);
        print("------------------------------------------------------");
        print("");
    }
    public void printDealtCards(Player p) {
        print(p.getName() + " this is your cards");
        print("");
        for(RegisterCard c : p.getDealtCards()) {
            print(p.getDealtCards().indexOf(c) + " " + c.toString());
        }
    }
    public void printActiveCards(Player p) {
        int index = 1;
        for(RegisterCard c : p.getProgrammedCards()) {
            print(index + " " + c.toString());
            index++;
        }
    }

    @Override
    public void startMsg() {
        print("ROBORALLY MADNESS!!!");
    }

    @Override
    public void menu() {
        print("type Help if you get stuck!");

        while(super.appController.isAppRunning()) {
            actionFromInput(userInputString());
        }

        print("Game Ended");
    }

    @Override
    public void choosePlayerNames() {
        print("How many players?");
        ArrayList<String> names = new ArrayList<>();
        int howManyPlayers = userInputInt();
        for (int i = 1; i < howManyPlayers+1; i++ ) {
            print("Name on Player " + i);
            names.add(userInputString());
        }
        print("Done with names");
        EventTram.getInstance().publish(EventTram.Event.SET_NAMES, names);
    }

    @Override
    public void chooseMap(ArrayList<String> maps) {
        print("Choose map: ");
        for(int i = 0; i < maps.size(); i++){
            print(i + " " + maps.get(i));
        }
        EventTram.getInstance().publish(EventTram.Event.SET_MAP, userInputInt());
    }

    @Override
    public void chooseCards(Player p) {
        printDealtCards(p);
        print("");
        print("Choose 5 cards");
        print("Type the index of the card in the order you want to place them, separated by commas");
        String[] s = userInputString().split(",");
        int index = 0;
        for (String value : s) {
            int nr = Integer.parseInt(value);
            p.setProgrammedCard(index, p.getDealtCard(nr));
            index++;
        }
        print(p.getName() + " have choosen the following cards:");
        printActiveCards(p);
        print("");
    }
}
