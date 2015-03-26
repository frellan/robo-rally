package edu.chl.change2projectname.view;

import edu.chl.change2projectname.model.Project;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ProjectView extends JFrame {

    private final JButton button = new JButton(Project.PROJECT_BUTTON_TEXT);
    private final JLabel pressesLabel;

    public ProjectView(Project project) {
        super(Project.PROJECT_WINDOW_TEXT);

        final GridLayout layout = new GridLayout(0, 2);
        setLayout(layout);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pressesLabel = new JLabel(String.valueOf(project.getPresses()));
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
