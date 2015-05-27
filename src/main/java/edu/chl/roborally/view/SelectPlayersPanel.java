package edu.chl.roborally.view;

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

/**
 * Created by axel on 2015-05-26.
 */
public class SelectPlayersPanel extends JPanel implements ActionListener, MouseListener {

    private JPanel nbrPanel;

    private JLabel plusLabel;
    private JLabel minusLabel;
    private JLabel players;

    private JButton chooseNbrOfPlayers;
    private BufferedImage imageBG;
    private int playerIndex = 2;

    public SelectPlayersPanel(){

        imageBG = GlobalImageHolder.getInstance().getMainBackgroundImage();
        setLayout(null);

        nbrPanel= new StyledJPanel(null);
        nbrPanel.setSize(200,200);

        StyledLabel welcomeLabel = new StyledLabel("WELCOME TO ROBO RALLY!!!");
        StyledLabel msgLabel = new StyledLabel("How many robots will be racing?");

        nbrPanel.add(welcomeLabel);
        nbrPanel.add(msgLabel);
        welcomeLabel.setLocation(16,10);
        msgLabel.setLocation(9,40);

        //Custom Spinner
        plusLabel = new JLabel();
        plusLabel.setSize(30, 30);
        plusLabel.setIcon(createIcon(this.getClass().getClassLoader().getResource("plus-4x.png")));
        plusLabel.addMouseListener(this);

        minusLabel = new JLabel();
        minusLabel.setSize(30, 30);
        minusLabel.setIcon(createIcon(this.getClass().getClassLoader().getResource("minus-4x.png")));
        minusLabel.addMouseListener(this);

        players = new StyledLabel(Integer.toString(playerIndex));
        players.setSize(50, 50);
        players.setFont(new Font("", Font.BOLD, 60));

        nbrPanel.add(plusLabel);
        plusLabel.setLocation(140, 93);
        nbrPanel.add(minusLabel);
        minusLabel.setLocation(30, 93);
        nbrPanel.add(players);
        players.setLocation(85,80);

        chooseNbrOfPlayers = new JButton("Next");
        chooseNbrOfPlayers.addActionListener(this);
        chooseNbrOfPlayers.setSize(180, 20);
        nbrPanel.add(chooseNbrOfPlayers);
        chooseNbrOfPlayers.setLocation(10,170);

        add(nbrPanel);
        nbrPanel.setLocation(400,250);
    }

    /*
    EventHandlers
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseNbrOfPlayers) {
            EventTram.getInstance().publish(EventTram.Event.PLAYERS_SELECTED, Integer.parseInt(players.getText()), null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == plusLabel){
            if(!(playerIndex >= 4)){
                playerIndex ++;
                players.setText(Integer.toString(playerIndex));
                nbrPanel.repaint();
            }
        } else if (e.getSource() == minusLabel){
            if(!(playerIndex <= 2)){
                playerIndex --;
                players.setText(Integer.toString(playerIndex));
                nbrPanel.repaint();
            }
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

    /*
    Painter
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageBG, 0, 0, getWidth(), getHeight(), this);
    }

    /*
    Image-creater
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
}
