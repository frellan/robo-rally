package edu.chl.roborally.utilities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Created by frellAn on 2015-05-20.
 */
public class LargeImageHolder {

    private static LargeImageHolder lih;
    private BufferedImage mainBackgroundImage;
    private BufferedImage boardTileImage;
    private BufferedImage robotDirections;

    private LargeImageHolder() {
        try {
            boardTileImage = ImageIO.read(this.getClass().getClassLoader().getResource("maps/board_tiles.png"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("board_tiles.png could not be read");
        }
        try {
            mainBackgroundImage = ImageIO.read(this.getClass().getClassLoader().getResource("roborally_start.jpg"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("roborally_start.jpg could not be read");
        }
        try {
            robotDirections = ImageIO.read(this.getClass().getClassLoader().getResource("robots/directions.png"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("robots/twitch.png could not be read");
        }
    }

    public static LargeImageHolder getInstance(){
        if(lih == null){
            lih = new LargeImageHolder();
        }
        return lih;
    }

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
