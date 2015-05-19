package edu.chl.roborally.view;

import edu.chl.roborally.model.cards.RegisterCard;
import edu.chl.roborally.utilities.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by axel on 2015-05-06.
 */
public class ActiveRegisterView extends JPanel {

    private ArrayList<RegisterCard> cards;

    private static final int CARD_SLOT_WIDTH = 95;
    private static final int CARD_SLOT_HEIGHT = 147;
    private static final int CARD_SLOT_ARC = 5;
    private static final int CARD_WIDTH = 90;
    private static final int CARD_HEIGHT = 145;
    private static final int CARD_GAP = 18;

    public ActiveRegisterView(ArrayList<RegisterCard> cards){
        this.cards = cards;
        setLayout(new BorderLayout());
        setSize(588, 162);
    }

    /*
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        drawCards(g);
    }

    private void drawCards(Graphics g){
        int gap = 5;
        for (RegisterCard card : cards) {
            g.drawRoundRect(gap, 5,
                    CARD_SLOT_WIDTH, CARD_SLOT_HEIGHT,
                    CARD_SLOT_ARC, CARD_SLOT_ARC);
            card.draw(g, gap + 1, 6);
            gap += CARD_WIDTH + CARD_GAP;
        }
    }
    */
}
