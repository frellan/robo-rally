package edu.chl.roborally.view;

import edu.chl.roborally.model.cards.RegisterCard;
import edu.chl.roborally.utilities.EventTram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by axel on 2015-05-06.
 */
public class ChooseCardsView extends JPanel implements ActionListener{

    private ArrayList<RegisterCard> inputCards = new ArrayList<>();
    private ArrayList<RegisterCard> outputCards = new ArrayList<>();
    private ArrayList<JCheckBox> cardButtons = new ArrayList<>();
    private JButton doneButton;

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
        add(doneButton);
    }

    private void sendCards() {
        for (JCheckBox cardButton : cardButtons) {
            if (cardButton.isSelected()) {
                outputCards.add(inputCards.get(cardButtons.indexOf(cardButton)));
            }
        }
        EventTram.getInstance().publish(EventTram.Event.PLAYER_CHOOSEN_CARDS,outputCards);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == doneButton) {
            sendCards();
        }
    }
}
