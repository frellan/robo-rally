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

    //Constructor

    public Player(int iD, String name) {
        this.iD = iD;
        this.name = name;
        this.lifeTokens = 3;
        this.damageTokens = 0;
        this.direction = Constants.Directions.NORTH;
        this.programmedCards = new RegisterCard[4];
    }

    //Queries

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
        return programmedCards[index];
    }

    public RegisterCard[] getProgrammedCards() {
        return programmedCards;
    }

    //Commands

    public void loseLifeToken() {
        this.lifeTokens = lifeTokens--;
    }

    public void takeDamage(int amount) {
        this.damageTokens = damageTokens - amount;
    }

    public void toCheckpoint() {
        if (checkpoint != null) {
            this.position = checkpoint;
        }
    }

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
        this.programmedCards[index] = c;
    }

}