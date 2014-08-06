package data;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

import data.IMG.*;

public class Manager {
	private ClassLoader cldr;
	private String[] letters = { "a", "i", "u", "e", "o", "ka", "ki", "ku",
			"ke", "ko", "sa", "shi", "su", "se", "so", "ta", "chi", "tsu",
			"te", "to", "na", "ni", "nu", "ne", "no", "ha", "hi", "fu", "he",
			"ho", "ma", "mi", "mu", "me", "mo", "ya", "yu", "yo", "ra", "ri",
			"ru", "re", "ro", "wa", "i/wi", "e/we", "o/wo", "n" };
	private int imgIndex;

	public Manager() {
		cldr = this.getClass().getClassLoader();
	}

	public ImageIcon getRandomImage() {
		imgIndex = random(48);
		URL imageURL = cldr.getResource("data/IMG/" + imgIndex + ".png");
		ImageIcon img = new ImageIcon(imageURL);
		return img;

	}

	public int getIndex() {
		return imgIndex;
	}

	public String getLetter(int index) {
		return letters[index];
	}

	private int random(int range) {
		return (int) (Math.random() * range);
	}

	public ImageIcon getIMG(String string) {
		URL imageURL = cldr.getResource("data/IMG/" + string + ".png");
		ImageIcon img = new ImageIcon(imageURL);
		return img;
	}
}
