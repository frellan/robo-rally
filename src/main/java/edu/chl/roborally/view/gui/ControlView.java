package edu.chl.roborally.view.gui;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.utilities.Constants;

import javax.swing.*;
import java.awt.*;

/**
 * Created by axel on 2015-05-06.
 */
public class ControlView extends JPanel {

    private Player player;

    public ControlView(Player player){
        this.player = player;
        setLayout(new BorderLayout());
        setSize(984, 170);
        setBackground(Color.BLUE);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
