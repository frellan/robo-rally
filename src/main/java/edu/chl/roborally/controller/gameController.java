package edu.chl.roborally.controller;

import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.view.TerminalOutput;

/**
 * Created by henriknilson on 22/04/15.
 */
public class GameController {

    private TerminalOutput console;
    private RoboRally model;

    public GameController(TerminalOutput console){
        this.console = console;

        newRoboRally();

    }

    public void newRoboRally() {
        model = new RoboRally(this, console);
    }
}
