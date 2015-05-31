package edu.chl.roborally.utilities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Created by frellAn on 2015-05-20.
 *
 * Singleton class that holds images frequently used by from different classes in the application.
 * This way they are only created once and loaded once, all in one place and no duplicates.
 */
public class GlobalImageHolder {

    private static GlobalImageHolder lih;
    private BufferedImage mainBackgroundImage;
    private BufferedImage boardTileImage;
    private BufferedImage robotDirections;
    private BufferedImage damageTokens;
    private BufferedImage heartTokens;

    private GlobalImageHolder() {
        // Global background image
        try {
            mainBackgroundImage = ImageIO.read(this.getClass().getClassLoader().getResource("roborally_start.jpg"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("roborally_start.jpg could not be read");
        }
        // Tile set
        try {
            boardTileImage = ImageIO.read(this.getClass().getClassLoader().getResource("maps/board_tiles.png"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("board_tiles.png could not be read");
        }
        // Robot direction tile set
        try {
            robotDirections = ImageIO.read(this.getClass().getClassLoader().getResource("robots/directions.png"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("robots/directions.png could not be read");
        }
        // Damage tokens
        try {
            damageTokens = ImageIO.read(this.getClass().getClassLoader().getResource("dmgtokens.png"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("dmgtokens.png could not be read");
        }
        try {
            heartTokens = ImageIO.read(this.getClass().getClassLoader().getResource("hearts.png"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("hearts.png could not be read");
        }
    }

    public static GlobalImageHolder getInstance(){
        if(lih == null){
            lih = new GlobalImageHolder();
        }
        return lih;
    }

    /*
    Getters
     */
    public BufferedImage getMainBackgroundImage() {
        return mainBackgroundImage;
    }
    public BufferedImage getBoardTileImage() {
        return boardTileImage;
    }
    public BufferedImage getRobotDirections() {
        return robotDirections;
    }
    public BufferedImage getDamageTokens() {
        return damageTokens;
    }
    public BufferedImage getHeartTokens() {
        return heartTokens;
    }
}
