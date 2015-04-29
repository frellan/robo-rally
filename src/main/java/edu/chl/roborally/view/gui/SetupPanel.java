package edu.chl.roborally.view.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by axel on 2015-04-29.
 */
public class SetupPanel extends JPanel implements ActionListener {

    private JSpinner chooser;
    private JButton chooseNbrOfPlayers;

    public SetupPanel() {
        nbrOfPlayers();
    }

    private void nbrOfPlayers() {
        chooser = new JSpinner(new SpinnerNumberModel(0, 0, 30, 1));
        this.add(chooser);
        chooseNbrOfPlayers = new JButton("Next");
        this.add(chooseNbrOfPlayers);
    }

    private void showNameForms(int i) {
        ArrayList<String> tempNames = new ArrayList<>();
        for(int j = 0; j<i; j++) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == chooseNbrOfPlayers) {
            showNameForms((Integer)chooser.getValue());
        }
    }
}
