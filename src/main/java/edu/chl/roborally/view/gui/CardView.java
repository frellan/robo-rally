package edu.chl.roborally.view.gui;

import edu.chl.roborally.model.cards.RegisterCard;
import edu.chl.roborally.utilities.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by axel on 2015-05-06.
 */
public class CardView extends JPanel {

    private ArrayList<RegisterCard> cards;


    public CardView(ArrayList<RegisterCard> cards){
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
        for(int i = 0; i < cards.size(); i ++){
            g.drawRect(i * Constants.CARD_WIDTH, 0, Constants.CARD_WIDTH, Constants.CARD_HEIGHT);
            cards.get(i).
        }
    }
}
