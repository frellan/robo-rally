package edu.chl.roborally.view;

import edu.chl.roborally.controller.Controller;
import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.cards.RegisterCard;

/**
 * Created by fredrikkindstrom on 22/04/15.
 */
public class TerminalOutput {

    private final Controller controller;

    public TerminalOutput(Controller c) {
        controller = c;
    }

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
}
