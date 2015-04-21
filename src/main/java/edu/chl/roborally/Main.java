package edu.chl.roborally;

import edu.chl.roborally.controller.Controller;
import javax.swing.*;

public final class Main {

	private static JFrame mainFrame;

	private Main() {
		/* No instances allowed! */
	}

	public static void main(String[] args) {
		new Controller();
	}
}
