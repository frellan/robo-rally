package edu.chl.roborally.utilities;

import java.util.ArrayList;

/**
 * Created by axel on 2015-04-28.
 */
public class EventTram {

    private static EventTram tram;
    private boolean trace = true;
    private final ArrayList<IEventHandler> handlers = new ArrayList<>();

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
         * This event tells the GUI to select the number of players.
         */
        SELECT_PLAYERS,

        /**
         * These events are used during setup to set number of players and map in model.
         *
         * The objects are the number of players and the map in question.
         */
        PLAYERS_SELECTED,
        MAP_SELECTED,

        /**
         * This event is fired when a new model is created.
         */
        MODEL_CREATED,

        /**
         * Fired when the user starts a game from the summary screen.
         */
        START_GAME,

        /**
         * Fired by game controller when the game has started.
         */
        SHOW_GAMEPANEL,

        /**
         * Is fired when the model starts a new round.
         */
        NEW_ROUND,

        /**
         * Round executes this event when a player should
         * pick cards.
         *
         * The object is the player that should pick cards.
         */
        PICK_CARDS,

        /**
         * The view fires this event when the player
         * has picked the cards to play.
         *
         * The object is the cards that was picked.
         */
        PLAYER_PICKED_CARDS,

        /**
         * If a player chooses to power down, this event is fired.
         *
         * The object is the player that chose to power down.
         */
        POWER_DOWN,

        /**
         * Is fired when the model is ready for a new turn.
         */
        READY_FOR_NEW_TURN,

        /**
         * Is fired when the game controller issues a new turn.
         */
        NEW_TURN,

        /**
         * Is fired when a tile action for a player needs to happen.
         *
         * The object is the player in question.
         */
        EXECUTE_TILE_ACTION_BEFORE,
        EXECUTE_TILE_ACTION,

        /**
         * When this is fired the view repaints game board.
         */
        UPDATE_BOARD,

        /**
         * When this is fired the view updates the status view.
         */
        UPDATE_STATUS,

        /**
         * This event is fired by the attribute which holds the last checkpoint.
         *
         * The object is the player that has won the game.
         */
        VICTORY
    }

    /**
     * Use this to register a class as a listener for events.
     * @param handler The class that wants to listen.
     */
    public void register(IEventHandler handler){
        handlers.add(handler);
    }

    /**
     * Use this to unregister a class as a listener for events.
     * @param handler The class that doesn't want to listen anymore.
     */
    public void unRegister(IEventHandler handler){
        handlers.remove(handler);
    }

    /**
     * Call this method to publish an event.
     * @param evt The type of event to issue.
     * @param data An object of any kind that may prove useful.
     * @param data2 A second object of any kind that may prove useful.
     */
    public void publish(Event evt, Object data, Object data2){

        if (trace && evt != Event.PRINT_MESSAGE){
            System.out.println(evt);
        }
        for (int i = 0; i < handlers.size(); i++) {
            IEventHandler handler = handlers.get(i);
            handler.onEvent(evt, data, data2);
        }
    }

    /**
     * If this is enabled all the events that occur will be printed to the terminal.
     * @param b True to enable printing, false to disable.
     */
    public void setTrace(boolean b){
        this.trace = b;
    }
}
