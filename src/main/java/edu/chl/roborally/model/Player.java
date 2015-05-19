package edu.chl.roborally.model;


import edu.chl.roborally.model.cards.RegisterCard;
import edu.chl.roborally.model.tiles.attributes.CheckpointAttribute;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.utilities.Position;

import java.awt.*;
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
    private int checkpointId;
    private Constants.Directions direction;
    private ArrayList<RegisterCard> dealtCards;
    private ArrayList<RegisterCard> programmedCards;
    private Constants.Status status;
    private int laserPower;

    //Constructor

    public Player(int iD, String name) {
        this.iD = iD;
        this.name = name;
        this.lifeTokens = 3;
        this.damageTokens = 0;
        this.direction = Constants.Directions.EAST;
        this.programmedCards = new ArrayList<>();
        this.status = Constants.Status.ALIVE;
        this.laserPower = 1;
        this.checkpointId = 0;
    }

    /**
     * Getters
     */

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

    public Position getCheckpoint() {
        return checkpoint;
    }

    public int getCheckpointId() {
        return checkpointId;
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
            return programmedCards.get(index);
        }
        else {
            throw new IllegalArgumentException("Index must be between 0 and 4");
        }
    }

    public ArrayList<RegisterCard> getProgrammedCards() {
        return programmedCards;
    }

    public Constants.Status getStatus() {
        return this.status;
    }

    public int getLaserPower() {
        return laserPower;
    }

    public boolean isAlive() {
        return this.status != Constants.Status.DEAD;
    }

    public boolean isPowerDown() {
        return this.status == Constants.Status.POWERDOWN;
    }

    /**
     * Commands
     */

    public void emptyProgrammedCards() {
        programmedCards.clear();
    }

    /**
     * Give a player a damage token.
     * @param amount
     */
    public void takeDamage(int amount) {
        this.damageTokens = damageTokens + amount;
        if (this.damageTokens > 3) {
            lockCards();
        }
        if (this.damageTokens == 9) {
            this.kill();
        }
    }

    /**
     * Repairs and decreases the amount of damage on player
     */
    public void repair() {
        if (this.damageTokens > 0) {
            this.damageTokens = damageTokens--;
        } else {
            this.damageTokens = 0;
        }
    }

    public void lockCards() {
        if (this.damageTokens == 4) {
            programmedCards[4].setLocked(true);
        }
        else if (this.damageTokens == 5) {
            programmedCards[3].setLocked(true);
        }
        else if (this.damageTokens == 6) {
            programmedCards[2].setLocked(true);
        }
        else if (this.damageTokens == 7) {
            programmedCards[1].setLocked(true);
        }
        else if (this.damageTokens == 8) {
            programmedCards[0].setLocked(true);
        }
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
        this.lifeTokens = lifeTokens -1;
        if (this.lifeTokens == -1) {
            setStatus(Constants.Status.KAPUT);
            System.out.println(this.getName() + " is now Kaput and lost");
        }
    }

    public void setCheckpointId(int id) {
        this.checkpointId = id;
    }

    public void backToCheckpoint() {
        if (checkpoint != null) {
            this.position = checkpoint;
        }
    }

    public void resetDamageTokens() {
        this.damageTokens = 0;
    }

    /**
     * Setters
     */

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
            programmedCards.add(c);
        }
        else {
            throw new IllegalArgumentException("Index must be between 0 and 4");
        }
    }

    public void setStatus(Constants.Status s) {
        this.status = s;
    }

    public void setLaserPower(int upgrade) {
        this.laserPower = upgrade;
    }

    /**
     * Graphics method
     */

    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, Constants.TILE_SIZE, Constants.TILE_SIZE);
        g.setColor(Color.BLACK);
        g.drawString(getName()+ " " + getDirection(), x+15, y+15);
        char[] position = getPosition().toString().toCharArray();
        g.drawChars(position, 0, position.length,
                x-2, y+30);
    }
}