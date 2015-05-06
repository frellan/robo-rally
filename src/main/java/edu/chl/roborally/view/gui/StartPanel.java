package edu.chl.roborally.view.gui;


import edu.chl.roborally.EventTram;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by axel on 2015-04-29.
 */
public class StartPanel extends JPanel implements ActionListener{

    private JButton newGameButton;
    private JButton optionsButton;
    private JButton exitButton;
    private BufferedImage bi;
    private JPanel buttonPanel;
    private JSpinner chooser;
    private JButton chooseNbrOfPlayers;
    private JButton saveNames;
    private ArrayList<JTextField> tempNames;
    private JButton chooseMapButton;
    private JSpinner mapInt;

    public StartPanel(){

        this.setLayout(new GridBagLayout());

        try {
            bi = ImageIO.read(this.getClass().getClassLoader().getResource("roborally_start.jpg"));
        }catch(java.io.IOException | NullPointerException e){
            System.out.println("Image could not be read");
        }

        buttonPanel = new JPanel(new GridLayout(0,1,0,5));
        buttonPanel.setOpaque(true);
        buttonPanel.setBackground(Color.DARK_GRAY);
        buttonPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
        newGameButton = new Button("start_btn.png", "start_btn_hover.png");
        newGameButton.addActionListener(this);
        optionsButton = new Button("options_btn.png","options_btn_hover.png");
        optionsButton.addActionListener(this);
        exitButton = new Button("exit_btn.png", "exit_btn_hover.png");
        exitButton.addActionListener(this);

        buttonPanel.add(newGameButton);
        buttonPanel.add(optionsButton);
        buttonPanel.add(exitButton);

        add(buttonPanel);
    }
    public void nbrOfPlayers() {
        this.removeAll();
        JPanel nbrPanel= new JPanel(new GridLayout(3,0));
        nbrPanel.setOpaque(true);
        nbrPanel.setBackground(Color.DARK_GRAY);
        nbrPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
        nbrPanel.add(new JLabel("Choose Number of Players"));
        chooser = new JSpinner(new SpinnerNumberModel(0, 0, 30, 1));
        nbrPanel.add(chooser);
        chooseNbrOfPlayers = new JButton("Next");
        chooseNbrOfPlayers.addActionListener(this);
        nbrPanel.add(chooseNbrOfPlayers);
        this.add(nbrPanel);
        this.repaint();
        this.revalidate();
    }

    public void showNameForms(int i) {
        this.removeAll();
        JPanel nameForms = new JPanel(new GridLayout(5,0));
        nameForms.setOpaque(true);
        nameForms.setBackground(Color.DARK_GRAY);
        nameForms.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
        tempNames = new ArrayList<>();
        nameForms.add(new JLabel("Set Names on players"));

        for (int j = 0; j<i; j++) {
            JPanel panel = new JPanel(new GridLayout(0,2));
            panel.setOpaque(true);
            panel.setBackground(Color.DARK_GRAY);
            panel.add(new JLabel("Player " + j));
            tempNames.add(new JTextField());
            panel.add(tempNames.get(j));
            nameForms.add(panel);
        }
        saveNames = new JButton("Set Names");
        saveNames.addActionListener(this);
        nameForms.add(saveNames);
        this.add(nameForms);
        this.repaint();
        this.revalidate();
    }

    public void chooseMap() {
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

    // Draw background
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bi, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(newGameButton)){
            EventTram.getInstance().publish(EventTram.Event.INIT_GAME, null);
        } else if(e.getSource().equals(optionsButton)){

        } else if(e.getSource().equals(exitButton)){
            System.exit(1);
        } else if(e.getSource() == chooseNbrOfPlayers) {
            showNameForms((Integer) chooser.getValue());
        } else if (e.getSource() == saveNames) {
            sendNamesToController();
        } else if (e.getSource() == chooseMapButton) {
            EventTram.getInstance().publish(EventTram.Event.SET_MAP, mapInt.getValue());
        }
    }
}
