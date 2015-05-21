package edu.chl.roborally.model.tiles.attributes;

import edu.chl.roborally.model.Player;
import edu.chl.roborally.model.Turn;
import edu.chl.roborally.model.gameactions.MovePlayer;
import edu.chl.roborally.utilities.Constants;
import edu.chl.roborally.utilities.EventTram;

import java.awt.*;

/**
 * Created by Pertta on 15-05-12.
 */
public class TurnConveyorAttribute implements Attribute {

    private Constants.Directions d;

    public TurnConveyorAttribute(Constants.Directions d) {
        this.d = d;
    }

    @Override
    public void beforeAction(Player player) {

    }

    @Override
    public void doAction(Player player) {
        new MovePlayer(player, d);
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, " Moving and Rotating ", null);
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, player .getName() , player.getColor());
        EventTram.getInstance().publish(EventTram.Event.PRINT_MESSAGE, "One Tile + Right" + "\n", null);
    }

    public String toString() {
        return "TurnConveyor";
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        char[] message;
        g.setColor(Color.BLUE);
        g.fillRect(x, y, Constants.TILE_SIZE, Constants.TILE_SIZE);
        g.setColor(Color.BLACK);
        switch (d) {
            case NORTH_WEST:
                message = "CNW".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
            case NORTH_EAST:
                message = "CNE".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
            case WEST_NORTH:
                message = "CWN".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
            case WEST_SOUTH:
                message = "CWS".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
            case SOUTH_WEST:
                message = "CSW".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
            case SOUTH_EAST:
                message = "CSE".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
            case EAST_NORTH:
                message = "CEN".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
            case EAST_SOUTH:
                message = "CES".toCharArray();
                g.drawChars(message, 0, message.length, x, y + 10);
                break;
        }

    }
}
