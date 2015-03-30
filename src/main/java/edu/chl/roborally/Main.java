package edu.chl.roborally;

import edu.chl.roborally.controller.Controller;
import edu.chl.roborally.model.RoboRally;
import edu.chl.roborally.view.View;

public final class Main {
	private Main() {
		/* No instances allowed! */
	}

	public static void main(String[] args) {

        final RoboRally roboRally = new RoboRally();
        final View view = new View();
        final Controller controller = new Controller(roboRally, view);
	}
}
