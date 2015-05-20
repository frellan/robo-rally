package edu.chl.roborally.model.robot;

import javax.swing.*;

/**
 * Created by henriknilson on 19/05/15.
 */
public class Robot {

    private String name;
    private Icon icon;

    public Robot(String name) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public Icon getIcon() {
        return icon;
    }
}
