package edu.chl.roborally.utilities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Created by frellAn on 2015-05-20.
 */
public class GlobalImageHolder {

    private static GlobalImageHolder lih;
    private BufferedImage mainBackgroundImage;
    private BufferedImage boardTileImage;
    private BufferedImage robotDirections;
    private BufferedImage pickCardBtnHover;

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
            robotDirections = ImageIO.read(this.getClass().getClassLoader().getResource("robots/directions.png"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("robots/directions.png could not be read");
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
}
