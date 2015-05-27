package edu.chl.roborally.model.cards;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by fredrikkindstrom on 26/03/15.
 */
public class CardDeck {

    private ArrayList<RegisterCard> deck;

    public CardDeck() {
        reset();
    }

    /*
    Commands
     */

    /**
     * Resets the deck and recreates all the cards in order. "Unshuffles them".
     * Use this after the getCards() method to get a full deck again.
     */
    public void reset() {

        deck = new ArrayList<>();

        // MOVE_ONE Cards
        int point = 490;
        for (int i = 1; i <= 18; i++) {
            deck.add(new MoveOneCard(point));
            point = point + 10;
        }
        // MOVE_TWO Cards
        point = 670;
        for (int i = 1; i <= 12; i++) {
            deck.add(new MoveTwoCard(point));
            point = point + 10;
        }
        // MOVE_THREE Cards
        point = 790;
        for (int i = 1; i <= 6; i++) {
            deck.add(new MoveThreeCard(point));
            point = point + 10;
        }
        // BACKUP Cards
        point = 430;
        for (int i = 1; i <= 6; i++) {
            deck.add(new BackupCard(point));
            point = point + 10;
        }
        // ROTATE_LEFT Cards
        point = 70;
        for (int i = 1; i <= 18; i++) {
            deck.add(new RotateLeftCard(point));
            point = point + 20;
        }
        // ROTATE_RIGHT Cards
        point = 80;
        for (int i = 1; i <= 18; i++) {
            deck.add(new RotateRightCard(point));
            point = point + 20;
        }
        // U_TURN Cards
        point = 10;
        for (int i = 1; i <= 6; i++) {
            deck.add(new UTurnCard(point));
            point = point + 10;
        }
    }

    /**
     * Shuffles the deck. Use this before getting cards.
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * Adds a card back to the deck.
     * @param card A single card to be added back to the deck.
     */
    public void addCard(RegisterCard card) {
        deck.add(card);
    }

    /**
     * Adds a set of cards back to the deck.
     * @param cards A set of cards to be added back to the deck.
     */
    public void addCards(ArrayList<RegisterCard> cards) {
        for (RegisterCard card : cards) {
            deck.add(card);
        }
    }

    /*
    Getters
     */

    /**
     * Returns the deck in its entirety.
     * @return All cards.
     */
    public ArrayList<RegisterCard> getAllCards() {
        return deck;
    }

    /**
     * Return the desired amount of cards and then removes them from the deck.
     * This happens to prevent retrieving doubles of the same card.
     * Use shuffle() before a new round.
     * @param amount The desired amount of cards.
     * @return The amount of cards.
     */
    public ArrayList<RegisterCard> getCards(int amount) {
        ArrayList<RegisterCard> tempDeck = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            tempDeck.add(deck.get(i));
            deck.remove(i);
        }
        return tempDeck;
    }

}
