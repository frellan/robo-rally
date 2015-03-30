package edu.chl.roborally.model;


import java.util.ArrayList;

/**
 * Created by Pertta on 15-03-26.
 */
public class Player {

    private String name;
    private int lifeTokens;
    private int damageTokens;
    private int iD;
    private Position playerPos;
    private ArrayList<RegisterCard> hand;
    private Constants.Directions direction;

    //Constructor

    public Player(int iD, String name) {
        this.iD = iD;
        this.name = name;
        this.lifeTokens = 3;
        this.damageTokens = 0;
        this.direction = Constants.Directions.NORTH;
    }

    //Queries

    public String getName() {
        return name;
    }

    public int getLifeTokens() {
        return lifeTokens;
    }

    public int getDamagetokens() {
        return damageTokens;
    }

    public int getiD() {
        return iD;
    }

    public Position getPlayerPos() {
        return playerPos;
    }

    public Constants.Directions getDirection() {
        return direction;
    }

    //Commands

    public void loseLifeToken() {
        this.lifeTokens = lifeTokens--;
    }

    public void takeDamage(int amount) {
        this.damageTokens = damageTokens - amount;
    }

    public void setCheckpoint(Position checkpoint) {
        this.playerPos = checkpoint;
    }

    public void setHand(ArrayList<RegisterCard> cards) {
        this.hand = cards;
    }
    public void setDirection(Constants.Directions newDirection) {
        this.direction = newDirection;
    }

}
