package edu.chl.roborally.view;

import edu.chl.roborally.model.RoboRally;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ProjectView extends JFrame {

    private final JButton button = new JButton(RoboRally.PROJECT_BUTTON_TEXT);
    private final JLabel pressesLabel;

    public ProjectView(RoboRally roboRally) {
        super(RoboRally.PROJECT_WINDOW_TEXT);

        final GridLayout layout = new GridLayout(0, 2);
        setLayout(layout);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pressesLabel = new JLabel(String.valueOf(roboRally.getPresses()));
        pressesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pressesLabel.setLabelFor(button);

        add(button);
        add(pressesLabel);
        pack();
    }

    public JButton getButton() {
        return button;
    }

    public JLabel getPressesLabel() {
        return pressesLabel;
    }
}
