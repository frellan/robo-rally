package edu.chl.roborally.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by axel on 2015-05-26.
 *
 * A styled JLabel used throughout the GUI
 */
public class StyledLabel extends JLabel {

    /**
     * Constructor.
     * @param str A string that will be set as text on the label.
     */
    public StyledLabel(String str){
        this.setSize(200,20);
        this.setForeground(Color.WHITE);
        this.setText(str);
    }
}
