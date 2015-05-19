package edu.chl.roborally.view;


import edu.chl.roborally.model.maps.MapFactory;
import edu.chl.roborally.utilities.EventTram;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    private DefaultListModel<String> listModel;
    private JList<String> mapList;

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

    // TODO tabort eftersom vi ska ha robotar med fasta namn

    public void chooseMap(ArrayList<String> maps) {

        System.out.print("in choosemap");

        this.removeAll();
        JPanel mapChooser = new StyledJPanel(new FlowLayout());

        //Create the List with maps
        JPanel listHolder = new JPanel();

        listModel = new DefaultListModel<>();
        for (String map : maps) {
            listModel.addElement(map);

        }

        JList<String> mapList = new JList<>(listModel);

        mapList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JList list = (JList) e.getSource();
                if(e.getClickCount() == 2){
                    int index = list.locationToIndex(e.getPoint());
                }
                System.out.print("im in the list mothfu");
            }
        });

        listHolder.add(mapList);
        mapChooser.add(listHolder);

        //Create the mapInfo
        JPanel mapInfo = new JPanel();
        //JLabel mapName = new JLabel(maps.get(index).toString());

        //mapInfo.add(mapName);
        mapChooser.add(mapInfo);
        this.add(mapChooser);
        
        repaint();
        revalidate();
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

    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            System.out.println("Woo");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(newGameButton)) {
            EventTram.getInstance().publish(EventTram.Event.SELECT_PLAYERS, null, null);
        } else if(e.getSource().equals(optionsButton)) {

        } else if (e.getSource().equals(exitButton)) {
            System.exit(1);
        } else if (e.getSource() == chooseNbrOfPlayers) {
            EventTram.getInstance().publish(EventTram.Event.SET_NBR_OF_ROBOTS, chooser.getValue(), null);
        } else if (e.getSource() == saveNames) {

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
