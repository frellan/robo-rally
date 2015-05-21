package edu.chl.roborally.model.robot;

import javax.swing.*;
import java.awt.*;

/**
 * Created by henriknilson on 19/05/15.
 */
public class Robot {

    private String name;
    private Icon icon;
    private Color color;

    public Robot(String name, Color color) {
        this.name = name;
        this.color = color;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public Icon getIcon() {
        return icon;
    }

    public Color getColor(){return color;}
}
