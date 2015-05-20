package edu.chl.roborally.utilities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Created by frellAn on 2015-05-20.
 */
public class LargeImageHolder {

    private static LargeImageHolder lih;
    private static BufferedImage boardTileImage;

    public LargeImageHolder() {
        try {
            boardTileImage = ImageIO.read(this.getClass().getClassLoader().getResource("board_tiles.png"));
        }catch(java.io.IOException | NullPointerException e){
            System.out.println("board_tiles.png could not be read");
        }
    }

    public static LargeImageHolder getInstance(){
        if(lih == null){
            lih = new LargeImageHolder();
        }
        return lih;
    }

    public static BufferedImage getBoardTileImage() {
        return boardTileImage;
    }
}
