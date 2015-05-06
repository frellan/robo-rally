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
    private ArrayList<JRadioButton> radioBtnList;

    public StartPanel(){

        this.setLayout(new GridBagLayout());

        try {
            bi = ImageIO.read(this.getClass().getClassLoader().getResource("roborally_start.jpg"));
        }catch(java.io.IOException | NullPointerException e){
            System.out.println("Image could not be read");
        }

        buttonPanel = new StyledJPanel(new GridLayout(0,1,0,5));
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
        JPanel nbrPanel= new StyledJPanel(new GridLayout(3,0));
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
        JPanel nameForms = new StyledJPanel(new GridLayout(5,0));
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

    public void chooseMap(ArrayList<String> maps) {
        this.removeAll();
        JPanel mapChooser = new StyledJPanel(new GridLayout(4,0));
        mapChooser.add(new JLabel("Choose Map"));
       radioBtnList = new ArrayList<>();
        ButtonGroup btnGroup = new ButtonGroup();
        for (String s : maps) {
            JRadioButton btn = new JRadioButton(s);
            radioBtnList.add(btn);
            btnGroup.add(btn);
            mapChooser.add(btn);
        }
        chooseMapButton = new JButton("Set Map");
        chooseMapButton.addActionListener(this);
        mapChooser.add(chooseMapButton);
        this.add(mapChooser);
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

    private void sendMapChocieToController() {
        String mapName = "Default";
        for (JRadioButton btn : radioBtnList) {
            if (btn.isSelected()) {
                mapName = btn.getText();
            }
        }
        EventTram.getInstance().publish(EventTram.Event.SET_MAP, mapName);
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
            EventTram.getInstance().publish(EventTram.Event.INIT_SETUP, null);
        } else if(e.getSource().equals(optionsButton)){

        } else if(e.getSource().equals(exitButton)){
            System.exit(1);
        } else if(e.getSource() == chooseNbrOfPlayers) {
            showNameForms((Integer) chooser.getValue());
        } else if (e.getSource() == saveNames) {
            sendNamesToController();
        } else if (e.getSource() == chooseMapButton) {
            sendMapChocieToController();
        }
    }

    public class StyledJPanel extends JPanel {
        public StyledJPanel(LayoutManager layoutManager) {
            this.setLayout(layoutManager);
            this.setOpaque(true);
            this.setBackground(Color.DARK_GRAY);
            this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
        }
    }
}
