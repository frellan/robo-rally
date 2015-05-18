package edu.chl.roborally.dev;

import edu.chl.roborally.view.ConsoleView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Axel Aringskog on 2015-05-12.
 */
public class TestConsole {

    public TestConsole(){
        JFrame frame = new JFrame("TestConsole");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1000, 700);

        ConsoleView cw = new ConsoleView();
        frame.setLayout(new BorderLayout());
        frame.add(cw);
        frame.setVisible(true);
    }

}
