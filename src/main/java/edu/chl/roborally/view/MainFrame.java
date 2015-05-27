package edu.chl.roborally.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by henriknilson on 26/03/15.
 */
public class MainFrame extends JFrame{

    /**
     * Creates the main window that serves as the top container for all other panels in the GUI.
     */
    public MainFrame() {
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
