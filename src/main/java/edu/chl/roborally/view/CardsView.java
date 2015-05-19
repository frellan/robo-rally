package edu.chl.roborally.view;

import edu.chl.roborally.model.cards.RegisterCardIcon;

import javax.swing.*;
import java.awt.*;

/**
 * Created by fredrikkindstrom on 19/05/15.
 */
public class CardsView extends JPanel {

    private JPanel registerView;
    private RegisterCardIcon[] registerCardIcons = new RegisterCardIcon[5];

    private static final int CARD_WIDTH = 96;
    private static final int CARD_GAP = 14;

    public CardsView() {
        setLayout(null);
        setSize(600,170);
        createRegisterView();
    }

    private void createRegisterView() {
        registerView = new JPanel(new FlowLayout());
        int gap = 6;
        for (int i = 0; i < 5; i++) {
            RegisterCardIcon temp = new RegisterCardIcon();
            registerCardIcons[i] = temp;
            registerView.add(temp).setLocation(gap, 10);
            gap += CARD_WIDTH + CARD_GAP;
        }
        add(registerView).setLocation(0, 0);
    }

    public static void main (String[] args) {
        JFrame main = new JFrame();
        main.setSize(600,190);
        main.add(new CardsView());
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setVisible(true);
    }
}
