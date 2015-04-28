package edu.chl.roborally.view.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by axel on 2015-04-28.
 */
public class SetupPanel extends JPanel implements ActionListener {

    private JButton spinnerButton;
    private JButton saveNames;
    private JSpinner spinner;
    private Integer currentValue;
    private ArrayList<JTextField> textFieldArrayList;
    private ArrayList<String> names;


    public SetupPanel(){

        setLayout(new FlowLayout());


    }

    public ArrayList<String> getNames() {

        spinner = new JSpinner(new SpinnerNumberModel(0, 0, 30, 1));
        spinnerButton = new JButton("Choose Players");

        spinnerButton.addActionListener(this);

        add(spinnerButton);
        add(spinner);

        return names;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(spinnerButton)){
            currentValue = (Integer)spinner.getValue();
            System.out.println(currentValue);
            setNames(currentValue);
        }
        if(e.getSource().equals(saveNames)) {
            names = new ArrayList<>();
            for(JTextField textField : textFieldArrayList){
                names.add(textField.getText());
                System.out.println("i have clicked Save Names button");
            }
        }
    }

    public void setNames(Integer i){

        textFieldArrayList = new ArrayList<>();

        for(int j = 0; j < i; j ++){

            add(new JLabel("Player " + j));
            add(new JTextField());
            textFieldArrayList.add(new JTextField());
            add(textFieldArrayList.get(j));
            revalidate();
        }
        saveNames = new JButton("Save Names");
        saveNames.addActionListener(this);
        add(saveNames);
    }
}
