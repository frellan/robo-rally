package edu.chl.roborally.view;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.cards.RegisterCard;

import javax.swing.*;
import java.awt.*;

/**
 * Created by henriknilson on 26/03/15.
 */
public class View extends JFrame{

    public View() {
        setTitle("RoboRally");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLayout(new BorderLayout());
        setVisible(true);
        addGameScreen();
    }

    private void addGameScreen() {
        add(new GameScreen(),BorderLayout.CENTER);
    }

    // Console methods

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
