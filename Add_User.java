package Les_interface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Les_Phond_ecron.Phond_ecron_de_User;

public class Add_User extends JFrame implements ActionListener, KeyListener {
	JPanel panel;

	ImageIcon Icon_app;
	Phond_ecron_de_User p;
	ImageIcon icon_aggoch;
	JButton reter, logo_app, ajouter, Effacement;
	JTextField TextField_NOM_PS, TextField_PRENOM_PS, TextField_NUM_TEL, TextField_EMAIL_PS, TextField_PASSWORD_PS;
	JLabel NOM_PS, PRENOM_PS, NUM_TEL, EMAIL_PS, PASSWORD_PS;

	public Add_User() {
		show_Add_User();
	}

	public void show_Add_User() {
		// ---------< instenciation
		TextField_NOM_PS = new JTextField();
		TextField_PRENOM_PS = new JTextField();
		TextField_NUM_TEL = new JTextField();
		TextField_EMAIL_PS = new JTextField();
		TextField_PASSWORD_PS = new JTextField();
		NOM_PS = new JLabel("Le nom");
		PRENOM_PS = new JLabel("Le prenom");
		NUM_TEL = new JLabel("Numero de telephone");
		EMAIL_PS = new JLabel("Email");
		PASSWORD_PS = new JLabel("Mot de passe");
		Icon_app = new ImageIcon(
				"C:\\Users\\WinTen\\OneDrive\\Bureau\\Applicactio_eclipce_web_dynamic\\workSpace\\miniprogect_AGGON\\src\\Les_photo\\Logo_app11.png");
		icon_aggoch = new ImageIcon(
				"C:\\Users\\WinTen\\OneDrive\\Bureau\\Applicactio_eclipce_web_dynamic\\workSpace\\miniprogect_AGGON\\src\\Les_photo\\Cap_aggoch.png");
		logo_app = new JButton(Icon_app);
		reter = new JButton(icon_aggoch);
		ajouter = new JButton("Ajouter");
		Effacement = new JButton("Effacement");
		panel = new JPanel();
		p = new Phond_ecron_de_User();
		// ------------------->
		// --------< add lable
		NOM_PS.setForeground(Color.black);
		PRENOM_PS.setForeground(Color.black);
		NUM_TEL.setForeground(Color.black);
		EMAIL_PS.setForeground(Color.black);
		PASSWORD_PS.setForeground(Color.black);

		NOM_PS.setBounds(80, 40, 200, 25);
		PRENOM_PS.setBounds(80, 90, 200, 25);
		NUM_TEL.setBounds(80, 140, 200, 25);
		EMAIL_PS.setBounds(80, 190, 200, 25);
		PASSWORD_PS.setBounds(80, 240, 200, 25);
		// ---------->
		// --------< add text fild
		TextField_NOM_PS.setBounds(270, 40, 200, 25);
		TextField_PRENOM_PS.setBounds(270, 90, 200, 25);
		TextField_NUM_TEL.setBounds(270, 140, 200, 25);
		TextField_EMAIL_PS.setBounds(270, 190, 200, 25);
		TextField_PASSWORD_PS.setBounds(270, 240, 200, 25);

		// ---------->
		// ------< add button
		ajouter.setBackground(Color.darkGray);
		Effacement.setBackground(Color.darkGray);
		ajouter.setForeground(Color.white);
		Effacement.setForeground(Color.white);
		ajouter.setBounds(350, 280, 120, 25);
		Effacement.setBounds(75, 280, 120, 25);
		// ---< button logo est reter
		reter.setBounds(20, 10, 70, 40);
		logo_app.setBounds(20, 60, 150, 120);
		// ----->
		// ----------->
		// les paramatre de interface
		setTitle("Gestion des voyage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(1010, 665);
		setLocation(155, 15);
		setVisible(true);
		// ---------------------
		p.setLayout(null);
		panel.setLayout(null);
		panel.setBounds(220, 130, 550, 350);
		panel.setBackground(Color.decode("#97ccf0"));
		p.add(reter);
		p.add(logo_app);
		panel.add(NOM_PS);
		panel.add(PRENOM_PS);
		panel.add(NUM_TEL);
		panel.add(EMAIL_PS);
		panel.add(PASSWORD_PS);
		panel.add(TextField_NOM_PS);
		panel.add(TextField_PRENOM_PS);
		panel.add(TextField_NUM_TEL);
		panel.add(TextField_EMAIL_PS);
		panel.add(TextField_PASSWORD_PS);

		panel.add(ajouter);
		panel.add(Effacement);
		p.add(panel);
		add(p);
		// -------< add action listener
		reter.addActionListener(this);
		logo_app.addActionListener(this);
		ajouter.addActionListener(this);
		Effacement.addActionListener(this);
		ajouter.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					DAO.User_DAO.insert_user(TextField_NOM_PS.getText(), TextField_PRENOM_PS.getText(),
							TextField_NUM_TEL.getText(), TextField_EMAIL_PS.getText(), TextField_PASSWORD_PS.getText()

					);

				}

			}
		});
		this.addKeyListener(this);
		// ----------->
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == reter) {
			this.dispose();
			new User();
		}
		if (e.getSource() == logo_app) {
			this.dispose();
			new User();
		}
		if (e.getSource() == Effacement) {
			TextField_NOM_PS.setText("");
			TextField_PRENOM_PS.setText("");
			TextField_NUM_TEL.setText("");
			TextField_EMAIL_PS.setText("");
			TextField_PASSWORD_PS.setText("");
		}
		if (e.getSource() == ajouter) {
			DAO.User_DAO.insert_user(TextField_NOM_PS.getText(), TextField_PRENOM_PS.getText(),
					TextField_NUM_TEL.getText(), TextField_EMAIL_PS.getText(), TextField_PASSWORD_PS.getText()

			);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			DAO.User_DAO.insert_user(TextField_NOM_PS.getText(), TextField_PRENOM_PS.getText(),
					TextField_NUM_TEL.getText(), TextField_EMAIL_PS.getText(), TextField_PASSWORD_PS.getText()

			);

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
