package edu.chl.roborally.model.cards;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.gameactions.*;
import edu.chl.roborally.utilities.EventTram;

import javax.imageio.ImageIO;

/**
 * Created by fredrikkindstrom on 31/03/15.
 */
public class BackupCard extends RegisterCard{

    public BackupCard(int points) {
        super(points, "Back Up");
        super.setAction(new BackUpPlayer());
        try {
            super.mainImage = ImageIO.read(this.getClass().getClassLoader().getResource("cards/backup.png"));
            super.pickImage = ImageIO.read(this.getClass().getClassLoader().getResource("cards/backup_pick.png"));
            super.pickImageRollover = ImageIO.read(this.getClass().getClassLoader().getResource("cards/backup_pick_rollover.png"));
        } catch (java.io.IOException | NullPointerException e){
            System.out.println("Card mainImage could not be read");
        }
        cardMessage = "Backed Up";
    }

    public void doAction(Player p) {

    }
}
