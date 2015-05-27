package edu.chl.roborally.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by axel on 2015-05-26.
 *
 * A styled JPanel used throughout the GUI.
 */
class StyledJPanel extends JPanel {

    /**
     * Constructor.
     * @param layoutManager The layout that will be given to the panel.
     */
    public StyledJPanel(LayoutManager layoutManager) {
        this.setLayout(layoutManager);
        this.setOpaque(true);
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
    }
}
