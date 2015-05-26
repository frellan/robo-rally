package edu.chl.roborally.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by axel on 2015-05-26.
 */
public class StyledJPanel extends JPanel {

    public StyledJPanel(LayoutManager layoutManager) {
        this.setLayout(layoutManager);
        this.setOpaque(true);
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
    }
}
