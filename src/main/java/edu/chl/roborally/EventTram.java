package edu.chl.roborally;

import java.util.ArrayList;
import java.util.List;

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

        START_SETUP,
        SET_NAMES,
        SET_MAP,
        INIT_SETUP
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

        for(IEventHandler evh : handlers){
            evh.onEvent(evt, data);
        }
    }

    //Set trace-value
    public void setTrace(boolean b){
        this.trace = b;
    }
}
