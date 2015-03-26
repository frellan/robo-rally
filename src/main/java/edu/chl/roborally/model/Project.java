package edu.chl.change2projectname.model;

public class Project {
	public static final String PROJECT_WINDOW_TEXT = "ProjectTemplate";
	public static final String PROJECT_BUTTON_TEXT = "Press me!";

	private int presses;

	public int getPresses() {
		return presses; 
	}

	public void incrementPresses() {
		this.presses++;
	}
}
