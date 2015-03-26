package edu.chl.roborally.controller;

import edu.chl.roborally.model.RoboRally;

public class Controller {
	private final RoboRally roboRally;

    private boolean run;

	public static Controller create(RoboRally roboRally) {
		return new Controller(roboRally);
	}

	private Controller(RoboRally roboRally) {
		this.roboRally = roboRally;
        this.run = true;
        play();
	}

    private void play(){
        while(run) {
            System.out.println("Running");
            this.run = false;
        }
            System.out.println("Stopped");
    }

}
