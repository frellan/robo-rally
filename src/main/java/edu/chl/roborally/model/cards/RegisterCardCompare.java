package edu.chl.roborally.model.cards;

import java.util.Comparator;

/**
 * Created by fredrikkindstrom on 31/03/15.
 *
 * Comparator for all the card classes. Compares the priority points of the cards.
 */
public class RegisterCardCompare implements Comparator<RegisterCard> {

    @Override
    public int compare(RegisterCard o1, RegisterCard o2) {
        return o2.getPoints() - o1.getPoints();
    }
}
