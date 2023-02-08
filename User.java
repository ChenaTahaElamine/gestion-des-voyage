package Les_interface;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import DAO.Class_Connection;
import Les_Phond_ecron.Phond_ecron_de_User;

public class User extends JFrame implements ActionListener {
	JLabel nome_utilisateur;
	JLabel Mot_de_passe;
	JButton button_entree, button_nouvel_utilisateur;
	JTextField TextFild_Nome_utilisateur;
	JPasswordField TextFild_Mot_de_passe;
	JPanel panel;
	Phond_ecron_de_User p;
	JButton conn_admin;
	JButton logo_app;
	ImageIcon Icon_admin;
	ImageIcon Icon_app;

	/*
	 * javax.swing.plaf.nimbus.NimbusLookAndFeel
	 * com.sun.java.swing.plaf.motif.MotifLookAndFeel
	 * com.sun.java.swing.plaf.windows.WindowsLookAndFeel
	 * com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel
	 */
	public User() {
		user_name_est_password();
	}

	public void user_name_est_password() {

		// new object
		Icon_app = new ImageIcon(
				"C:\\Users\\WinTen\\OneDrive\\Bureau\\Applicactio_eclipce_web_dynamic\\workSpace\\miniprogect_AGGON\\src\\Les_photo\\Logo_app11.png");
		logo_app = new JButton(Icon_app);
		Icon_admin = new ImageIcon(
				"C:\\Users\\WinTen\\OneDrive\\Bureau\\Applicactio_eclipce_web_dynamic\\workSpace\\miniprogect_AGGON\\src\\Les_photo\\Logo_admin2.png");
		conn_admin = new JButton(Icon_admin);
		nome_utilisateur = new JLabel("Email");
		Mot_de_passe = new JLabel("Mot de passe");
		panel = new JPanel();
		p = new Phond_ecron_de_User();
		TextFild_Mot_de_passe = new JPasswordField();
		TextFild_Nome_utilisateur = new JTextField();
		button_entree = new JButton("Entree");
		button_nouvel_utilisateur = new JButton("Nouveau");

		// -------------------------
		// ----< les paramatre de interface
		setTitle("Gestion des voyage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(1010, 665);
		setLocation(155, 15);
		setVisible(true);
		// --------------------->
		TextFild_Nome_utilisateur.setForeground(Color.black);
		TextFild_Nome_utilisateur.setBackground(Color.white);
		TextFild_Nome_utilisateur.setBounds(230, 70, 160, 25);

		TextFild_Mot_de_passe.setForeground(Color.black);
		TextFild_Mot_de_passe.setBackground(Color.white);
		TextFild_Mot_de_passe.setBounds(230, 110, 160, 25);

		Mot_de_passe.setBackground(Color.black);
		nome_utilisateur.setBackground(Color.black);
		Mot_de_passe.setBounds(65, 110, 140, 25);
		nome_utilisateur.setBounds(65, 70, 140, 25);

		button_entree.setBackground(Color.darkGray);
		button_entree.setForeground(Color.white);
		button_entree.setBounds(60, 160, 100, 25);

		conn_admin.setBounds(870, 20, 100, 100);
		logo_app.setBounds(20, 20, 150, 120);

		button_nouvel_utilisateur.setBackground(Color.darkGray);
		button_nouvel_utilisateur.setForeground(Color.white);
		button_nouvel_utilisateur.setBounds(290, 160, 100, 25);
		// p.setBackground(Color.decode("#08140c"));
		// p.setLayout(null);
		panel.setLayout(null);
		panel.setBounds(290, 180, 450, 250);
		panel.setBackground(Color.decode("#97ccf0"));
		panel.add(Mot_de_passe);
		panel.add(nome_utilisateur);
		panel.add(button_entree);
		panel.add(button_nouvel_utilisateur);
		panel.add(TextFild_Mot_de_passe);
		panel.add(TextFild_Nome_utilisateur);
		p.add(logo_app);
		p.add(conn_admin);
		p.add(panel);
		add(p);
		conn_admin.addActionListener(this);
		button_entree.addActionListener(this);
		button_nouvel_utilisateur.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == conn_admin) {
			this.dispose();
			try {
				UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {
				e1.printStackTrace();
			}
			new Administrateur_V();
		}
		if (button_entree == e.getSource()) {
			if (DAO.User_DAO.scan_User((String) TextFild_Nome_utilisateur.getText(),
					(String) TextFild_Mot_de_passe.getText()) == 1) {
				this.dispose();
				Operation.Style.style();
				new Page_riserver(
						DAO.User_DAO.getPassager(TextFild_Nome_utilisateur.getText(),TextFild_Mot_de_passe.getText()))
						.show_Page_riserver(DAO.User_DAO.getPassager(TextFild_Nome_utilisateur.getText(),
								TextFild_Mot_de_passe.getText()));
			}

		}
		if (e.getSource() == button_nouvel_utilisateur) {
			this.dispose();
			try {
				UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {
				e1.printStackTrace();
			}
			new Add_User();
		}

	}
}
