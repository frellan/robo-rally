package edu.chl.roborally.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by fredrikkindstrom on 26/03/15.
 */
public class CardDeck {

    private ArrayList<RegisterCard> deck;

    public CardDeck() {
        
        deck = new ArrayList<>();

        // MOVE_ONE Cards
        int point = 490;
        for (int i = 1; i <= 18; i++) {
            deck.add(new RegisterCard(RegisterCard.MoveTypes.MOVE_ONE,point));
            point = point + 10;
        }

        // MOVE_TWO Cards
        point = 670;
        for (int i = 1; i <= 12; i++) {
            deck.add(new RegisterCard(RegisterCard.MoveTypes.MOVE_TWO,point));
            point = point + 10;
        }

        // MOVE_THREE Cards
        point = 790;
        for (int i = 1; i <= 6; i++) {
            deck.add(new RegisterCard(RegisterCard.MoveTypes.MOVE_THREE,point));
            point = point + 10;
        }

        // BACKUP Cards
        point = 430;
        for (int i = 1; i <= 6; i++) {
            deck.add(new RegisterCard(RegisterCard.MoveTypes.BACKUP,point));
            point = point + 10;
        }

        // ROTATE_LEFT Cards
        point = 70;
        for (int i = 1; i <= 18; i++) {
            deck.add(new RegisterCard(RegisterCard.MoveTypes.ROTATE_LEFT,point));
            point = point + 20;
        }

        // ROTATE_RIGHT Cards
        point = 80;
        for (int i = 1; i <= 18; i++) {
            deck.add(new RegisterCard(RegisterCard.MoveTypes.ROTATE_RIGHT,point));
            point = point + 20;
        }

        // U_TURN Cards
        point = 10;
        for (int i = 1; i <= 6; i++) {
            deck.add(new RegisterCard(RegisterCard.MoveTypes.U_TURN,point));
            point = point + 10;
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }
}
