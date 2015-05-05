package edu.chl.roborally.view.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.net.URL;

/**
 * Created by axel on 2015-05-05.
 */
public class Button extends JButton implements MouseListener{

    private ImageIcon normalButtonImage;
    private ImageIcon hooverButtonImage;


    public Button (String normal){
        URL normalImageUrl = this.getClass().getClassLoader().getResource(normal);
        styleButton();

        this.normalButtonImage = createIcon(normalImageUrl);
        this.setIcon(normalButtonImage);
    }


    public Button (String normal, String hoover){
        this(normal);
        URL hooverImageUrl = this.getClass().getClassLoader().getResource(hoover);

        this.hooverButtonImage = createIcon(hooverImageUrl);
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

    private void styleButton(){
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == this){
            this.setIcon(hooverButtonImage);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == this){
            this.setIcon(normalButtonImage);
        }
    }
}
