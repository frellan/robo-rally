package edu.chl.roborally.model;

/**
 * Created by Pertta on 15-03-26.
 */
public class Player {

    private String name;
    private int lifeTokens;
    private int damageTokens;
    private int iD;

    //Constructor

    public Player(String name) {
        this.name = name;
        this.lifeTokens = 3;
        this.damageTokens = 0;
    }

    public Player(String name, int lifeTokens, int damageTokens, int iD) {
        this.name = name;
        this.lifeTokens = lifeTokens;
        this.damageTokens = damageTokens;
        this.iD = iD;
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

    //Commands

    public void loseLifeToken() {
        this.lifeTokens = lifeTokens--;
    }

    public void takeDamage(int amount) {
        this.damageTokens = damageTokens - amount;
    }

}
