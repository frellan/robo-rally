package edu.chl.roborally.model.cards;

import edu.chl.roborally.model.gameactions.GameAction;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by fredrikkindstrom on 26/03/15.
 */
public abstract class RegisterCard {

    private final int points;
    private boolean isHidden;
    private boolean isLocked;
    private final String name;
    String cardMessage;
    BufferedImage mainImage;
    BufferedImage pickImage;
    BufferedImage pickImageRollover;
    private final ArrayList<GameAction> actions = new ArrayList<>();

    /**
     * Abstract constructor used by sub-classes to create Register Cards.
     * @param points The amount of priority points the card should have.
     * @param name The name of the card.
     */
    RegisterCard(int points, String name) {
        this.points = points;
        this.isHidden = false;
        this.isLocked = false;
        this.name = name;
    }

    /*
    Getters
     */

    /**
     * Returns the cardMessage, which tells the console what to print.
     * @return the cards message.
     */
    public String getMessage(){return cardMessage;}

    /**
     * Returns the amount of priority points the card have.
     * @return The amount of priority points.
     */
    public int getPoints() {
        return points;
    }

    /**
     * Returns the main icon for the card.
     * This icon is used in the register slots.
     * @return The main icon for the card.
     */
    public ImageIcon getMainIcon() {
        return new ImageIcon(mainImage);
    }

    /**
     * Returns the standard pick icon for the card.
     * This icon is used as the standard icon for a card in the "pick-a-card-list".
     * @return The standard pick icon for the card.
     */
    public ImageIcon getPickIcon() {
        return new ImageIcon(pickImage);
    }

    /**
     * Returns the rollover pick icon for the card.
     * This icon is used when a player hovers the mouse over a card in the "pick-a-card-list".
     * @return The rollover pick icon for the card.
     */
    public ImageIcon getPickIconRollover() {
        return new ImageIcon(pickImageRollover);
    }

    /**
     * Returns true if the card is locked in the register.
     * This happens when the player have too much damage tokens.
     * @return True if the card is in locked state, false if not.
     */
    public boolean isLocked() {
        return isLocked;
    }

    /**
     * Returns true if the card is hidden.
     * This is done at the beginning of the round to
     * slowly reveal the cards as the turn progresses.
     * @return True if the card is in hidden state, false if not.
     */
    public boolean isHidden() {
        return isHidden;
    }

    /**
     * Returns a list of actions associated with the card.
     * This can be "move a player", "rotate a player" etc.
     * @return A list with all the actions for the card.
     */
    public ArrayList<GameAction> getActions() {
        ArrayList<GameAction> temp = new ArrayList<>();
        for (GameAction action : actions) {
            try {
                temp.add((GameAction)action.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return temp;
    }

    public String toString() {
        return name + " (" + points + ")";
    }

    /*
    Setters
     */

    /**
     * Adds a new action to the list of actions for the card.
     * This can be "move a player", "rotate a player" etc.
     * @param action The action to be added to the list.
     */
    void setAction(GameAction action) {
        this.actions.add(action);
    }

    /**
     * Sets the locked state of the card.
     * @param b True to mark the card as locked, false to unlock it.
     */
    public void setLocked(boolean b) {
        isLocked = b;
    }

    /**
     * Sets the hidden state of the card.
     * @param b True to mark the card as hidden, false to reveal it.
     */
    public void setHidden(boolean b) {
        isHidden = b;
    }
}