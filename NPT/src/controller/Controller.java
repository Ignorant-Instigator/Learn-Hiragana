package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;
import view.View;

public class Controller {
	private Model model;
	private View view;
	private boolean first;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		setListener();
	}

	private void setListener() {
		first = true;
		view.getInput().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (first) {
					model.compare(view.getText());
					view.getInput().setEditable(false);
					view.getResult().setVisible(true);
					first = false;
					if (!model.isCorrect()) {
						view.getInput().setText(model.rightLetter());
					}
				} else {
					model.setNewImage();
					view.getInput().setEditable(true);
					view.getResult().setVisible(false);
					first = true;
					view.getInput().setText("");
				}
			}
		});
	}
}
