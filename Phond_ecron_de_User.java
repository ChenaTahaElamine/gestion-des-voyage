package Les_Phond_ecron;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Phond_ecron_de_User extends JPanel {

	private ImageIcon i;

	public Phond_ecron_de_User() {
		this.setLayout(null);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		i = new ImageIcon(
				"C:\\Users\\WinTen\\OneDrive\\Bureau\\Applicactio_eclipce_web_dynamic\\workSpace\\miniprogect_AGGON\\src\\Les_photo\\P123.jpg");
		// this.add(i);
		i.paintIcon(this, g, 0, 0);
	}
}
