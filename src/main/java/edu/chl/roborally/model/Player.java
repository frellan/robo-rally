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

    private final Robot robot;
    private int lifeTokens;
    private int damageTokens;
    private final int id;
    private Position position;
    private Position checkpoint;
    private int checkpointID;
    private Constants.Directions direction;
    private ArrayList<RegisterCard> dealtCards;
    private RegisterCard[] programmedCards;
    private Constants.Status status;
    private int laserPower;
    private Position nextPosition;
    private Constants.Directions movingDirection;

    public Player(int id, Robot robot) {
        this.id = id;
        this.robot = robot;
        this.lifeTokens = 3;
        this.damageTokens = 0;
        this.direction = Constants.Directions.EAST;
        this.programmedCards = new RegisterCard[5];
        this.status = Constants.Status.ALIVE;
        this.laserPower = 1;
        this.checkpointID = 0;
    }

    /*
    Class methods
     */

    /**
     * Locks cards depending on the amount of damage tokens.
     */
    private void lockOrUnlockCards() {
        programmedCards[4].setLocked(false);
        programmedCards[3].setLocked(false);
        programmedCards[2].setLocked(false);
        programmedCards[1].setLocked(false);
        programmedCards[0].setLocked(false);
        switch (damageTokens) {
            case 9:
                programmedCards[4].setLocked(true);
            case 8:
                programmedCards[3].setLocked(true);
            case 7:
                programmedCards[2].setLocked(true);
            case 6:
                programmedCards[1].setLocked(true);
            case 5:
                programmedCards[0].setLocked(true);
        }
    }

    /**
     * Decreases life tokens by one.
     */
    private void loseLifeToken() {
        this.lifeTokens = lifeTokens - 1;
        if (this.lifeTokens <= 0) {
            setStatus(Constants.Status.KAPUT);
            System.out.println(this.robot.getName() + " is now Kaput and lost");
        }
    }

    /**
     * Resets the damage tokens.
     */
    private void resetDamageTokens() {
        this.damageTokens = 0;
        lockOrUnlockCards();
    }

    /*
    Commands
    */

    /**
     * Empties the players programmed cards.
     * If it encounters a locked card it places it back into the register.
     */
    public void emptyProgrammedCards() {
        ArrayList<RegisterCard> tempLockedCards = new ArrayList<>();
        for (RegisterCard programmedCard : programmedCards) {
            if (programmedCard.isLocked()) {
                tempLockedCards.add(programmedCard);
            }
        }
        programmedCards = new RegisterCard[5];
        for (int i = 0; i < tempLockedCards.size(); i++) {
            programmedCards[4 - i] = tempLockedCards.get(i);
        }
    }

    /**
     * Give a player damage tokens.
     * @param amount The amount of damage tokes to give.
     */
    public void takeDamage(int amount) {
        this.damageTokens = damageTokens + amount;
        if (this.damageTokens > 4) {
            lockOrUnlockCards();
        }
        else if (this.damageTokens == 10) {
            this.kill();
        }
    }

    /**
     * Repairs and decreases the amount of damage on player.
     */
    public void repair() {
        if (this.damageTokens > 0) {
            this.damageTokens--;
        } else {
            this.damageTokens = 0;
        }
        lockOrUnlockCards();
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
     * Kills the robot changing its status. Then removes one life token,
     * puts the robot back on its checkpoint and resets its damage tokens.
     */
    public void kill() {
        setStatus(Constants.Status.DEAD);
        loseLifeToken();
        backToCheckpoint();
        resetDamageTokens();
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
     * Returns this players specific integer ID.
     * @return The players integer ID.
     */
    public int getID() {
        return id;
    }

    /**
     * Returns the color of the players robot character, used in console.
     * @return The robot character color.
     */
    public Color getColor(){
        return robot.getColor();
    }

    /**
     * Returns the players next position.
     * @return The next position.
     */
    public Position getNextPosition() {
        return this.nextPosition;
    }

    /**
     * Returns the players current position.
     * @return The current position.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Return the current direction that the player is traveling
     * @return The players moving direction
     */
    public Constants.Directions getMovingDirection() {
        return movingDirection;
    }

    /**
     * Returns the current direction of the player.
     * @return The players direction.
     */
    public Constants.Directions getDirection() {
        return direction;
    }

    /**
     * Returns the players life tokens.
     * @return The amount of life tokens
     */
    public int getLifeTokens() {
        return lifeTokens;
    }

    /**
     * Returns the players damage tokens.
     * @return The amount of damage tokens
     */
    public int getDamageTokens() {
        return damageTokens;
    }

    /**
     * Returns the position of the players current checkpoint.
     * @return The checkpoint position.
     */
    public Position getCheckpoint() {
        return checkpoint;
    }

    /**
     * Returns the integer ID of players current checkpoint.
     * @return The id of the checkpoint.
     */
    public int getCheckpointID() {
        return checkpointID;
    }

    /**
     * Returns the players dealt cards.
     * @return A list containing all dealt cards.
     */
    public ArrayList<RegisterCard> getDealtCards() {
        return dealtCards;
    }

    /**
     * Returns a programmed card from a specified position in the register array.
     * @param index The index of the register array.
     * @return The programmed card at specific index.
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
     * Returns all players programmed cards.
     * @return Array containing all programmed cards.
     */
    public RegisterCard[] getProgrammedCards() {
        return programmedCards;
    }

    /**
     * Returns the current status of the player.
     * @return The player status.
     */
    public Constants.Status getStatus() {
        return status;
    }

    /**
     * Returns the players current laser power.
     * @return The current laser power.
     */
    public int getLaserPower() {
        return laserPower;
    }

    /**
     * Returns the image of the players robot character.
     * @return The image of the players robot character.
     */
    public BufferedImage getImage(){
        return robot.getImage();
    }

    /**
     * Returns if the player is alive or not.
     * @return True if player is alive, false if not.
     */
    public boolean isAlive() {
        return status == Constants.Status.ALIVE;
    }

    /**
     * Returns if the players is kaput or not.
     * @return True if player is kaput, false if not.
     */
    public boolean isKaput() {
        return status == Constants.Status.KAPUT;
    }

    /**
     * Returns if the player is dead not not.
     * @return True if player is dead, false if not.
     */
    public boolean isDead() {
        return status == Constants.Status.DEAD;
    }

    /**
     * Returns if the player is powered down.
     * @return True if player is powered down, false if now.
     */
    public boolean isPowerDown() {
        return status == Constants.Status.POWERDOWN;
    }

    /*
    Setters
     */

    /**
     * Sets the players next position.
     * @param p A position on the game board.
     */
    public void setNextPosition(Position p) {
        this.nextPosition  = p;
    }

    /**
     * Sets the players current position.
     * @param p A position on the game board.
     */
    public void setPosition(Position p) {
        this.position = p;
    }

    /**
     * Sets a the players direction.
     * @param d A direction, either NORTH, SOUTH, WEST or EAST.
     */
    public void setDirection(Constants.Directions d) {
        this.direction = d;
    }

    /**
     * Sets the players moving direction.
     * @param movingDirection the players moving direction.`
     */
    public void setMovingDirection(Constants.Directions movingDirection) {
        this.movingDirection = movingDirection;
    }

    /**
     * Sets a checkpoint to a player.
     * @param id Gives the player the checkpointID of the checkpoint.
     */
    public void setCheckpointID(int id) {
        this.checkpointID = id;
    }

    /**
     * Sets a new checkpoint.
     * @param p A position on the game board.
     */
    public void setCheckpoint(Position p) {
        this.checkpoint = p;
    }

    /**
     * Sets a players dealt cards.
     * @param cards An ArrayList containing dealt cards.
     */
    public void setDealtCards(ArrayList<RegisterCard> cards) {
        this.dealtCards = cards;
    }

    /**
     * Sets a players programmed card into its register.
     * @param index The register index to set the card for.
     * @param card The card to set.
     */
    public void setProgrammedCard(int index, RegisterCard card) {
        if (index >= 0 && index < 5) {
            programmedCards[index] = card;
        }
        else {
            throw new IllegalArgumentException("Index must be between 0 and 4");
        }
    }

    /**
     * Sets a players status.
     * @param s A status. This can either be ALIVE, DEAD, POWERDOWN or KAPUT.
     */
    public void setStatus(Constants.Status s) {
        this.status = s;
    }

    /**
     * Sets a players laser power.
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
     * @param g The graphics object to use when painting.
     * @param x X coordinate on the screen to draw.
     * @param y Y coodinate on the screen to draw.
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