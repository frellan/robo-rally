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
public class ChooseCardsView extends JPanel implements ActionListener, IEventHandler {

    private ArrayList<RegisterCard> inputCards = new ArrayList<>();
    private ArrayList<RegisterCard> outputCards = new ArrayList<>();
    private ArrayList<JCheckBox> cardButtons = new ArrayList<>();
    private JButton doneButton;
    private JButton nextTurnButton;

    public ChooseCardsView(ArrayList<RegisterCard> cards){
        this.inputCards = cards;
        setLayout(new FlowLayout());
        setSize(588, 162);

        for (RegisterCard card : inputCards) {
            JCheckBox temp = new JCheckBox(card.toString());
            cardButtons.add(temp);
            add(temp);
        }
        doneButton = new JButton("Done");
        doneButton.addActionListener(this);
        nextTurnButton = new JButton("NextTurn");
        nextTurnButton.addActionListener(this);
        add(nextTurnButton);
        add(doneButton);

        EventTram.getInstance().register(this);
    }

    private void addSelectedCards() {
        for (JCheckBox cardButton : cardButtons) {
            if (cardButton.isSelected()) {
                outputCards.add(inputCards.get(cardButtons.indexOf(cardButton)));
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == doneButton) {
            addSelectedCards();
            if(outputCards.size() == 5){
                EventTram.getInstance().publish(EventTram.Event.PLAYER_CHOOSEN_CARDS, outputCards, null);
                nextTurnButton.setEnabled(true);
            }else{
                outputCards.clear();
                EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, "Please choose 5 cards", null);
            }

        }
        if(e.getSource() == nextTurnButton){
            EventTram.getInstance().publish(EventTram.Event.NEW_TURN, null, null);
        }
    }

    @Override
    public void onEvent(EventTram.Event evt, Object o, Object o2) {
        if(evt == EventTram.Event.CHOOSE_CARDS){
            nextTurnButton.setEnabled(false);
        }
    }
}
