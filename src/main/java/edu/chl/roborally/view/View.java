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

    public void printDealtCards(Player p) {
        for(RegisterCard c : p.getDealtCards()) {
            System.out.println(p.getDealtCards().indexOf(c) + " " + c.toString());
        }
    }

    public void printActiveCards(Player p) {
        int index = 1;
        for(RegisterCard c : p.getProgrammedCards()) {
            System.out.println(index + " " + c.toString());
            index++;
        }
    }

}
