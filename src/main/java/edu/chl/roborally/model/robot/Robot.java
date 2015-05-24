package edu.chl.roborally.model.robot;

import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.utilities.LargeImageHolder;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by henriknilson on 19/05/15.
 */
public class Robot {

    private String name;
    private Color color;

    public Robot(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Color getColor(){return color;}
}
