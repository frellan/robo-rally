package edu.chl.roborally.utilities;

/**
 * Created by henriknilson on 26/05/15.
 */
public class WallException extends Exception {

    private String message = "Oh no a wall";

    public WallException() { super(); }
    public WallException(String message) { super(message); }
    public WallException(String message, Throwable cause) { super(message, cause); }
    public WallException(Throwable cause) { super(cause); }
}
