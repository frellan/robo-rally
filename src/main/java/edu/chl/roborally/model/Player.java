package edu.chl.roborally.model;


import edu.chl.roborally.model.cards.RegisterCard;
import edu.chl.roborally.model.robot.Robot;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.utilities.GlobalImageHolder;
import edu.chl.roborally.utilities.Position;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Pertta on 15-03-26.
 *
 * Creates a player
 */
public class Player {

    private Robot robot;
    private int lifeTokens;
    private int damageTokens;
    private int iD;
    private Position position;
    private Position checkpoint;
    private int checkpointId;
    private Constants.Directions direction;
    private ArrayList<RegisterCard> dealtCards;
    private RegisterCard[] programmedCards;
    private Constants.Status status;
    private int laserPower;
    private Position beforePosition;

    public Player(int iD, Robot robot) {
        this.iD = iD;
        this.robot = robot;
        this.lifeTokens = 3;
        this.damageTokens = 0;
        this.direction = Constants.Directions.EAST;
        this.programmedCards = new RegisterCard[5];
        this.status = Constants.Status.ALIVE;
        this.laserPower = 1;
        this.checkpointId = 0;
    }

    /*
    Commands
    */

    /**
     * Empties the players programmed cards
     */
    public void emptyProgrammedCards() {
        ArrayList<RegisterCard> tempLockedCards = new ArrayList<>();
        for (int i = 0; i<programmedCards.length; i++) {
            if (programmedCards[i].isLocked()) {
                tempLockedCards.add(0,programmedCards[i]);
            }
        }
        programmedCards = new RegisterCard[5];
        for (int i = 0; i< tempLockedCards.size(); i++) {
            programmedCards[4-i] = tempLockedCards.get(i);
        }
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
        else if (this.damageTokens == 9) {
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

    /**
     * Locks cards dependeing on players amount of damage tokens
     */
    public void lockCards() {
        switch (this.damageTokens) {
            case 5:
                programmedCards[4].setLocked(true);
                break;
            case 6:
                programmedCards[3].setLocked(true);
                break;
            case 7:
                programmedCards[2].setLocked(true);
                break;
            case 8:
                programmedCards[1].setLocked(true);
                break;
            case 9:
                programmedCards[0].setLocked(true);
                break;
        }
    }

    /*
    Getters
     */

    /**
     * Returns the name of the player.
     * @return The player name.
     */
    public String getName() {
        return robot.getName();
    }

    /**
     * Returns the players previous position
     * @return Previous position
     */
    public Position getBeforePosition() {
        return this.beforePosition;
    }

    /**
     * @return Players amount of lifetokens
     */
    public int getLifeTokens() {
        return lifeTokens;
    }

    /**
     * @return Players amount of Damagetokens
     */
    public int getDamageTokens() {
        return damageTokens;
    }

    /**
     * Returns this players specific integer ID
     * @return Players ID
     */
    public int getiD() {
        return iD;
    }

    /**
     * Returns the color of the player, used in console
     * @return Players color
     */
    public Color getColor(){
        return robot.getColor();
    }

    /**
     * @return Players position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Returns the position of the players current Checkpoint
     * @return Checkpoint position
     */
    public Position getCheckpoint() {
        return checkpoint;
    }

    /**
     * Returns the integer ID of players current checkpoint
     * @return Checkpoint ID
     */
    public int getCheckpointId() {
        return checkpointId;
    }

    /**
     * Returns the direction of the player
     * @return Player direction
     */
    public Constants.Directions getDirection() {
        return direction;
    }

    /**
     * Returns the players dealt cards
     * @return All dealt cards
     */
    public ArrayList<RegisterCard> getDealtCards() {
        return dealtCards;
    }

    /**
     * Returns a programmed card from a specified position in the array
     * @param index
     * @return Player programmed card
     */
    public RegisterCard getProgrammedCard(int index) {
        if (index >= 0 && index < 5) {
            return programmedCards[index];
        }
        else {
            throw new IllegalArgumentException("Index must be between 0 and 4");
        }
    }

    /**
     * Returns players programmed cards.
     * @return Programmed cards
     */
    public RegisterCard[] getProgrammedCards() {
        return programmedCards;
    }

    /**
     * Returns the current status of the player
     * @return Player status
     */
    public Constants.Status getStatus() {
        return this.status;
    }

    /**
     * Returns the players current laserpower
     * @return Players laserpower
     */
    public int getLaserPower() {
        return laserPower;
    }

    /**
     * Returns the image of the Players robot
     * @return
     */
    public BufferedImage getImage(){
        return robot.getImage();
    }

    /**
     * @return True if player is alive
     */
    public boolean isAlive() {
        return Constants.Status.ALIVE == this.status;
    }

    /**
     * @return True if player is kaput.
     */
    public boolean isKaput() {
        return this.status == Constants.Status.KAPUT;
    }

    /**
     * @return True if player is dead.
     */
    public boolean isDead() {
        return this.status == Constants.Status.DEAD;
    }

    /**
     * @return True if player is Powered down.
     */
    public boolean isPowerDown() {
        return this.status == Constants.Status.POWERDOWN;
    }

    /*
    Helpers
     */

    /**
     * Kills the robot changing its status, decreasing its lifeTokens, puts the robot back on its checkpoint
     * and reset damageTokens.
     */
    public void kill() {
        setStatus(Constants.Status.DEAD);
        loseLifeToken();
        backToCheckpoint();
        resetDamageTokens();
    }

    /**
     * Decreases lifeTokens.
     */
    public void loseLifeToken() {
        this.lifeTokens = lifeTokens - 1;
        if (this.lifeTokens < 0) {
            setStatus(Constants.Status.KAPUT);
            System.out.println(this.robot.getName() + " is now Kaput and lost");
        }
    }


    /**
     * Puts the robot back to its checkpoint.
     */
    public void backToCheckpoint() {
        if (checkpoint != null) {
            this.position = this.checkpoint;
        }
    }

    /**
     * Resets the robots damageTokens.
     */
    public void resetDamageTokens() {
        this.damageTokens = 0;
    }

    /*
    Setters
     */

    /**
     * Sets a checkpoint to a robot.
     * @param id Gives the robot the checkpointId of the checkpoint.
     */
    public void setCheckpointId(int id) {
        this.checkpointId = id;
    }

    /**
     * Sets the robots before position.
     * @param p An  x and y position on the gameboard.
     */
    public void setBeforePosition(Position p) {
        this.beforePosition  = p;
    }

    /**
     * Sets the robots current position.
     * @param p An  x and y position on the gameboard.
     */
    public void setPosition(Position p) {
        this.position = p;
    }

    /**
     * Sets a new checkpoint.
     * @param p An  x and y position on the gameboard.
     */
    public void setCheckpoint(Position p) {
        this.checkpoint = p;
    }

    /**
     * Sets a robots direction.
     * @param d A direction, either NORTH, SOUTH, WEST or EAST.
     */
    public void setDirection(Constants.Directions d) {
        this.direction = d;
    }

    /**
     * Sets a robots dealt cards.
     * @param cards An ArrayList containing dealt cards.
     */
    public void setDealtCards(ArrayList<RegisterCard> cards) {
        this.dealtCards = cards;
    }

    /**
     * Sets a robots programmed cards(the cards to be played).
     * @param index Decides in what orders the cards will be set.
     * @param c A RegisterCard.
     */
    public void setProgrammedCard(int index, RegisterCard c) {
        if (index >= 0 && index < 5) {
            programmedCards[index] = c;
        }
        else {
            throw new IllegalArgumentException("Index must be between 0 and 4");
        }
    }

    /**
     * Sets a robots status.
     * @param s A status. This can either be ALIVE, DEAD, POWERDOWN or KAPUT.
     */
    public void setStatus(Constants.Status s) {
        this.status = s;
    }

    /**
     * Sets a robots laserpower.
     * @param upgrade An int deciding how much the laser should be upgraded.
     */
    public void setLaserPower(int upgrade) {
        this.laserPower = upgrade;
    }

    /*
    Graphics
     */

    /**
     * Draw method which draws the player on the board with the right direction.
     * @param g Graphics.
     * @param x X Coordinate.
     * @param y Y Coordinate.
     */
    public void draw(Graphics g, int x, int y) {
        BufferedImage robotDirections = GlobalImageHolder.getInstance().getRobotDirections();
        BufferedImage currentRobot = robot.getImage();
        BufferedImage currentDirection;
        g.drawImage(currentRobot, x, y, null);
        switch (direction) {
            case NORTH:
                currentDirection = robotDirections.getSubimage(0, 0, Constants.TILE_SIZE, Constants.TILE_SIZE);
                break;
            case SOUTH:
                currentDirection = robotDirections.getSubimage(Constants.TILE_SIZE, 0, Constants.TILE_SIZE, Constants.TILE_SIZE);
                break;
            case WEST:
                currentDirection = robotDirections.getSubimage(2*Constants.TILE_SIZE, 0, Constants.TILE_SIZE, Constants.TILE_SIZE);
                break;
            case EAST:
                currentDirection = robotDirections.getSubimage(3*Constants.TILE_SIZE, 0, Constants.TILE_SIZE, Constants.TILE_SIZE);
                break;
            default:
                currentDirection = null;
        }
        g.drawImage(currentDirection, x, y, null);
    }
}