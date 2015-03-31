package edu.chl.roborally.model.cards;

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

    public abstract void doAction();

    public int getPoints() {
        return points;
    }

    public String toString() {
        return "Points: " + points;
    }
}