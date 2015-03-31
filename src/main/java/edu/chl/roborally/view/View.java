package edu.chl.roborally.view;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.cards.RegisterCard;

/**
 * Created by henriknilson on 26/03/15.
 */
public class View {

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
