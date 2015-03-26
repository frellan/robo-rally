package edu.chl.change2projectname.controller;

import edu.chl.change2projectname.model.Project;
import edu.chl.change2projectname.view.ProjectView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectController {
	private final Project project;
	private final ProjectView projectView;
	public static final int KO = 1;

	public static ProjectController create(Project project, ProjectView projectView) {
		return new ProjectController(project, projectView);
	}

	private ProjectController(Project project, ProjectView projectView) {
		projectView.getButton().addActionListener(new ProjectButtonPressed());

		this.project = project;
		this.projectView = projectView;
	}

	private class ProjectButtonPressed implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			project.incrementPresses();
			projectView.getPressesLabel().setText(String.valueOf(project.getPresses()));
		}
	}
}
