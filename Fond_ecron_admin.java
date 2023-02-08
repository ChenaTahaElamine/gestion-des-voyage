package Les_Phond_ecron;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fond_ecron_admin extends JPanel {
	ImageIcon i;

	public Fond_ecron_admin() {
		this.setLayout(null);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		i = new ImageIcon(
				"C:\\Users\\WinTen\\OneDrive\\Bureau\\Applicactio_eclipce_web_dynamic\\workSpace\\miniprogect_AGGON\\src\\Les_photo\\Photo_admin.png");
		// this.add(i);
		i.paintIcon(this, g, 0, 0);
	}
}
