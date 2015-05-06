package edu.chl.roborally.view.gui;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.RoboRally;

import javax.swing.*;

/**
 * Created by axel on 2015-05-06.
 */
public class CardView extends JPanel {

    private RoboRally model;


    public CardView(RoboRally model){
        this.model = model;

        setSize(1000, 228);

    }
}
