package edu.chl.roborally.model.cards;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by fredrikkindstrom on 19/05/15.
 */
public class RegisterCardIcon extends JLabel {

    private RegisterCard card;

    public RegisterCardIcon() {
        setBorder(new LineBorder(Color.BLACK, 2));
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setOpaque(true);
        setText("<html>Drop card<br>here</html>");
        setSize(96, 140);
    }

    public RegisterCard getCard() {
        return card;
    }
    public void setCard(RegisterCard card) {
        this.card = card;
        setIcon(card.getIcon());
    }
    public void removeCard() {
        card = null;
        setIcon(null);
        setBackground(Color.WHITE);
        setText("<html>Drop card<br>here</html>");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (card != null) {
            g.setColor(new Color(255, 188, 62));
            g.setFont(new Font("Impact", Font.PLAIN, 20));
            g.drawString(Integer.toString(card.getPoints()), 35, 27);
        }
    }
}