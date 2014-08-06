package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import model.Model;

public class View extends JComponent implements Observer {
	private Model model;
	private JPanel imgPanel;
	private JPanel result;
	private JTextField input;

	public View(Model model) {
		this.model = model;
		this.model.addObserver(this);
		setLayout(new BorderLayout());
		imgPanel = new JPanel();
		result = new JPanel();
		input = new JTextField();
		setIMG(model.getPic());
		add(imgPanel);
		add(result, BorderLayout.PAGE_START);
		add(input, BorderLayout.PAGE_END);
	}

	public void setIMG(ImageIcon img) {
		imgPanel.removeAll();
		imgPanel.revalidate();
		imgPanel.add(new JLabel(img));
	}

	public void setResult(ImageIcon img) {
		result.removeAll();
		result.add(new JLabel(img));

	}

	public JTextField getInput() {
		return input;
	}

	public String getText() {
		return input.getText();
	}

	public JPanel getResult() {
		return result;
	}

	public void update(Observable arg0, Object arg1) {
		if (model.isCorrect()) {
			setResult(model.getGreen());
		} else {
			setResult(model.getRed());
		}
		setIMG(model.getPic());
	}
}
