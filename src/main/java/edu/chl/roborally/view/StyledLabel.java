package edu.chl.roborally.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by axel on 2015-05-26.
 */
public class StyledLabel extends JLabel {

    public StyledLabel(String str){
        this.setSize(200,20);
        this.setForeground(Color.WHITE);
        this.setText(str);
    }
}
