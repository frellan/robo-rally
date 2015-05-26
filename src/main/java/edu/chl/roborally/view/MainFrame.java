package edu.chl.roborally.view;

import edu.chl.roborally.controller.AppController;
import edu.chl.roborally.model.RoboRally;

import javax.swing.*;
import java.awt.*;

/**
 * Created by henriknilson on 26/03/15.
 */
public class MainFrame extends JFrame{

    protected MainFrame() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.createImage(this.getClass().getClassLoader().getResource("icon.png"));
        setIconImage(img);
        setTitle("RoboRally");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1011, 778);
        setLayout(new BorderLayout());
        setResizable(false);
        setVisible(true);
    }
}
