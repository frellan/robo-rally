package edu.chl.roborally.model.cards;

import edu.chl.roborally.model.Player;

/**
 * Created by fredrikkindstrom on 26/03/15.
 */
public abstract class RegisterCard {

    private int points;
    private boolean isHidden;
    private String name;

    public RegisterCard(int points, boolean isHidden, String name ) {
        this.points = points;
        this.isHidden = isHidden;
        this.name = name;
    }

    public abstract void doAction(Player p);

    public int getPoints() {
        return points;
    }

    public boolean getHidden() {
        return isHidden;
    }

    public void setHidden(boolean b) {
        isHidden = b;
    }

    public String toString() {
        return name + " " + "Points: " + points;
    }
}