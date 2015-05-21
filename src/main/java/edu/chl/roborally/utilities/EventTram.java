package edu.chl.roborally.utilities;

import java.util.ArrayList;

/**
 * Created by axel on 2015-04-28.
 */
public class EventTram {

    private static EventTram tram;

    public static EventTram getInstance(){
        if (tram == null){
            tram = new EventTram();
        }
        return tram;
    }

    public enum Event {

        /**
         * Main event to send text to ConsoleView.
         */
        PRINT_MESSAGE,

        /**
         * This event tells the GUI to show the menu
         */
        SHOW_MENU,

        /**
         * These events are used during setup to set name and map in model
         */
        SET_ROBOTS,
        SET_MAP,

        /**
         * This event tries to create a new game
         */
        CREATE_MODEL,

        /**
         * This event is fired when a new model is created
         */
        NEW_MODEL_CREATED,

        RUN_GAME,
        SHOW_GAMEPANEL,

        /**
         * Is fired when the model starts a new round.
         */
        NEW_ROUND,

        /**
         * Round executes this event when a player should
         * pick cards.
         *
         * The object is an Arraylist with ReisterCards
         */
        PICK_CARDS,

        /**
         * The view fires this event when the player
         * has choosen the cards to play.
         *
         * It return a arraylist with RegisterCards
         */
        PLAYER_PICKED_CARDS,

        /**
         * If a player chooses to powerdown, this event is fired
         * and a player is sent with the event
         */
        POWER_DOWN,

        /**
         * Is fired when the Model is ready for new turn.
         */
        READY_FOR_NEW_TURN,

        /**
         * Is fired when the GameController starts a new turn.
         */
        NEW_TURN,

        /**
         * Is fired when a tile action for a player needs to happen.
         */
        EXECUTE_TILE_ACTION,

        /**
         * Use this event to repaint the gameboard
         */
        UPDATE_BOARD,

        UPDATE_STATUS,

        /**
         * This event is fired by the attribute which holds the last checkpoint
         * the event should include a player
         */
        VICTORY
    }

    //for debugging
    private boolean trace = true;

    //List of listeners
    private final ArrayList<IEventHandler> handlers = new ArrayList<>();

    //Register a listener
    public void register(IEventHandler handler){
        handlers.add(handler);
    }

    //Unregister a listener
    public void unRegister(IEventHandler handler){
        handlers.remove(handler);
    }

    //Call this method to publish an event
    public void publish(Event evt, Object data, Object data2){

        if (trace && evt != Event.PRINT_MESSAGE){
            System.out.println(evt);
        }
        for (int i = 0; i < handlers.size(); i++) {
            IEventHandler handler = handlers.get(i);
            handler.onEvent(evt, data, data2);
        }
    }

    //Set trace-value
    public void setTrace(boolean b){
        this.trace = b;
    }
}
