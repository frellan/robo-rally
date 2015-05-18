package edu.chl.roborally.view;

import edu.chl.roborally.model.cards.RegisterCard;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.IEventHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by axel on 2015-05-06.
 */
public class PickNewCardsView extends JPanel implements ActionListener, IEventHandler {

    private ArrayList<RegisterCard> inputCards = new ArrayList<>();
    private ArrayList<RegisterCard> outputCards = new ArrayList<>();
    private ArrayList<JCheckBox> cardButtons = new ArrayList<>();
    private JButton doneButton;
    private JButton nextTurnButton;

    public PickNewCardsView(){
        setLayout(new FlowLayout());
        setSize(588, 170);
    }

    public void setCards(ArrayList<RegisterCard> cards) {
        inputCards = cards;
    }

    @Override
    public void onEvent(EventTram.Event evt, Object o, Object o2) {
        if(evt == EventTram.Event.CHOOSE_CARDS){
            nextTurnButton.setEnabled(false);
        }
    }
}
