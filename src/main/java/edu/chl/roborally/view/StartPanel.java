package edu.chl.roborally.view;


import edu.chl.roborally.utilities.EventTram;
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
    private JButton startGameBtn;
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
        EventTram.getInstance().publish(EventTram.Event.SET_NAMES, names, null);
    }

    private void sendMapChocieToController() {
        String mapName = "Default";
        for (JRadioButton btn : radioBtnList) {
            if (btn.isSelected()) {
                mapName = btn.getText();
            }
        }
        EventTram.getInstance().publish(EventTram.Event.SET_MAP, mapName, null);
    }

    public void summary(ArrayList<String> names, String mapName) {
        this.removeAll();
        JPanel sumPanel = new StyledJPanel(new GridLayout(5,0));
        sumPanel.add(new JLabel("We are now ready for this game!!!"));
        for (String s : names) {
            sumPanel.add(new JLabel(s));
        }
        sumPanel.add(new JLabel(mapName));
        startGameBtn = new Button("start_btn.png", "start_btn_hover.png");
        startGameBtn.addActionListener(this);
        sumPanel.add(startGameBtn);
        this.add(sumPanel);
        this.repaint();
        this.revalidate();
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
            EventTram.getInstance().publish(EventTram.Event.SHOW_MENU, null, null);
        } else if(e.getSource().equals(optionsButton)){

        } else if(e.getSource().equals(exitButton)){
            System.exit(1);
        } else if(e.getSource() == chooseNbrOfPlayers) {
            showNameForms((Integer) chooser.getValue());
        } else if (e.getSource() == saveNames) {
            sendNamesToController();
        } else if (e.getSource() == chooseMapButton) {
            sendMapChocieToController();
        } else if (e.getSource() == startGameBtn) {
            EventTram.getInstance().publish(EventTram.Event.RUN_GAME, null, null);
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
