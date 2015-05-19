package edu.chl.roborally.view;

import edu.chl.roborally.model.cards.RegisterCard;
import edu.chl.roborally.model.cards.RegisterCardButton;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.IEventHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by axel on 2015-05-06.
 */
public class PickNewCardsView extends JPanel implements ActionListener, IEventHandler {

    private ArrayList<RegisterCard> inputCards = new ArrayList<>();
    private ArrayList<RegisterCard> outputCards = new ArrayList<>();
    private ArrayList<RegisterCardButton> cardButtons = new ArrayList<>();
    private JButton doneButton;
    private JButton nextTurnButton;

    public PickNewCardsView(){
        setLayout(null);
        setSize(984, 170);
        EventTram.getInstance().register(this);
        doneButton = new JButton("Done");
        doneButton.setSize(70, 20);
        doneButton.addActionListener(this);
        nextTurnButton = new JButton("Next Turn");
        nextTurnButton.setSize(70, 20);
        nextTurnButton.addActionListener(this);
    }

    public void refreshCards(ArrayList<RegisterCard> cards) {
        inputCards = cards;
        refreshButtons();
        revalidate();
        repaint();
    }

    private void refreshButtons(){
        int gap = 8;
        removeAll();
        cardButtons.clear();
        for (RegisterCard card : inputCards) {
            RegisterCardButton temp = new RegisterCardButton(card);
            add(temp).setLocation(gap, 11);
            cardButtons.add(temp);
            gap += 99;
        }
        add(doneButton).setLocation(905, 40);
        add(nextTurnButton).setLocation(905, 100);
    }

    private void sendSelectedCards() {
        for (RegisterCardButton button : cardButtons) {
            if (button.isSelected()) {
                outputCards.add(inputCards.get(cardButtons.indexOf(button)));
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == doneButton) {
            sendSelectedCards();
            if (outputCards.size() == 5) {
                EventTram.getInstance().publish(EventTram.Event.PLAYER_CHOOSEN_CARDS, outputCards, null);
                nextTurnButton.setEnabled(true);
            } else {
                outputCards.clear();
                EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, "Please choose 5 cards", null);
            }

        }
        if (e.getSource() == nextTurnButton){
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
