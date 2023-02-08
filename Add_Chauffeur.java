package Les_interface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Les_Phond_ecron.Phond_ecron_de_User;

public class Add_Chauffeur extends JFrame implements ActionListener {
	Phond_ecron_de_User p;
	JTable table_adress;
	JScrollPane sc_adress;
	String[] ligni = { "NEMURO AD", "NOM RUE", "VILLE AD", "CODE POSTAL" };
	String[][] data_adress;
	ImageIcon Icon_Logo, icon_aggoch;
	JButton button_logo, add_adress, reter, add_chafeur, clear;
	JPanel mini_panel, mini_panel1;
	JLabel nome_ch, prenom_ch, salare_ch, adress_ch, telephon_ch;
	JTextField TextField_nome_ch, TextField_prenom_ch, TextField_salare_ch, TextField_telephon_ch;
	String nome_utili_admin;
	JFrame mini_window_add_adress;
	JLabel NOM_RUE, VILLE_AD, CODE_POSTAL;
	JTextField TextField_NOM_RUE, TextField_VILLE_AD, TextField_CODE_POSTAL;
	JButton ajouter_un_adress, reter1;
	String id_adress = "0";

	public Add_Chauffeur(String nome_utili_admin) {
		this.nome_utili_admin = nome_utili_admin;

	}

	/*
	 * public static void main(String[] args) { try {
	 * UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); }
	 * catch (ClassNotFoundException e1) { e1.printStackTrace(); } catch
	 * (InstantiationException e1) { e1.printStackTrace(); } catch
	 * (IllegalAccessException e1) { e1.printStackTrace(); } catch
	 * (UnsupportedLookAndFeelException e1) { e1.printStackTrace(); } new
	 * Add_Chauffeur("amine123").show_Add_Chauffeur(); //new
	 * Add_Chauffeur("amine123").show_add_adress(); }
	 */

	public void show_add_adress() {
		reter1 = new JButton("<----");
		NOM_RUE = new JLabel("Nome rue");
		VILLE_AD = new JLabel("Ville");
		CODE_POSTAL = new JLabel("Code postal");
		TextField_NOM_RUE = new JTextField();
		TextField_VILLE_AD = new JTextField();
		TextField_CODE_POSTAL = new JTextField();
		ajouter_un_adress = new JButton("Ajouter un adress");
		mini_window_add_adress = new JFrame();
		mini_panel1 = new JPanel();
		mini_panel1.setBackground(Color.DARK_GRAY);
		mini_panel1.setBounds(0, 0, 300, 300);
		// ---<add label textfild button
		NOM_RUE.setForeground(Color.white);
		VILLE_AD.setForeground(Color.white);
		CODE_POSTAL.setForeground(Color.white);
		NOM_RUE.setBounds(30, 50, 120, 25);
		VILLE_AD.setBounds(30, 100, 120, 25);
		CODE_POSTAL.setBounds(30, 150, 120, 25);

		TextField_NOM_RUE.setBounds(130, 50, 120, 25);
		TextField_VILLE_AD.setBounds(130, 100, 120, 25);
		TextField_CODE_POSTAL.setBounds(130, 150, 120, 25);

		ajouter_un_adress.setForeground(Color.black);
		ajouter_un_adress.setBackground(Color.white);
		ajouter_un_adress.setBounds(70, 190, 150, 25);

		reter1.setForeground(Color.black);
		reter1.setBackground(Color.white);
		reter1.setBounds(30, 10, 60, 25);
		// ----->

		// ---------<
		mini_window_add_adress.setTitle("Ajouter un Adress");
		mini_window_add_adress.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mini_window_add_adress.setResizable(false);
		mini_window_add_adress.setSize(300, 300);
		mini_window_add_adress.setLocation(500, 160);
		mini_window_add_adress.setVisible(true);
		mini_window_add_adress.setLayout(null);
		// --------------------->
		mini_panel1.add(reter1);
		mini_panel1.add(ajouter_un_adress);
		mini_panel1.add(TextField_NOM_RUE);
		mini_panel1.add(TextField_VILLE_AD);
		mini_panel1.add(TextField_CODE_POSTAL);
		mini_panel1.add(NOM_RUE);
		mini_panel1.add(VILLE_AD);
		mini_panel1.add(CODE_POSTAL);
		mini_panel1.setLayout(null);
		mini_window_add_adress.add(mini_panel1);

		ajouter_un_adress.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == ajouter_un_adress) {
					DAO.Adress_DAO.Create_Adress(TextField_NOM_RUE.getText(), TextField_VILLE_AD.getText(),
							TextField_CODE_POSTAL.getText(), nome_utili_admin

					);
					mini_window_add_adress.dispose();
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
					new Add_Chauffeur(nome_utili_admin).show_Add_Chauffeur();
				}

			}
		});
		reter1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == reter1) {
					mini_window_add_adress.dispose();
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
					new Add_Chauffeur(nome_utili_admin).show_Add_Chauffeur();
				}

			}
		});
	}

	public void show_Add_Chauffeur() {
		p = new Phond_ecron_de_User();
		Icon_Logo = new ImageIcon(
				"C:\\Users\\WinTen\\OneDrive\\Bureau\\Applicactio_eclipce_web_dynamic\\workSpace\\miniprogect_AGGON\\src\\Les_photo\\Logo_app11.png");
		button_logo = new JButton(Icon_Logo);
		add_adress = new JButton("+");
		icon_aggoch = new ImageIcon(
				"C:\\Users\\WinTen\\OneDrive\\Bureau\\Applicactio_eclipce_web_dynamic\\workSpace\\miniprogect_AGGON\\src\\Les_photo\\Cap_aggoch.png");
		reter = new JButton(icon_aggoch);
		mini_panel = new JPanel();
		nome_ch = new JLabel("Nome");
		prenom_ch = new JLabel("Prenom");
		salare_ch = new JLabel("Salare");
		adress_ch = new JLabel("Adress                    " + "Selectionnez dans le tableau");
		telephon_ch = new JLabel("N telephon");
		TextField_nome_ch = new JTextField();
		TextField_prenom_ch = new JTextField();
		TextField_salare_ch = new JTextField();
		TextField_telephon_ch = new JTextField();
		add_chafeur = new JButton("Ajouter ");
		clear = new JButton("Efacment ");
		// -------<add table adress
		data_adress = (String[][]) DAO.Adress_DAO.get_tout_les_adress();
		table_adress = new JTable(data_adress, ligni) {
			public boolean isCellEditable(int data_adress, int ligni) {
				return false;

			}
		};
		sc_adress = new JScrollPane(table_adress);
		sc_adress.setBounds(10, 125, 400, 200);
		// -------------->
		// -----< add button
		button_logo.setBounds(120, 10, 140, 110);
		reter.setBounds(30, 50, 70, 40);
		add_adress.setBackground(Color.DARK_GRAY);
		add_adress.setForeground(Color.white);
		add_adress.setBounds(375, 325, 35, 35);
		// ------->
		// -------< add label && textFild && button ajouter,efacment
		nome_ch.setForeground(Color.white);
		prenom_ch.setForeground(Color.white);
		salare_ch.setForeground(Color.white);
		adress_ch.setForeground(Color.white);
		telephon_ch.setForeground(Color.white);

		nome_ch.setBounds(50, 60, 130, 25);
		prenom_ch.setBounds(50, 110, 130, 25);
		salare_ch.setBounds(50, 160, 130, 25);
		adress_ch.setBounds(50, 210, 400, 25);
		telephon_ch.setBounds(50, 260, 130, 25);

		TextField_nome_ch.setBounds(150, 60, 130, 25);
		TextField_prenom_ch.setBounds(150, 110, 130, 25);
		TextField_salare_ch.setBounds(150, 160, 130, 25);
		TextField_telephon_ch.setBounds(150, 260, 130, 25);

		add_chafeur.setBackground(Color.white);
		clear.setBackground(Color.white);

		add_chafeur.setForeground(Color.black);
		clear.setForeground(Color.black);

		add_chafeur.setBounds(180, 320, 100, 25);
		clear.setBounds(50, 320, 100, 25);
		// ----< les paramatre de interface

		// ------< add mini_panel
		mini_panel.setLayout(null);
		mini_panel.setBackground(Color.DARK_GRAY);
		mini_panel.setBounds(420, 40, 350, 410);
		// --------->
		setTitle("Ajouter un chauffeur");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(800, 540);
		setLocation(250, 60);
		setVisible(true);
		setLayout(null);
		// --------------------->
		mini_panel.add(add_chafeur);
		mini_panel.add(clear);
		mini_panel.add(nome_ch);
		mini_panel.add(prenom_ch);
		mini_panel.add(salare_ch);
		mini_panel.add(adress_ch);
		mini_panel.add(telephon_ch);
		mini_panel.add(TextField_nome_ch);
		mini_panel.add(TextField_prenom_ch);
		mini_panel.add(TextField_salare_ch);
		mini_panel.add(TextField_telephon_ch);
		p.add(mini_panel);
		p.add(add_adress);
		p.add(reter);
		p.add(button_logo);
		p.add(sc_adress);
		p.setBounds(0, 0, 800, 540);
		add(p);
		button_logo.addActionListener(this);
		reter.addActionListener(this);
		clear.addActionListener(this);
		add_adress.addActionListener(this);
		add_chafeur.addActionListener(this);
		table_adress.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				ttMouseClicked(evt);
			}
		});

	}

	private void ttMouseClicked(java.awt.event.MouseEvent evt) {
		// { "NEMURO AD", "NOM RUE", "VILLE AD", "CODE POSTAL" }
		// { 0 , 1 , 2 , 3 }
		// data_adress
		try {
			adress_ch.setText("Adress :                  " + data_adress[table_adress.getSelectedRow()][1] + "\\"
					+ data_adress[table_adress.getSelectedRow()][2]);
			id_adress = data_adress[table_adress.getSelectedRow()][0];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add_chafeur) {
			
				// (String NOM_CHF, String PRENOM_CHF,
				// String SALARE, String NEMURO_AD, String NOME_UTILISATEUR_AD, String
				// N_telephon)
				DAO.Chauffeur_DAO.Create_Chauffeur(TextField_nome_ch.getText(), TextField_prenom_ch.getText(),
						TextField_salare_ch.getText(), id_adress, nome_utili_admin,
						TextField_telephon_ch.getText());

			

		}

		if (e.getSource() == add_adress) {
			// add_adress
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
			new Add_Chauffeur(nome_utili_admin).show_add_adress();
		}
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
			new Menu_principale_Administrateur_V(nome_utili_admin);
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
			new Menu_principale_Administrateur_V(nome_utili_admin);
		}
		if (e.getSource() == clear) {
			TextField_nome_ch.setText("");
			TextField_prenom_ch.setText("");
			TextField_salare_ch.setText("");
			TextField_telephon_ch.setText("");
			adress_ch.setText("Adress                    " + "Selectionnez dans le tableau");
			id_adress = "0";
		}

	}

}
