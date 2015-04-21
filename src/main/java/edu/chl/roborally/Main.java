package edu.chl.roborally;

import edu.chl.roborally.controller.Controller;
import edu.chl.roborally.view.View;
import javax.swing.*;

public final class Main {

	private static JFrame mainFrame;

	private Main() {
		/* No instances allowed! */
	}

	public static void main(String[] args) {

		mainFrame = new JFrame();
		initFrame();
		new Controller(new View());
	}

	private static void initFrame() {
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(1000, 600);
		mainFrame.setTitle("RoboRally");
		mainFrame.setVisible(true);
	}
}
