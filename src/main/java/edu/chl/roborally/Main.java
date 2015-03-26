package edu.chl.roborally;

import edu.chl.roborally.controller.Controller;
import edu.chl.roborally.model.RoboRally;

public final class Main {
	private Main() {
		/* No instances allowed! */
	}

	public static void main(String[] args) {
		final RoboRally roboRally = new RoboRally();
		Controller.create(roboRally);
	}
}
