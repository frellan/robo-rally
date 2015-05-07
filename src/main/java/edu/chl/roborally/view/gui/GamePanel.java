package edu.chl.roborally.view.gui;

import edu.chl.roborally.model.RoboRally;
import javax.swing.*;
import java.awt.*;


/**
 * Created by axel on 2015-05-06.
 */
public class GamePanel extends JPanel {

    public GamePanel(RoboRally model){

        setLayout(new FlowLayout());
        setSize(1000,700);
    }
}
