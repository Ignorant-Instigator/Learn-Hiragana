package model;

import java.awt.Image;
import java.util.Observable;

import javax.swing.ImageIcon;

import data.Manager;

public class Model extends Observable {
	private Manager data;
	private ImageIcon img;
	private boolean isCorrect;

	public Model() {
		data = new Manager();
		setNewImage();
	}

	public void setNewImage() {
		img = data.getRandomImage();
		setChanged();
		notifyObservers();
	}

	public ImageIcon getPic() {
		return img;
	}

	public void compare(String letter) {
		int picID = data.getIndex();
		if (letter.equals(data.getLetter(picID))) {
			isCorrect = true;
		} else
			isCorrect = false;
		setChanged();
		notifyObservers();
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public String rightLetter() {
		return data.getLetter(data.getIndex());
	}

	public ImageIcon getRed() {
		return data.getIMG("red");
	}

	public ImageIcon getGreen() {
		return data.getIMG("green");
	}
}
