package edu.chl.roborally.model.cards;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by fredrikkindstrom on 19/05/15.
 */
public class RegisterCardIcon extends JLabel {

    private boolean locked = false;

    public RegisterCardIcon() {
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        setSize(96,150);
    }

    public RegisterCardIcon(RegisterCard card) {
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        setSize(96,150);
    }

    public void setIcon(RegisterCard card) {
        setIcon(card.getIcon());
    }
}