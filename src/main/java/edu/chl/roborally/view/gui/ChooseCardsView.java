package edu.chl.roborally.view.gui;

import edu.chl.roborally.model.cards.RegisterCard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by axel on 2015-05-06.
 */
public class ChooseCardsView extends JPanel {

    private ArrayList<RegisterCard> inputCards;
    private ArrayList<RegisterCard> outputCards;

    public ChooseCardsView(ArrayList<RegisterCard> cards){
        this.inputCards = cards;
        setLayout(new FlowLayout());
        setSize(588, 162);
        for (RegisterCard card : inputCards) {
            add(new JRadioButton(card.toString()));
        }
    }
}
