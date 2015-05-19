package edu.chl.roborally.model.cards;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by fredrikkindstrom on 19/05/15.
 */
public class RegisterCardButton extends JButton {

    private boolean selected = false;

    private static final int CARD_SLOT_WIDTH = 98;
    private static final int CARD_SLOT_HEIGHT = 147;
    private static final int CARD_SLOT_ARC = 5;
    private static final int CARD_WIDTH = 96;

    public RegisterCardButton(RegisterCard card) {
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        setIcon(card.getIcon());
        addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (!selected) {
                    selected = true;
                    setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.RED));
                } else {
                    selected = false;
                    setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (!selected) {
                    selected = true;
                    setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.RED));
                } else {
                    selected = false;
                    setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (selected) {
                    setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.RED));
                } else {
                    setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (selected) {
                    setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.RED));
                } else {
                    setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (!selected) {
                    selected = true;
                    setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.RED));
                } else {
                    selected = false;
                    setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame main = new JFrame();
        JPanel panel = new JPanel();
        panel.add(new RegisterCardButton(new BackupCard(100,false)));
        main.add(panel);
        main.pack();
        main.setVisible(true);
    }
}
