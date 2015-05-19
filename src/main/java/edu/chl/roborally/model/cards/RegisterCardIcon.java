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
    private boolean locked = false;

    public RegisterCardIcon() {
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        setSize(96,150);
    }

    public void setCard(RegisterCard card) {
        this.card = card;
        setText(card.toString());
    }
}