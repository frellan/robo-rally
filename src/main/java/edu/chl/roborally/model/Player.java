package edu.chl.roborally.model;


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
    private Position playerPos;
    private ArrayList<RegisterCard> hand;
    private ArrayList<RegisterCard> choosenCards;
    private Constants.Directions direction;

    //Constructor

    public Player(int iD, String name) {
        this.iD = iD;
        this.name = name;
        this.lifeTokens = 3;
        this.damageTokens = 0;
        this.direction = Constants.Directions.NORTH;
        this.choosenCards = new ArrayList<>();
    }

    //Getters

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
        return playerPos;
    }

    public Constants.Directions getDirection() {
        return direction;
    }
    public void setCheckpoint(Position checkpoint) {
        this.playerPos = checkpoint;
    }

    public Position getPlayerPos() {
        return playerPos;
    }

    public ArrayList<RegisterCard> getHand() {
        return this.hand;
    }

    public ArrayList<RegisterCard> getChoosenCards() {
        return this.choosenCards;
    }
    
    public RegisterCard getCardFromHand(int index) {
        return this.hand.get(index);
    }

    // Setters

    public void setHand(ArrayList<RegisterCard> cards) {
        this.hand = cards;
    }

    public void setChoosenCards(RegisterCard c) {
        this.choosenCards.add(c);
    }

    public void setDirection(Constants.Directions newDirection) {
        this.direction = newDirection;
    }

    // Commands

    public void loseLifeToken() {
        this.lifeTokens = lifeTokens--;
    }

    public void takeDamage(int amount) {
        this.damageTokens = damageTokens - amount;
    }

}
