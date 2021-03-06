package edu.chl.roborally;

import edu.chl.roborally.controller.AppController;
import edu.chl.roborally.view.GUI;

import javax.swing.*;

public final class Main {

	private Main() {
		/* No instances allowed! */
	}

	public static void main(String[] args) {
		try {
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
		}
		catch (Exception e) {
            try {
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName());
            } catch (Exception f) {
                f.printStackTrace();
            }
        }
        new AppController();
		new GUI();
    }
}
