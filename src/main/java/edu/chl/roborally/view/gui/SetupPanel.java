package edu.chl.roborally.view.gui;

import edu.chl.roborally.EventTram;

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
    private JButton saveNames;
    private ArrayList<JTextField> tempNames;

    public SetupPanel() {
        nbrOfPlayers();
    }

    private void nbrOfPlayers() {
        chooser = new JSpinner(new SpinnerNumberModel(0, 0, 30, 1));
        this.add(chooser);
        chooseNbrOfPlayers = new JButton("Next");
        chooseNbrOfPlayers.addActionListener(this);
        this.add(chooseNbrOfPlayers);
    }

    private void showNameForms(int i) {
        tempNames = new ArrayList<>();
        this.add(new JLabel("Set Names on players"));
        for (int j = 0; j<i; j++) {
            tempNames.add(new JTextField());
            this.add(new JLabel("Player " + j));
            this.add(tempNames.get(j));
        }
        saveNames = new JButton("Set Names");
        saveNames.addActionListener(this);
        this.add(saveNames);

        this.remove(chooseNbrOfPlayers);
        this.remove(chooser);

        this.repaint();
        this.revalidate();
    }

    private void sendNamesToController() {
        ArrayList<String> names = new ArrayList<>();
        for(JTextField name : tempNames) {
            names.add(name.getText());
            System.out.println("Name on player " + name.getText());
        }
        EventTram.getInstance().publish(EventTram.Event.SET_NAMES, names);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == chooseNbrOfPlayers) {
            showNameForms((Integer) chooser.getValue());
        } else if (e.getSource() == saveNames) {
            sendNamesToController();
        }
    }
}
