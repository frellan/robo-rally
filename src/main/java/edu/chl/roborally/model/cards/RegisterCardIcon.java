package edu.chl.roborally.model.cards;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by fredrikkindstrom on 19/05/15.
 */
public class RegisterCardIcon extends JLabel {

    private RegisterCard card;

    public RegisterCardIcon() {
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setText("No card");
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        setSize(96, 140);
    }

    public RegisterCard getCard() {
        return card;
    }
    public void setCard(RegisterCard card) {
        this.card = card;
        setBackground(Color.PINK);
        setText(card.toString());
    }
    public void removeCard() {
        card = null;
        setBackground(Color.WHITE);
        setText("No card");
    }
}