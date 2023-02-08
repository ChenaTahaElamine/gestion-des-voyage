package Les_interface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Les_Phond_ecron.Fond_ecron_admin;

public class Add_Administrateur_V extends JFrame implements ActionListener {
	ImageIcon Icon_Logo, icon_aggoch;
	Fond_ecron_admin p;
	JButton button_logo, reter, Effacement, ajouter;
	JPanel mini_panel;
	JLabel nome, prenome, email, password, NOME_UTILISATEUR;
	JTextField TextField_nome, TextField_prenome, TextField_email, TextField_password, TextField_NOME_UTILISATEUR;

	public Add_Administrateur_V() {
		show_Add_Administrateur_V();
	}

	/*
	 * public static void main(String[] args) { try {
	 * UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); }
	 * catch (ClassNotFoundException e1) { e1.printStackTrace(); } catch
	 * (InstantiationException e1) { e1.printStackTrace(); } catch
	 * (IllegalAccessException e1) { e1.printStackTrace(); } catch
	 * (UnsupportedLookAndFeelException e1) { e1.printStackTrace(); } new
	 * Add_Administrateur_V(); }
	 */

	public void show_Add_Administrateur_V() {
		// -----< instentiation
		NOME_UTILISATEUR = new JLabel("Nome d'itulisat");
		TextField_NOME_UTILISATEUR = new JTextField();
		ajouter = new JButton("Ajouter");
		Effacement = new JButton("Effacement");
		nome = new JLabel("Votre nome");
		prenome = new JLabel("Prenome");
		email = new JLabel("Email");
		password = new JLabel("Mot de passe");
		icon_aggoch = new ImageIcon(
				"C:\\Users\\WinTen\\OneDrive\\Bureau\\Applicactio_eclipce_web_dynamic\\workSpace\\miniprogect_AGGON\\src\\Les_photo\\Cap_aggoch.png");
		reter = new JButton(icon_aggoch);
		Icon_Logo = new ImageIcon(
				"C:\\Users\\WinTen\\OneDrive\\Bureau\\Applicactio_eclipce_web_dynamic\\workSpace\\miniprogect_AGGON\\src\\Les_photo\\Logo_app11.png");
		button_logo = new JButton(Icon_Logo);
		p = new Fond_ecron_admin();
		mini_panel = new JPanel();
		TextField_nome = new JTextField();
		TextField_prenome = new JTextField();
		TextField_email = new JTextField();
		TextField_password = new JTextField();
		// ------->
		// ----< les paramatre de interface
		setTitle("Ajouter un administrateur");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(700, 440);
		setLocation(290, 110);
		setVisible(true);
		setLayout(null);
		// --------------------->
		button_logo.setBounds(20, 50, 140, 110);
		reter.setBackground(Color.black);
		button_logo.setBackground(Color.black);
		reter.setBounds(45, 5, 90, 40);
		p.setBounds(0, 0, 1010, 600);

		// -----< add mini fond ecron
		mini_panel.setBounds(195, 50, 300, 280);
		mini_panel.setBackground(Color.darkGray);
		mini_panel.setLayout(null);
		// ------>
		// ------< add label
		nome.setForeground(Color.white);
		prenome.setForeground(Color.white);
		email.setForeground(Color.white);
		password.setForeground(Color.white);
		NOME_UTILISATEUR.setForeground(Color.white);

		nome.setBounds(30, 30, 150, 25);
		prenome.setBounds(30, 70, 150, 25);
		email.setBounds(30, 110, 150, 25);
		password.setBounds(30, 150, 150, 25);
		NOME_UTILISATEUR.setBounds(30, 190, 150, 25);
		// -------->
		TextField_nome.setBounds(120, 30, 150, 25);
		TextField_prenome.setBounds(120, 70, 150, 25);
		TextField_email.setBounds(120, 110, 150, 25);
		TextField_password.setBounds(120, 150, 150, 25);
		TextField_NOME_UTILISATEUR.setBounds(120, 190, 150, 25);

		ajouter.setBackground(Color.white);
		Effacement.setBackground(Color.white);
		ajouter.setForeground(Color.black);
		Effacement.setForeground(Color.black);
		ajouter.setBounds(160, 230, 110, 25);
		Effacement.setBounds(30, 230, 110, 25);
		// --------< add fond ecron
		p.setBounds(0, 0, 1010, 600);
		mini_panel.add(TextField_NOME_UTILISATEUR);
		mini_panel.add(NOME_UTILISATEUR);
		mini_panel.add(ajouter);
		mini_panel.add(Effacement);
		mini_panel.add(nome);
		mini_panel.add(prenome);
		mini_panel.add(email);
		mini_panel.add(password);
		mini_panel.add(TextField_nome);
		mini_panel.add(TextField_prenome);
		mini_panel.add(TextField_email);
		mini_panel.add(TextField_password);
		p.add(button_logo);
		p.add(reter);
		p.add(mini_panel);
		add(p);
		// -------->

		// -----------< add Action listener
		button_logo.addActionListener(this);
		reter.addActionListener(this);
		Effacement.addActionListener(this);
		ajouter.addActionListener(this);
		// -------------->
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button_logo) {
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
			new User();
		}
		if (e.getSource() == reter) {
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
		if (e.getSource() == Effacement) {
			TextField_nome.setText("");
			TextField_prenome.setText("");
			TextField_email.setText("");
			TextField_password.setText("");
			TextField_NOME_UTILISATEUR.setText("");
		}
		if (e.getSource() == ajouter) {

			DAO.Add_Administrateur_V_DAO.Insert_Administrateur(TextField_NOME_UTILISATEUR.getText(),
					TextField_nome.getText(), TextField_prenome.getText(), TextField_email.getText(),
					TextField_password.getText()

			);
		}

	}

}
