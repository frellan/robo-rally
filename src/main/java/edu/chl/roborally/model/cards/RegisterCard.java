package edu.chl.roborally.model.cards;

import edu.chl.roborally.model.Constants;

/**
 * Created by fredrikkindstrom on 26/03/15.
 */
public abstract class RegisterCard {

    private int points;

    //Constructor

    public RegisterCard(int points) {
        this.points = points;
    }

    public abstract void doAction();

    public int getPoints() {
        return points;
    }

    public String toString() {
        return "Points: " + points;
    }
}