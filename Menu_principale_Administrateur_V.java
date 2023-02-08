package Les_interface;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Les_Phond_ecron.Fond_ecron_admin;
import Les_Phond_ecron.Phond_ecron_de_User;

public class Menu_principale_Administrateur_V extends JFrame implements ActionListener {
	ImageIcon Icon_Logo, icon_aggoch, Icon_add_Chauffeur, Icon_add_bus, Icon_add_accident, Icon_add_voyage,
			Icon_voir_les_passager_voyage;
	JButton button_logo, reter, add_Chauffeur, add_bus, add_accident, add_voyage, voir_les_passager_voyage;
	Phond_ecron_de_User p;
	JPanel mini_panel;
	JLabel nome_admin;
	private static String user_name;

	public Menu_principale_Administrateur_V(String user_name) {
		this.user_name = user_name;
		Show_Menu_principale_Administrateur_V();
	}

	/*
	 * public static void main(String[] args) { try {
	 * UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); }
	 * catch (ClassNotFoundException e1) { e1.printStackTrace(); } catch
	 * (InstantiationException e1) { e1.printStackTrace(); } catch
	 * (IllegalAccessException e1) { e1.printStackTrace(); } catch
	 * (UnsupportedLookAndFeelException e1) { e1.printStackTrace(); } try { new
	 * Menu_principale_Administrateur_V("taha"); } catch (IllegalArgumentException
	 * e) { System.out.println(e.getMessage()); }
	 * 
	 * }
	 */

	public void Show_Menu_principale_Administrateur_V() {
		nome_admin = new JLabel("<html>hallo   :<font color=red>" + "   " + (String) user_name + "</font></html>");
		mini_panel = new JPanel();
		Icon_Logo = new ImageIcon(
				"C:\\Users\\WinTen\\OneDrive\\Bureau\\Applicactio_eclipce_web_dynamic\\workSpace\\miniprogect_AGGON\\src\\Les_photo\\Logo_app11.png");
		icon_aggoch = new ImageIcon(
				"C:\\Users\\WinTen\\OneDrive\\Bureau\\Applicactio_eclipce_web_dynamic\\workSpace\\miniprogect_AGGON\\src\\Les_photo\\Cap_aggoch.png");
		p = new Phond_ecron_de_User();
		button_logo = new JButton(Icon_Logo);
		reter = new JButton(icon_aggoch);
		// ______
		Icon_add_Chauffeur = new ImageIcon(
				"C:\\Users\\WinTen\\OneDrive\\Bureau\\Applicactio_eclipce_web_dynamic\\workSpace\\miniprogect_AGGON\\src\\Les_photo\\Add_chafeur.png");
		Icon_add_bus = new ImageIcon(
				"C:\\Users\\WinTen\\OneDrive\\Bureau\\Applicactio_eclipce_web_dynamic\\workSpace\\miniprogect_AGGON\\src\\Les_photo\\Add_bus.png");
		Icon_add_accident = new ImageIcon(
				"C:\\Users\\WinTen\\OneDrive\\Bureau\\Applicactio_eclipce_web_dynamic\\workSpace\\miniprogect_AGGON\\src\\Les_photo\\Add_accident.png");
		Icon_add_voyage = new ImageIcon(
				"C:\\Users\\WinTen\\OneDrive\\Bureau\\Applicactio_eclipce_web_dynamic\\workSpace\\miniprogect_AGGON\\src\\Les_photo\\Add_voyage.png");
		Icon_voir_les_passager_voyage = new ImageIcon(
				"C:\\Users\\WinTen\\OneDrive\\Bureau\\Applicactio_eclipce_web_dynamic\\workSpace\\miniprogect_AGGON\\src\\Les_photo\\Add_voir_les_passager.png");
		// ----
		button_logo = new JButton(Icon_Logo);
		reter = new JButton(icon_aggoch);
		// ------------
		add_Chauffeur = new JButton(Icon_add_Chauffeur);
		add_bus = new JButton(Icon_add_bus);
		add_accident = new JButton(Icon_add_accident);
		add_voyage = new JButton(Icon_add_voyage);
		voir_les_passager_voyage = new JButton(Icon_voir_les_passager_voyage);
		// ----< les paramatre de interface
		setTitle("Menu principale");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(700, 440);
		setLocation(290, 110);
		setVisible(true);
		setLayout(null);
		// --------------------->
		add_Chauffeur.setBounds(40, 10, 120, 120);
		add_bus.setBounds(180, 10, 120, 120);
		add_accident.setBounds(180, 140, 120, 80);
		add_voyage.setBounds(40, 140, 120, 80);
		voir_les_passager_voyage.setBounds(40, 230, 260, 100);

		button_logo.setBounds(20, 55, 140, 110);
		reter.setBackground(Color.black);
		button_logo.setBackground(Color.black);
		reter.setBounds(50, 20, 80, 30);

		// nome_admin.setBackground(Color.black);
		nome_admin.setForeground(Color.black);
		nome_admin.setBounds(530, 20, 100, 25);

		mini_panel.setLayout(null);
		mini_panel.setBackground(Color.DARK_GRAY);
		mini_panel.setBounds(170, 20, 350, 350);
		p.setBounds(0, 0, 700, 440);
		mini_panel.add(add_Chauffeur);
		mini_panel.add(add_accident);
		mini_panel.add(add_bus);
		mini_panel.add(add_voyage);
		mini_panel.add(voir_les_passager_voyage);

		p.add(nome_admin);
		p.add(reter);
		p.add(button_logo);
		p.add(mini_panel);
		add(p);
		// add action listener---<
		button_logo.addActionListener(this);
		reter.addActionListener(this);
		add_Chauffeur.addActionListener(this);
		add_bus.addActionListener(this);
		add_accident.addActionListener(this);
		add_voyage.addActionListener(this);
		voir_les_passager_voyage.addActionListener(this);
		// ------>

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==voir_les_passager_voyage) {
			this.dispose();
			Operation.Style.style();
			new Voyage_place_rest(user_name);
		}
		if (e.getSource()==add_accident) {
			this.dispose();
			Operation.Style.style();
			new Add_accident(user_name).show_Add_accident(user_name);
		}
		if (e.getSource()==add_voyage) {
			this.dispose();
			Operation.Style.style();
			try {
				new Add_voyage(user_name).Show_Add_voyage();
			} catch (NullPointerException e30) {
				System.out.println(e30.getMessage());
			}
		}
		if (e.getSource() == add_bus) {//
			this.dispose();
			Operation.Style.style();
			new Add_bus(user_name);

		}
		if (e.getSource() == add_Chauffeur) {
			this.dispose();
			Operation.Style.style();
			new Add_Chauffeur(user_name).show_Add_Chauffeur();
		}
		if (e.getSource() == button_logo) {
			/*
			 * this.dispose(); try {
			 * UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); }
			 * catch (ClassNotFoundException e1) { e1.printStackTrace(); } catch
			 * (InstantiationException e1) { e1.printStackTrace(); } catch
			 * (IllegalAccessException e1) { e1.printStackTrace(); } catch
			 * (UnsupportedLookAndFeelException e1) { e1.printStackTrace(); } new User();
			 */
		}
		if (e.getSource() == reter) {
			this.dispose();
			Operation.Style.style();
			new Administrateur_V();
		}

	}

}
