package edu.chl.roborally.view;

import edu.chl.roborally.model.cards.RegisterCard;
import edu.chl.roborally.model.cards.RegisterCardButton;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.IEventHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

/**
 * Created by axel on 2015-05-06.
 */
public class PickNewCardsView extends JPanel implements ActionListener, IEventHandler {

    private ArrayList<RegisterCard> inputCards = new ArrayList<>();
    private ArrayList<RegisterCard> outputCards = new ArrayList<>();
    private ArrayList<Shape> graphics= new ArrayList<>();
    private JButton doneButton;
    private JButton nextTurnButton;

    private static final int CARD_SLOT_WIDTH = 98;
    private static final int CARD_SLOT_HEIGHT = 147;
    private static final int CARD_SLOT_ARC = 5;
    private static final int CARD_WIDTH = 96;
    private static final int CARD_GAP = 12;

    public PickNewCardsView(){
        setLayout(new FlowLayout());
        setSize(984, 170);
    }

    public void setCards(ArrayList<RegisterCard> cards) {
        inputCards = cards;
        for (RegisterCard card : inputCards) {
            add(new RegisterCardButton(card));
        }
        revalidate();
        repaint();
    }

    /*
    private void createCardOutlines(){
        int gap = 11;
        for (int i = 0; i < inputCards.size(); i++) {
            graphics.add(new RoundRectangle2D.Double(
                    gap,11,
                    CARD_SLOT_WIDTH,CARD_SLOT_HEIGHT,
                    CARD_SLOT_ARC,CARD_SLOT_ARC));
            gap += CARD_WIDTH + CARD_GAP;
        }
    }

    private void drawCards(Graphics g){
        int gap = 11;
        for (RegisterCard card : inputCards) {
            card.draw(g, gap + 1, 12);
            gap += CARD_WIDTH + CARD_GAP;
        }
    }
    */

    @Override
    public void onEvent(EventTram.Event evt, Object o, Object o2) {
        if(evt == EventTram.Event.CHOOSE_CARDS){
            nextTurnButton.setEnabled(false);
        }
    }
}
