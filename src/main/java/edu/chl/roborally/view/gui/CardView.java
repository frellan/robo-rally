package edu.chl.roborally.view.gui;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by axel on 2015-05-06.
 */
public class CardView extends JPanel {

    private ArrayList<Card> cards;


    public CardView(ArrayList<Card> cards){
        this.cards = cards;
        setLayout(new BorderLayout());
        setSize(700, 228);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        drawCards(g);
    }

    private void drawCards(Graphics g){
        for(Card card : cards){
            //g.drawRect();
        }

    }

}
