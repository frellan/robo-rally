package edu.chl.roborally.view.gui;

import edu.chl.roborally.EventTram;

import javax.swing.*;
import java.awt.*;
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
    private JButton chooseMapButton;
    private JSpinner mapInt;

    public SetupPanel() {
        this.setOpaque(true);
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createMatteBorder(
                5, 5, 5, 5, Color.BLACK));
        nbrOfPlayers();
        this.setLayout(new GridLayout(5,0));
    }

    private void nbrOfPlayers() {
        this.add(new JLabel("Choose Number of Players"));
        chooser = new JSpinner(new SpinnerNumberModel(0, 0, 30, 1));
        this.add(chooser);
        chooseNbrOfPlayers = new JButton("Next");
        chooseNbrOfPlayers.addActionListener(this);
        this.add(chooseNbrOfPlayers);
    }

    private void showNameForms(int i) {
        this.removeAll();
        tempNames = new ArrayList<>();
        this.add(new JLabel("Set Names on players"));

        for (int j = 0; j<i; j++) {
            JPanel panel = new JPanel(new GridLayout(0,2));
            panel.setOpaque(true);
            panel.setBackground(Color.DARK_GRAY);
            panel.add(new JLabel("Player " + j));
            tempNames.add(new JTextField());
            panel.add(tempNames.get(j));
            this.add(panel);
        }
        saveNames = new JButton("Set Names");
        saveNames.addActionListener(this);
        this.add(saveNames);
        this.repaint();
        this.revalidate();
    }

    private void chooseMap() {
        this.removeAll();
        this.add(new JLabel("Choose Map"));
        this.add(new JLabel("Type 0 Blank"));
        this.add(new JLabel("Type 1 for valut"));
        mapInt = new JSpinner();
        this.add(mapInt);
        chooseMapButton = new JButton("Set Map");
        chooseMapButton.addActionListener(this);
        this.add(chooseMapButton);
        this.repaint();
        this.revalidate();
    }

    private void sendNamesToController() {
        ArrayList<String> names = new ArrayList<>();
        for(JTextField name : tempNames) {
            names.add(name.getText());
        }
        EventTram.getInstance().publish(EventTram.Event.SET_NAMES, names);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == chooseNbrOfPlayers) {
            showNameForms((Integer) chooser.getValue());
        } else if (e.getSource() == saveNames) {
            sendNamesToController();
            this.chooseMap();
        } else if (e.getSource() == chooseMapButton) {
            EventTram.getInstance().publish(EventTram.Event.SET_MAP, mapInt.getValue());
        }
    }
}
