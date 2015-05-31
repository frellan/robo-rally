package edu.chl.roborally.utilities;

/**
 * Created by axel on 2015-03-30.
 *
 * Represents an x and y position.
 */
public class Position {
    private final int x;
    private final int y;

    /**
     * Creates an instance of a 2D integer coordinate.
     */
    public Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return The x value of the coordinate.
     */
    public int getX() {
        return this.x;
    }

    /**
     * @return The x value of the coordinate.
     */
    public int getY() {
        return this.y;
    }


    public Position clone() {
        return new Position(x,y);
    }

    @Override
    public int hashCode() {
        return 23456789 * this.x + 56789123 * this.y;
    }

    @Override
    public String toString() {
        return "X=" + this.x + " Y=" + this.y;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Position other = (Position) obj;
        return this.x == other.x && this.y == other.y;
    }
}
