package edu.chl.roborally.model;

/**
 * Created by fredrikkindstrom on 26/03/15.
 */
public class RegisterCard {

    private Constants.MoveTypes type;
    private int points;

    public RegisterCard(Constants.MoveTypes type,int points) {
        this.type = type;
        this.points = points;
    }

    public Constants.MoveTypes getType() {
        return type;
    }

    public int getPoints() {
        return points;
    }

    public String toString() {
        return "Move: " + type + "Points: " + points;
    }
}