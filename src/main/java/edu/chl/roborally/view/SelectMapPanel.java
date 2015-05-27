package edu.chl.roborally.view;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.maps.GameBoard;
import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.GlobalImageHolder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by axel on 2015-05-26.
 *
 * This panel lets you select a map. It also contains a summary-method which will create a panel to be shown
 * after a map has been selected.
 */
public class SelectMapPanel extends JPanel implements ActionListener, MouseListener{

    private JButton chooseMapButton;
    private JButton startGameBtn;
    private JLabel mapName;
    private JLabel mapDifficulty;
    private JLabel mapPlayers;
    private JLabel mapIcon;
    private JPanel mapInfo;
    private JPanel robotContainer;
    private ArrayList<GameBoard> maps;
    private BufferedImage imageBG;
    private int mapIndex;

    /**
     * Creates the SelectMapPanel where the user will be able to select which map to be played. The maps are shown
     * in a JList and the user will be given a short description of the map before selecting it.
     * @param maps An ArrayList containing GameBoards to be shown in the JList.
     */

    public SelectMapPanel(ArrayList<GameBoard> maps){

        imageBG = GlobalImageHolder.getInstance().getMainBackgroundImage();
        setLayout(null);
        this.maps=maps;
        JPanel mapChooser = new StyledJPanel(null);
        mapChooser.setSize(400,400);
        JPanel listHolder = new JPanel(new BorderLayout());
        listHolder.setOpaque(false);
        listHolder.setSize(100,380);
        listHolder.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (GameBoard map : maps) {
            listModel.addElement(map.getName());
        }

        JList<String> mapList = new JList<>(listModel);
        mapList.setForeground(Color.WHITE);
        mapList.setBackground(Color.DARK_GRAY);
        mapList.addMouseListener(this);
        listHolder.add(mapList);
        mapChooser.add(listHolder).setLocation(10,10);
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
        mapInfo.add(mapIcon).setLocation(41, 20);
        mapInfo.add(mapName).setLocation(41, 240);
        mapInfo.add(mapDifficulty).setLocation(41, 240);
        mapInfo.add(mapPlayers).setLocation(41, 300);
        mapInfo.add(chooseMapButton).setLocation(41, 340);
        mapChooser.add(mapInfo).setLocation(108, 10);
        add(mapChooser).setLocation(300,180);
    }

    /*
    Class method
     */

    /**
     * This method creates the summary panel which will be shown after a map is selected.
     * @param players An ArrayList containing the players.
     */
    public void summary(ArrayList<Player> players) {
        this.removeAll();
        JPanel sumPanel = new StyledJPanel(null);
        sumPanel.setSize(300,450);
        robotContainer = new JPanel(new GridLayout(4,2));
        robotContainer.setOpaque(false);
        robotContainer.setSize(200,150);
        startGameBtn = new Button("start_btn.png", "start_btn_hover.png");
        startGameBtn.addActionListener(this);
        startGameBtn.setSize(200, 50);

        createRobotIcons(players);

        sumPanel.add(mapName).setLocation(50,10);
        sumPanel.add(mapIcon).setLocation(50,40);
        sumPanel.add(robotContainer).setLocation(80, 245);
        sumPanel.add(startGameBtn).setLocation(50,390);
        add(sumPanel).setLocation(350, 170);
        repaint();
        revalidate();
    }

    /*
    Helper methods
     */

    /**
     * This method creates robot-icons to be shown in the summary.
     * @param players An ArrayList containing the players.
     */
    private void createRobotIcons(ArrayList<Player> players){
        for (Player p : players) {
            StyledLabel robotNames = new StyledLabel(p.getName());
            robotNames.setSize(80, 20);
            robotContainer.add(robotNames);
            JLabel robotIcon = new JLabel();
            robotIcon.setIcon(new ImageIcon(p.getImage()));
            robotIcon.setSize(40,40);
            robotContainer.add(robotIcon);
        }
    }

    /**
     * Creates an ImageIcon.
     * @param url The name of the image in the resource folder.
     * @return An ImageIcon containing an bufferedImage from the resource folder.
     */
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

    /*
    Painters
     */

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageBG, 0, 0, getWidth(), getHeight(), this);
    }

    /*
    EventHandlers
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseMapButton) {
            EventTram.getInstance().publish(EventTram.Event.MAP_SELECTED, mapIndex, null);
        } else if (e.getSource() == startGameBtn) {
            EventTram.getInstance().publish(EventTram.Event.START_GAME, null, null);
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
}
