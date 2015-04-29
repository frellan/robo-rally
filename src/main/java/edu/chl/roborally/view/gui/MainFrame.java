package edu.chl.roborally.view.gui;

import edu.chl.roborally.controller.AppController;
import edu.chl.roborally.model.RoboRally;

import javax.swing.*;
import java.awt.*;

/**
 * Created by henriknilson on 26/03/15.
 */
public class MainFrame extends JFrame{

    public MainFrame() {
        setTitle("RoboRally");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLayout(new BorderLayout());
        setVisible(true);

    }
}
