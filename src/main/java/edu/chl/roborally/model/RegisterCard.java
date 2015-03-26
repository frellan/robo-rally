package edu.chl.roborally.model;

/**
 * Created by fredrikkindstrom on 26/03/15.
 */
public class RegisterCard {

    // Card types

    public enum MoveTypes {
        MOVE_ONE,
        MOVE_TWO,
        MOVE_THREE,
        BACKUP,
        ROTATE_LEFT,
        ROTATE_RIGHT,
        U_TURN;
    }

    private MoveTypes type;
    private int points;

    // Constructor

    protected RegisterCard(MoveTypes type,int points) {
        this.type = type;
        this.points = points;
    }

    public String toString() {
        return "Move: " + type + "Points: " + points;
    }
}