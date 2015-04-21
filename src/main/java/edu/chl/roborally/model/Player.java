package edu.chl.roborally.model;


import edu.chl.roborally.model.cards.RegisterCard;

import java.util.ArrayList;

/**
 * Created by Pertta on 15-03-26.
 */
public class Player {

    //Variables

    private String name;
    private int lifeTokens;
    private int damageTokens;
    private int iD;
    private Position position;
    private Position checkpoint;
    private Constants.Directions direction;
    private ArrayList<RegisterCard> dealtCards;
    private RegisterCard[] programmedCards;
    private Constants.Status status;

    //Constructor

    public Player(int iD, String name) {
        this.iD = iD;
        this.name = name;
        this.lifeTokens = 3;
        this.damageTokens = 0;
        this.direction = Constants.Directions.NORTH;
        this.programmedCards = new RegisterCard[5];
        this.status = Constants.Status.ALIVE;
    }

    // Getters

    public String getName() {
        return name;
    }

    public int getLifeTokens() {
        return lifeTokens;
    }

    public int getDamageTokens() {
        return damageTokens;
    }

    public int getiD() {
        return iD;
    }

    public Position getPosition() {
        return position;
    }

    public Constants.Directions getDirection() {
        return direction;
    }

    public RegisterCard getDealtCard(int index) {
        return dealtCards.get(index);
    }

    public ArrayList<RegisterCard> getDealtCards() {
        return dealtCards;
    }

    public RegisterCard getProgrammedCard(int index) {
        if (index >= 0 && index < 5) {
            return programmedCards[index];
        }
        else {
            throw new IllegalArgumentException("Index must be between 0 and 4");
        }
    }

    public RegisterCard[] getProgrammedCards() {
        return programmedCards;
    }

    public Constants.Status getStatus() {
        return this.status;
    }

    //Commands



    public void takeDamage(int amount) {
        this.damageTokens = damageTokens - amount;
    }

    public boolean isAlive() {
        if(this.status != Constants.Status.DEAD) {
            return true;
        }
        return false;
    }

    public boolean isPowerDown() {
        if(this.status == Constants.Status.POWERDOWN) {
            return true;
        }
        return false;
    }

    /**
     * Kill player
     */
    public void kill() {
        setStatus(Constants.Status.DEAD);
        loseLifeToken();
        backToCheckpoint();
        resetDamageTokens();
    }
    /**
     * Helpers to kill player
     */
    public void loseLifeToken() {
        this.lifeTokens = lifeTokens--;
    }

    public void backToCheckpoint() {
        if (checkpoint != null) {
            this.position = checkpoint;
        }
    }

    public void resetDamageTokens() {
        this.damageTokens = 0;
    }
    /** End of kill */

    // Setters

    public void setPosition(Position p) {
        this.position = p;
    }

    public void setCheckpoint(Position p) {
        this.checkpoint = p;
    }

    public void setDirection(Constants.Directions d) {
        this.direction = d;
    }

    public void setDealtCards(ArrayList<RegisterCard> cards) {
        this.dealtCards = cards;
    }

    public void setProgrammedCard(int index, RegisterCard c) {
        if (index >= 0 && index < 5) {
            programmedCards[index] = c;
        }
        else {
            throw new IllegalArgumentException("Index must be between 0 and 4");
        }
    }

    public void setStatus(Constants.Status s) {
        this.status = s;
    }

}