package edu.chl.roborally.model.cards;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by fredrikkindstrom on 19/05/15.
 */
public class RegisterCardButton extends JButton {

    private boolean selected = false;

    public RegisterCardButton(RegisterCard card) {
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        setSize(92,144);
        setIcon(card.getIcon());
        add(new JLabel(card.toString()));
        addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (!selected) {
                    selected = true;
                    setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                } else {
                    selected = false;
                    setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (!selected) {
                    selected = true;
                    setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                } else {
                    selected = false;
                    setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (selected) {
                    setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                } else {
                    setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (selected) {
                    setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                } else {
                    setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (!selected) {
                    selected = true;
                    setBorder(BorderFactory.createLineBorder(Color.RED, 3));
                } else {
                    selected = false;
                    setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                }
            }
        });
    }

    @Override
    public boolean isSelected() {
        return selected;
    }
}
