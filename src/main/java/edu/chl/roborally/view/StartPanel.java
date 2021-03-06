package edu.chl.roborally.view;

import edu.chl.roborally.utilities.EventTram;
import edu.chl.roborally.utilities.GlobalImageHolder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 * Created by axel on 2015-04-29.
 *
 * This class creates the StartPanel which will show the starting menu.
 */
class StartPanel extends JPanel implements ActionListener{

    private final JButton newGameButton;
    private final JButton exitButton;
    private final BufferedImage imageBG;

    /**
     * Creates the panel containing a "Start", "Options" and "Exit"-button.
     */
    public StartPanel(){
        imageBG = GlobalImageHolder.getInstance().getMainBackgroundImage();
        setLayout(null);
        JPanel buttonPanel= new StyledJPanel(new GridLayout(0,1,0,5));
        buttonPanel.setSize(150,100);
        newGameButton = new Button("start_btn.png", "start_btn_hover.png");
        newGameButton.addActionListener(this);
        exitButton = new Button("exit_btn.png", "exit_btn_hover.png");
        exitButton.addActionListener(this);
        buttonPanel.add(newGameButton);
        buttonPanel.add(exitButton);
        add(buttonPanel);
        buttonPanel.setLocation(425, 300);
    }

    /*
    Painters
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageBG, 0, 0, getWidth(), getHeight(), this);
    }

    /*
    EventHandler
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(newGameButton)) {
            EventTram.getInstance().publish(EventTram.Event.SELECT_PLAYERS, null, null);
        } else if (e.getSource().equals(exitButton)) {
            System.exit(1);
        }
    }
}
