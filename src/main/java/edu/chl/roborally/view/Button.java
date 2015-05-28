package edu.chl.roborally.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.net.URL;

/**
 * Created by axel on 2015-05-05.
 *
 * Button with icon.
 *
 */
class Button extends JButton {

    /**
     * Constructor which creates a button without hoover effect.
     * @param normal The name of the image in the resource folder.
     */
    public Button (String normal){
        this.setIcon(createIcon(this.getClass().getClassLoader().getResource("menu_buttons/" + normal)));
        styleButton();
    }

    /**
     * Constructor which creates a button with hoover effect.
     * @param normal The name of the image in the resource folder.
     * @param hover The name of the image in the resource folder which will be shown when the button is hoovered.
     */
    public Button (String normal, String hover){
        this(normal);
        this.setRolloverIcon(createIcon(this.getClass().getClassLoader().getResource("menu_buttons/" + hover)));
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

    private void styleButton(){
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
    }
}
