package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;

public class AdminMess extends JPanel {

	/**
	 * Create the panel.
	 */
	public AdminMess() {
		setBackground(Color.WHITE);
		setSize(684, 768);
		
		JLabel label = new JLabel("\u4E2A\u4EBA\u4FE1\u606F");
		add(label);
	}

}
