package edu.chl.roborally.view;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.cards.RegisterCard;
import edu.chl.roborally.model.maps.GameBoard;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by fredrikkindstrom on 22/04/15.
 */
public class Terminal extends UI{

    public Terminal() {
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
                super.getAppController().initGameController();
                break;
            case "end":
                super.getAppController().endGame();
                break;
            case "help":
                System.out.println("Commands: 'new game', 'end'");
                break;
            default:
                System.out.println(s + " not a command");
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
    public ArrayList<String> getPlayerNames() {
        return null;
    }

    @Override
    public int chooseMap(ArrayList<String> maps) {
        print("Choose map: ");
        for(int i = 0; i < maps.size(); i++){
            print(i + " " + maps.get(i));
        }
        return userInputInt();
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
