package edu.chl.roborally.view;

import edu.chl.roborally.model.maps.GameBoard;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.GlobalImageHolder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by axel on 2015-04-29.
 */
public class StartPanel extends JPanel implements ActionListener, MouseListener{

    //Components
    private JButton newGameButton;
    private JButton optionsButton;
    private JButton exitButton;
    private JButton chooseNbrOfPlayers;
    private JButton startGameBtn;
    private JButton chooseMapButton;
    private JLabel mapName;
    private JLabel mapDifficulty;
    private JLabel mapPlayers;
    private JLabel mapIcon;
    private JSpinner chooser;
    private JPanel mapInfo;

    private BufferedImage imageBG;
    private ArrayList<GameBoard> maps;

    private int mapIndex;

    public StartPanel(){

        imageBG = GlobalImageHolder.getInstance().getMainBackgroundImage();
        setLayout(null);

        JPanel buttonPanel= new StyledJPanel(new GridLayout(0,1,0,5));
        buttonPanel.setSize(200,200);
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
        buttonPanel.setLocation(400, 250);
    }

    public void nbrOfPlayers() {
        this.removeAll();
        JPanel nbrPanel= new StyledJPanel(null);
        nbrPanel.setSize(200,200);

        StyledLabel welcomeLabel = new StyledLabel("WELCOME TO ROBO RALLY!!!");
        StyledLabel msgLabel = new StyledLabel("How many robots will be racing?");

        nbrPanel.add(welcomeLabel);
        nbrPanel.add(msgLabel);
        welcomeLabel.setLocation(16,10);
        msgLabel.setLocation(9,40);

        //Spinner
        chooser = new JSpinner(new SpinnerNumberModel(2, 2, 5, 1));
        chooser.setBorder(BorderFactory.createEmptyBorder());
        chooser.setSize(50,50);

        //Customize the spinners textfield
        Component tf = chooser.getEditor().getComponent(0);
        tf.setBackground(Color.DARK_GRAY);
        tf.setForeground(Color.WHITE);
        tf.setFont(new Font("SansSerif", Font.BOLD, 50));
        tf.setSize(50,40);
        
        nbrPanel.add(chooser);
        chooser.setLocation(75,90);

        chooseNbrOfPlayers = new JButton("Next");
        chooseNbrOfPlayers.addActionListener(this);
        chooseNbrOfPlayers.setSize(180, 20);
        nbrPanel.add(chooseNbrOfPlayers);
        chooseNbrOfPlayers.setLocation(10,170);

        this.add(nbrPanel);
        nbrPanel.setLocation(400,250);
        this.repaint();
        this.revalidate();

    }

    public void chooseMap(ArrayList<GameBoard> maps) {
        this.removeAll();
        this.maps=maps;
        JPanel mapChooser = new StyledJPanel(null);
        mapChooser.setSize(400,400);

        //Create the List with maps
        JPanel listHolder = new JPanel(new BorderLayout());
        listHolder.setOpaque(false);
        listHolder.setSize(100,380);
        listHolder.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (GameBoard map : maps) {
            listModel.addElement(map.getName());
        }

        JList<String> mapList = new JList<>(listModel);
        mapList.setBackground(Color.DARK_GRAY);
        mapList.setForeground(Color.WHITE);
        mapList.addMouseListener(this);

        listHolder.add(mapList);
        mapChooser.add(listHolder);
        listHolder.setLocation(10,10);

        //Create the mapInfo
        mapInfo = new JPanel(null);
        mapInfo.setOpaque(false);
        mapInfo.setSize(282, 380);
        mapInfo.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));

        mapName = new StyledLabel("MapName: " + maps.get(mapIndex).getName());
        mapDifficulty = new StyledLabel("Difficulty: " + maps.get(mapIndex).getDifficulty());
        mapPlayers = new StyledLabel("NbrOfRobots: " + maps.get(mapIndex).getNbrOfPlayers());

        mapIcon = new JLabel();
        mapIcon.setIcon(createIcon(this.getClass().getClassLoader().getResource(maps.get(mapIndex).getMapIcon())));
        mapIcon.setSize(200,200);
        mapIcon.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        chooseMapButton = new JButton("Choose Map");
        chooseMapButton.addActionListener(this);
        chooseMapButton.setSize(200,20);

        mapInfo.add(mapIcon);
        mapIcon.setLocation(41, 20);
        mapInfo.add(mapName);
        mapName.setLocation(41, 240);
        mapInfo.add(mapDifficulty);
        mapDifficulty.setLocation(41, 270);
        mapInfo.add(mapPlayers);
        mapPlayers.setLocation(41, 300);
        mapInfo.add(chooseMapButton);
        chooseMapButton.setLocation(41, 340);
        mapChooser.add(mapInfo);
        mapInfo.setLocation(108, 10);
        this.add(mapChooser);
        mapChooser.setLocation(300,180);

        repaint();
        revalidate();
    }

    public void summary(ArrayList<String> names) {
        this.removeAll();
        int verticalGap = 10;
        JPanel sumPanel = new StyledJPanel(null);
        sumPanel.setSize(300,400);

        sumPanel.add(mapName);
        sumPanel.add(mapIcon);

        mapName.setLocation(50,10);
        mapIcon.setLocation(50,40);

        StyledLabel robots = new StyledLabel("Robots: ");
        sumPanel.add(robots);
        robots.setLocation(50, 250);

        for (String s : names) {
            StyledLabel robotNames = new StyledLabel(s);
            sumPanel.add(robotNames);
            robotNames.setLocation(100, 240 + verticalGap);
            verticalGap = verticalGap + 20;
        }

        startGameBtn = new Button("start_btn.png", "start_btn_hover.png");
        startGameBtn.addActionListener(this);
        startGameBtn.setSize(200, 50);
        sumPanel.add(startGameBtn);
        startGameBtn.setLocation(50,330);
        this.add(sumPanel);
        sumPanel.setLocation(350, 180);
        this.repaint();
        this.revalidate();
    }

    // Draw background
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageBG, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(newGameButton)) {
            EventTram.getInstance().publish(EventTram.Event.SHOW_MENU, null, null);
        } else if(e.getSource().equals(optionsButton)) {

        } else if (e.getSource().equals(exitButton)) {
            System.exit(1);
        } else if (e.getSource() == chooseNbrOfPlayers) {
            EventTram.getInstance().publish(EventTram.Event.SET_ROBOTS, chooser.getValue(), null);
        } else if (e.getSource() == chooseMapButton) {
            EventTram.getInstance().publish(EventTram.Event.SET_MAP, mapIndex, null);
        } else if (e.getSource() == startGameBtn) {
            EventTram.getInstance().publish(EventTram.Event.RUN_GAME, null, null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JList list = (JList) e.getSource();
        if (e.getClickCount() == 1) {
            mapIndex = list.locationToIndex(e.getPoint());
            mapName.setText("MapName: " + maps.get(mapIndex).getName());
            mapDifficulty.setText("Difficulty: " + maps.get(mapIndex).getDifficulty());
            mapPlayers.setText("NbrOfRobots: " + maps.get(mapIndex).getNbrOfPlayers());
            mapIcon.setIcon(createIcon(this.getClass().getClassLoader().getResource(maps.get(mapIndex).getMapIcon())));
            mapInfo.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public class StyledJPanel extends JPanel {
        public StyledJPanel(LayoutManager layoutManager) {
            this.setLayout(layoutManager);
            this.setOpaque(true);
            this.setBackground(Color.DARK_GRAY);
            this.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
        }
    }

    private class StyledLabel extends JLabel {
        public StyledLabel(String str){
            this.setSize(200,20);
            this.setForeground(Color.WHITE);
            this.setText(str);
        }
    }

    private ImageIcon createIcon(URL url){
        BufferedImage bi;
        try {
            bi = ImageIO.read(url);
            return new ImageIcon(bi);
        } catch(java.io.IOException e){
            System.out.println("Image could not be read");
        }
        return null;
    }
}
