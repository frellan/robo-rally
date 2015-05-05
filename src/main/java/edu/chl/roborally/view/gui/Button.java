package edu.chl.roborally.view.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.net.URL;

/**
 * Created by axel on 2015-05-05.
 *
 * Button for the menu with hover effect
 *
 */
public class Button extends JButton {

    public Button (String normal){
        this.setIcon(createIcon(this.getClass().getClassLoader().getResource(normal)));
        styleButton();
    }


    public Button (String normal, String hover){
        this(normal);
        this.setRolloverIcon(createIcon(this.getClass().getClassLoader().getResource(hover)));
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
}
