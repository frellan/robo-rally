package edu.chl.roborally.model;

/**
 * Created by fredrikkindstrom on 26/03/15.
 */
public class RegisterCard {

    private Constants.MoveTypes type;
    private int points;

    // Constructor

    protected RegisterCard(Constants.MoveTypes type,int points) {
        this.type = type;
        this.points = points;
    }

    public String toString() {
        return "Move: " + type + "Points: " + points;
    }
}