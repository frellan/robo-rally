package edu.chl.roborally.model;

/**
 * Created by fredrikkindstrom on 26/03/15.
 */
public class MoveCard {

    private enum moveType;
    private int points;

    public MoveCard(enum type, int points) {
        this.moveType = type;
        this.points = points;
    }

    public enum moveType {
        MOVE-ONE, MOVE-TWO, MOVE-THREE,
        BACKUP,
        TURN-LEFT, TURN-RIGHT,
        U-TURN
    }
}
