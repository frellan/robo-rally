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
        this.getGraphics().setColor(new Color(213, 60, 44));
        this.getGraphics().setFont(new Font("Impact", Font.PLAIN, 20));
        this.getGraphics().drawString(Integer.toString(card.getPoints()),40,20);
    }
    public void removeCard() {
        card = null;
        setIcon(null);
        setBackground(Color.WHITE);
        setText("<html>Drop card<br>here</html>");
    }
}