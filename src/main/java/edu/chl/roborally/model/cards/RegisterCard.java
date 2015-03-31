package edu.chl.roborally.model.cards;

import edu.chl.roborally.model.Player;

/**
 * Created by fredrikkindstrom on 26/03/15.
 */
public abstract class RegisterCard {

    private int points;
    private boolean isHidden;

    public RegisterCard(int points, boolean isHidden) {
        this.points = points;
        this.isHidden = isHidden;
    }

    public abstract void doAction(Player p);

    public void setHidden(boolean b) {
        isHidden = b;
    }

    public int getPoints() {
        return points;
    }

    public int compare(RegisterCard c1, RegisterCard c2) {
        Integer a = new Integer(c1.getPoints());
        Integer b = new Integer(c2.getPoints());
        return a.compareTo(b);
    }

    public String toString() {
        return "Points: " + points;
    }
}