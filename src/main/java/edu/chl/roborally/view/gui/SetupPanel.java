package edu.chl.roborally.view.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by axel on 2015-04-28.
 */
public class SetupPanel extends JPanel implements ActionListener {

    private JButton spinnerButton;
    private JSpinner spinner;
    private Integer currentValue;

    public SetupPanel(){

        setLayout(new FlowLayout());
        spinner = new JSpinner(new SpinnerNumberModel(0, 0, 30, 1));

        spinnerButton = new JButton("Choose Players");
        add(spinnerButton);
        add(spinner);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals("Choose Players")){
            currentValue = (Integer)spinner.getValue();
            System.out.println(currentValue);
        }
    }


}
