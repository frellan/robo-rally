package edu.chl.roborally.view;

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
        setSize(1000, 760);
        setLayout(new BorderLayout());
        setResizable(false);
        setVisible(true);
    }
}
