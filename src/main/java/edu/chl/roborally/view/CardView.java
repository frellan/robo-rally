package edu.chl.roborally.view;

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
        setSize(588, 162);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        drawCards(g);
    }

    private void drawCards(Graphics g){
        int gap = 5;
        for (RegisterCard card : cards) {
            g.drawRoundRect(gap, 5,
                    Constants.CARD_SLOT_WIDTH, Constants.CARD_SLOT_HEIGHT,
                    Constants.CARD_SLOT_ARC, Constants.CARD_SLOT_ARC);
            card.draw(g, gap + 1, 6);
            gap += Constants.CARD_WIDTH + Constants.CARD_GAP;
        }
    }
}
