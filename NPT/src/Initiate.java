import java.awt.BorderLayout;

import model.Model;
import view.View;
import controller.Controller;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Initiate {
	private JFrame frame;

	public Initiate() {
		setFrame();
		buildMVC();
		frame.setVisible(true);
	}

	private void setFrame() {
		frame = new JFrame("Guess the letter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(320, 380);
//		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

	}

	private void buildMVC() {
		Model model = new Model();
		View view = new View(model);
		Controller control = new Controller(model, view);
		frame.add(view);
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Initiate();
			}
		});
	}
}