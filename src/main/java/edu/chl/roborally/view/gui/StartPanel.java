package edu.chl.roborally.view.gui;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;
import edu.chl.roborally.EventTram;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by axel on 2015-04-29.
 */
public class StartPanel extends JPanel implements ActionListener{

    private JButton newGameButton;
    private JButton optionsButton;
    private JButton exitbutton;
    private BufferedImage bi;
    private BufferedImage startBtnImg;

    public StartPanel(){

        URL imageUrl = this.getClass().getClassLoader().getResource("roborally_start.jpg");
        URL fontUrl = this.getClass().getClassLoader().getResource("ArcadeClassic.ttf");

        try {
            bi = ImageIO.read(imageUrl);
        }catch(java.io.IOException e){
            System.out.println("Image could not be read");
        }

        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
        } catch (FontFormatException | IOException | NullPointerException e) {
            e.printStackTrace();
        }

        if (font != null) {
            font = font.deriveFont(Font.PLAIN,20);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
        }

        JPanel buttonPanel = new JPanel(new GridLayout(0,1,0,5));
        buttonPanel.setOpaque(false);

        newGameButton = new JButton("");
        newGameButton.setBorderPainted(false);
        newGameButton.setFocusPainted(true);
        newGameButton.setContentAreaFilled(false);
        URL startBtnImgUrl = this.getClass().getClassLoader().getResource("start_btn.png");
        try {
            startBtnImg = ImageIO.read(startBtnImgUrl);
            newGameButton.setIcon(new ImageIcon(startBtnImg));
        } catch(java.io.IOException e){
            System.out.println("Image could not be read");
        }


        newGameButton.addActionListener(this);

        optionsButton = new JButton("Options");
        optionsButton.setFont(font);
        optionsButton.addActionListener(this);

        exitbutton = new JButton("Exit");
        exitbutton.setFont(font);
        exitbutton.addActionListener(this);

        buttonPanel.add(newGameButton);
        buttonPanel.add(optionsButton);
        buttonPanel.add(exitbutton);

        add(buttonPanel);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bi, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(newGameButton)){
            EventTram.getInstance().publish(EventTram.Event.INIT_GAME, null);
        }
        if(e.getSource().equals(exitbutton)){
            System.exit(1);
        }
    }
}
