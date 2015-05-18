package edu.chl.roborally.utilities;

import java.util.ArrayList;

/**
 * Created by axel on 2015-04-28.
 */
public class EventTram {

    private static EventTram tram;

    public static EventTram getInstance(){
        if(tram == null){
            tram = new EventTram();
        }
        return tram;
    }

    public enum Event {
        /**
         * This event tells the GUI to show the menu
         */
        SHOW_MENU,
        INIT_GAME,
        SET_NAMES,
        SET_MAP,

        /**
         * This event is fired when new model is created
         */
        CREATE_MODEL,

        RUN_GAME,

        /**
         * Round executes this event when a player should
         * choose cards.
         *
         * The object is an Arraylist with ReisterCards
         *
         */
        CHOOSE_CARDS,

        /**
         * The view fires this event when the player
         * has choosen the cards to play.
         *
         * It return a arraylist with RegisterCards
         *
         */
        PLAYER_CHOOSEN_CARDS,

        SHOW_GAMEPANEL,
        NEW_TURN,

        /**
         * Use this event to reapint the gameboeard
         */
        UPDATE_BOARD,

        UPDATE_STATUS,

        /**
         * If a player chooses to powerdown, this event is fired
         * and a player is sent with the event
         */
        POWER_DOWN,

        EXECUTE_TILE_ACTION
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
    public void publish(Event evt, Object data){

        if(trace){
            System.out.println(evt);
        }
        for (int i = 0; i<handlers.size(); i++) {
            handlers.get(i).onEvent(evt, data);
        }
    }

    //Set trace-value
    public void setTrace(boolean b){
        this.trace = b;
    }
}
