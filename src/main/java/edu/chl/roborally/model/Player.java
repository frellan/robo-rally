package edu.chl.roborally.model;

/**
 * Created by Pertta on 15-03-26.
 */
public class Player {

    private String name;
    private int lifeTokens;
    private int damageTokens;

    //Constructor

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int lifeTokens, int damageTokens) {
        this.name = name;
        this.lifeTokens = lifeTokens;
        this.damageTokens = damageTokens;
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

    //Commands

    public void loseLifeToken() {
        this.lifeTokens = lifeTokens--;
    }

    public void takeDamage(int amount) {
        this.damageTokens = damageTokens - amount;
    }


}
