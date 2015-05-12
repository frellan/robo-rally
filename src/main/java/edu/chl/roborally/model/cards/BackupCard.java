package edu.chl.roborally.model.cards;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.*;
import edu.chl.roborally.utilities.Constants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by fredrikkindstrom on 31/03/15.
 */
public class BackupCard extends RegisterCard{

    public BackupCard(int points, boolean isHidden) {
        super(points, isHidden, "Back Up");
        try {
            super.image = ImageIO.read(this.getClass().getClassLoader().getResource("tupp.jpg"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("Card image could not be read");
        }
    }

    public void doAction(Player p) {
        //TODO
       new BackUpPlayer(p);
    }
}
