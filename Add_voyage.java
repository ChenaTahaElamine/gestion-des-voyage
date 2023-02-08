package Les_interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Les_Phond_ecron.Fond_ecron_admin;
import Les_Phond_ecron.Phond_ecron_de_User;

public class Add_voyage extends JFrame implements ActionListener {

	JLabel Label_table_chauffour, Label_table_bus, Label_table_distination;
	JButton button_logo, reter, button_add_chauffour, button_add_bus, button_add_distination;
	ImageIcon Icon_Logo, icon_aggoch;
	JPanel panel, mini_panel;
	JTable table_chauffour, table_bus, table_distination;
	JScrollPane Sc_table_chauffour, Sc_table_bus, Sc_table_distination;
	String[] Ligner_table_chauffour = { "N_SECURITE", "NOM", "Nome_vilgle_adress" };
	String[] Ligner_table_bus = { "N_IMMUTRACULATION", "MARQUE", "MODEL", "NOMBRE_PLACE" };
	String[] Ligner_table_distination = { "CODE_D", "VILLE_DS" };
	String[][] data_table_chauffour = DAO.Chauffeur_DAO.get_touts_Chauffeur();// N_SECURITE :0 | NOM_CHF:1 |
	String[][] data_table_bus = DAO.Add_Bus_DAO.get_touts_Bus();
	String[][] data_table_distination = DAO.Destination_DAO.get_touts_Destination();
	String[] List_mois = { "mois", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
	String[] List_jours = { "jours", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
			"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
	String[] List_annee = { "annee", "2023", "2024", "2025", "2026", "2027" };
	JComboBox ComboBox_List_mois, ComboBox_List_jours, ComboBox_List_annee;
	JTextField TextField_duree, TextField_distence;
	JLabel date_v, duree, distence, bus, chauffeur1, Destination;
	JButton Efacement, ajouter;
	private int id_chauffour = 0, id_bus = 0, id_distination = 0;
	// ______________________________
	JFrame frame_button_add_chauffour, frame_button_add_bus, frame_button_add_distination;

	JLabel N_IMMUTRACULATION, MARQUE, MODEL, NOMBRE_PLACE;
	JTextField TextField_N_IMMUTRACULATION, TextField_MARQUE, TextField_MODEL, TextField_NOMBRE_PLACE;
	JPanel mini_panel1;
	JButton reter1, ajouter1;
	String user_name;

	// constrictor
	public Add_voyage(String user_name) {
		this.user_name = user_name;
	}

	// ----< set and get de
	// '+data_table_distination[table_distination.getSelectedRow()][0]'
	public int getId_chauffour() {
		return id_chauffour;
	}

	public void setId_chauffour(int id_chauffour) {
		this.id_chauffour = id_chauffour;
	}

	public int getId_bus() {
		return id_bus;
	}

	public void setId_bus(int id_bus) {
		this.id_bus = id_bus;
	}

	public int getId_distination() {
		return id_distination;
	}

	public void setId_distination(int id_distination) {
		this.id_distination = id_distination;
	}

	// ------->
	// button_add_chauffour, button_add_bus, button_add_distination

	public void show_button_add_distination(String user_name) {
		JLabel VILLE_DS;
		JTextField TextField_VILLE_DS;
		JButton ajouter_un_distination, reter;

		VILLE_DS = new JLabel("Ville ");
		TextField_VILLE_DS = new JTextField();
		ajouter_un_distination = new JButton("Ajouter");
		reter = new JButton("<----");

		JFrame form_add_distination = new JFrame();
		JPanel panel_add_distination = new JPanel(null);
		form_add_distination.setTitle("Ajouter un distination");
		form_add_distination.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		form_add_distination.setResizable(false);
		form_add_distination.setSize(300, 300);
		form_add_distination.setLocation(500, 180);
		form_add_distination.setVisible(true);
		form_add_distination.setLayout(null);
		panel_add_distination.setBackground(Color.DARK_GRAY);
		panel_add_distination.setBounds(0, 0, 300, 300);
		// ---------< add text fild
		VILLE_DS.setForeground(Color.white);

		TextField_VILLE_DS.setBounds(140, 80, 100, 25);
		VILLE_DS.setBounds(50, 80, 100, 25);

		ajouter_un_distination.setBackground(Color.white);
		reter.setBackground(Color.white);
		ajouter_un_distination.setForeground(Color.black);
		reter.setForeground(Color.black);

		ajouter_un_distination.setBounds(150, 130, 90, 25);
		reter.setBounds(50, 130, 90, 25);
		// ---------->

		panel_add_distination.add(VILLE_DS);
		panel_add_distination.add(TextField_VILLE_DS);
		panel_add_distination.add(ajouter_un_distination);
		panel_add_distination.add(reter);
		form_add_distination.add(panel_add_distination);

		// -----< add Action
		ajouter_un_distination.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				DAO.Destination_DAO.create_Destination(TextField_VILLE_DS.getText(), user_name);
			}
		});

		reter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				form_add_distination.dispose();
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
				try {
					new Add_voyage(user_name).Show_Add_voyage();
				} catch (NullPointerException eee) {
					System.out.println(eee.getMessage());
				}

			}
		});
		// ----->
	}

	public void show_button_add_chauffour(String nome_utili_admin) {

		JFrame fond_ecron = new JFrame();
		JTable table_adress;
		JScrollPane sc_adress;
		String[] ligni = { "NEMURO AD", "NOM RUE", "VILLE AD", "CODE POSTAL" };
		String[][] data_adress;
		ImageIcon icon_aggoch;
		JButton add_adress, reter, add_chafeur, add_adress_ch;
		JLabel nome_ch, prenom_ch, salare_ch, adress_ch, telephon_ch;
		JTextField TextField_nome_ch, TextField_prenom_ch, TextField_salare_ch, TextField_telephon_ch;
		JPanel panel;
		JLabel id_adress;
		// JFrame mini_window_add_adress;
		// JLabel NOM_RUE, VILLE_AD, CODE_POSTAL;
		// JTextField TextField_NOM_RUE, TextField_VILLE_AD, TextField_CODE_POSTAL;
		// JButton ajouter_un_adress, reter1;

		// -------< instence
		panel = new JPanel(null);
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
		reter = new JButton("<------");
		id_adress = new JLabel("0");
		add_adress_ch = new JButton("+");
		// ------->
		// ---------<
		fond_ecron.setTitle("Ajouter un chauffeur");
		fond_ecron.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fond_ecron.setResizable(false);
		fond_ecron.setSize(800, 540);
		fond_ecron.setLocation(250, 60);
		fond_ecron.setVisible(true);
		fond_ecron.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 800, 540);
		// --------------------->

		// -------< add lable and text fild
		nome_ch.setForeground(Color.white);
		prenom_ch.setForeground(Color.white);
		salare_ch.setForeground(Color.white);
		adress_ch.setForeground(Color.white);
		telephon_ch.setForeground(Color.white);

		nome_ch.setBounds(500, 100, 130, 25);
		prenom_ch.setBounds(500, 150, 130, 25);
		salare_ch.setBounds(500, 200, 130, 25);
		adress_ch.setBounds(500, 250, 400, 25);
		telephon_ch.setBounds(500, 300, 130, 25);

		TextField_nome_ch.setBounds(600, 100, 130, 25);
		TextField_prenom_ch.setBounds(600, 150, 130, 25);
		TextField_salare_ch.setBounds(600, 200, 130, 25);
		TextField_telephon_ch.setBounds(600, 300, 130, 25);

		add_chafeur.setBackground(Color.white);
		add_chafeur.setForeground(Color.black);
		add_chafeur.setBounds(620, 360, 100, 25);

		reter.setBackground(Color.white);
		reter.setForeground(Color.black);
		reter.setBounds(500, 360, 100, 25);

		// ---->
		// ------<add table
		data_adress = (String[][]) DAO.Adress_DAO.get_tout_les_adress();
		table_adress = new JTable(data_adress, ligni) {
			public boolean isCellEditable(int data_adress, int ligni) {
				return false;

			}
		};
		sc_adress = new JScrollPane(table_adress);
		sc_adress.setBounds(40, 125, 400, 200);
		// --->
		// -----< add adress
		add_adress_ch.setBackground(Color.BLACK);
		add_adress_ch.setForeground(Color.white);
		add_adress_ch.setBounds(390, 325, 50, 25);
		// -->
		// --< add
		panel.add(add_adress_ch);
		panel.add(reter);
		panel.add(add_chafeur);
		panel.add(nome_ch);
		panel.add(prenom_ch);
		panel.add(salare_ch);
		panel.add(adress_ch);
		panel.add(telephon_ch);
		panel.add(TextField_nome_ch);
		panel.add(TextField_prenom_ch);
		panel.add(TextField_salare_ch);
		panel.add(TextField_telephon_ch);
		panel.add(sc_adress);
		fond_ecron.add(panel);
		// -->

		// --< add action
		add_adress_ch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fond_ecron.dispose();
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
				new Add_voyage(nome_utili_admin).show_add_adress(nome_utili_admin);
			}
		});
		table_adress.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				// ttMouseClicked_table_adress(evt);
				id_adress.setText(data_adress[table_adress.getSelectedRow()][0]);
				adress_ch.setText("Adress :                  " + data_adress[table_adress.getSelectedRow()][1] + "\\"
						+ data_adress[table_adress.getSelectedRow()][2]);
			}
		});
		add_chafeur.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == add_chafeur) {
					if (Integer.valueOf(id_adress.getText()) == 0) {
						Operation.JoptionMessageError.message_error("Selectioner adress chaufeur .");
					} else if (Integer.valueOf(id_adress.getText()) != 0) {
						DAO.Chauffeur_DAO.Create_Chauffeur(/*
															 * String NOM_CHF, String PRENOM_CHF, String SALARE, String
															 * NEMURO_AD, String NOME_UTILISATEUR_AD, String N_telephon
															 */
								TextField_nome_ch.getText(), TextField_prenom_ch.getText(),
								TextField_salare_ch.getText(), id_adress.getText(), nome_utili_admin,
								TextField_telephon_ch.getText());
					}
				}
			}
		});
		reter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == reter) {
					fond_ecron.dispose();
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
					try {
						new Add_voyage(nome_utili_admin).Show_Add_voyage();
					} catch (NullPointerException ee) {
						System.out.println(ee.getMessage());
					}

				}
			}
		});
		// ---->
	}

	public void show_add_adress(String nome_utili_admin) {
		// ________________
		JLabel NOM_RUE, VILLE_AD, CODE_POSTAL;
		JTextField TextField_NOM_RUE, TextField_VILLE_AD, TextField_CODE_POSTAL;
		JFrame mini_window_add_adress;
		JButton ajouter_un_adress, reter1;
		// ________________
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
				DAO.Adress_DAO.Create_Adress(TextField_NOM_RUE.getText(), TextField_VILLE_AD.getText(),
						TextField_CODE_POSTAL.getText(), nome_utili_admin);

			}
		});

		reter1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
				new Add_voyage(nome_utili_admin).show_button_add_chauffour(nome_utili_admin);

			}
		});
	}

	public void show_button_add_bus(String user_name1) {
		// ----- < instensiation
		frame_button_add_bus = new JFrame();
		mini_panel1 = new JPanel(null);
		N_IMMUTRACULATION = new JLabel("N_IMMUTRACULATION");
		MARQUE = new JLabel("MARQUE");
		MODEL = new JLabel("MODEL");
		NOMBRE_PLACE = new JLabel("NOMBRE_PLACE");
		TextField_N_IMMUTRACULATION = new JTextField();
		TextField_MARQUE = new JTextField();
		TextField_MODEL = new JTextField();
		TextField_NOMBRE_PLACE = new JTextField();
		ajouter1 = new JButton("Ajouter");
		reter1 = new JButton("<-----");
		// ------->

		// -----< parametre de l'interface
		frame_button_add_bus.setTitle("Ajouter un bus");
		frame_button_add_bus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_button_add_bus.setResizable(false);
		frame_button_add_bus.setSize(500, 440);
		frame_button_add_bus.setLocation(400, 120);
		frame_button_add_bus.setVisible(true);
		frame_button_add_bus.setLayout(null);
		mini_panel1.setBackground(Color.DARK_GRAY);
		mini_panel1.setBounds(0, 0, 500, 440);
		// ------->

		// ------< add
		N_IMMUTRACULATION.setForeground(Color.white);
		MARQUE.setForeground(Color.white);
		MODEL.setForeground(Color.white);
		NOMBRE_PLACE.setForeground(Color.white);

		N_IMMUTRACULATION.setBounds(70, 70, 200, 25);
		MARQUE.setBounds(70, 120, 200, 25);
		MODEL.setBounds(70, 170, 200, 25);
		NOMBRE_PLACE.setBounds(70, 220, 200, 25);

		TextField_N_IMMUTRACULATION.setBounds(250, 70, 150, 25);
		TextField_MARQUE.setBounds(250, 120, 150, 25);
		TextField_MODEL.setBounds(250, 170, 150, 25);
		TextField_NOMBRE_PLACE.setBounds(250, 220, 150, 25);

		reter1.setBackground(Color.white);
		ajouter1.setBackground(Color.white);

		reter1.setBounds(70, 270, 150, 25);
		ajouter1.setBounds(250, 270, 150, 25);
		// -------->
		mini_panel1.add(ajouter1);
		mini_panel1.add(reter1);
		mini_panel1.add(N_IMMUTRACULATION);
		mini_panel1.add(MARQUE);
		mini_panel1.add(MODEL);
		mini_panel1.add(NOMBRE_PLACE);
		mini_panel1.add(TextField_N_IMMUTRACULATION);
		mini_panel1.add(TextField_MARQUE);
		mini_panel1.add(TextField_MODEL);
		mini_panel1.add(TextField_NOMBRE_PLACE);
		frame_button_add_bus.add(mini_panel1);

		// ---< add action // user_name1
		/*
		 * (String N_IMMUTRACULATION, String MARQUE, String MODEL, String NOMBRE_PLACE,
		 * String NOME_UTILISATEUR_AD
		 */
		ajouter1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DAO.Add_Bus_DAO.create_Bus(TextField_N_IMMUTRACULATION.getText(), TextField_MARQUE.getText(),
						TextField_MODEL.getText(), TextField_NOMBRE_PLACE.getText(), user_name1

				);
			}
		});
		reter1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == reter1) {
					frame_button_add_bus.dispose();
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
					new Add_voyage(user_name1).Show_Add_voyage();
				}

			}
		});

		// ------>
	}

	// ___________________________________________

	public void Show_Add_voyage() {
		// -------<instenciation
		panel = new JPanel();
		Icon_Logo = new ImageIcon(
				"C:\\Users\\WinTen\\OneDrive\\Bureau\\Applicactio_eclipce_web_dynamic\\workSpace\\miniprogect_AGGON\\src\\Les_photo\\Logo_app11.png");
		icon_aggoch = new ImageIcon(
				"C:\\Users\\WinTen\\OneDrive\\Bureau\\Applicactio_eclipce_web_dynamic\\workSpace\\miniprogect_AGGON\\src\\Les_photo\\Cap_aggoch.png");
		button_logo = new JButton(Icon_Logo);
		reter = new JButton(icon_aggoch);
		button_add_chauffour = new JButton("+");
		button_add_bus = new JButton("+");
		button_add_distination = new JButton("+");
		Label_table_chauffour = new JLabel("table chauffeur");
		Label_table_bus = new JLabel("table bus");
		Label_table_distination = new JLabel("table distination");
		mini_panel = new JPanel(null);
		ComboBox_List_mois = new JComboBox(List_mois);
		ComboBox_List_jours = new JComboBox(List_jours);
		ComboBox_List_annee = new JComboBox(List_annee);
		date_v = new JLabel("La date");
		duree = new JLabel("Duree");
		distence = new JLabel("Distence   ");
		bus = new JLabel("Bus                             selectioner votre bus .");
		chauffeur1 = new JLabel("Chauffeur                   selectioner votre chaffeur .");
		Destination = new JLabel("Destination                 selectioner votre Destination .");
		TextField_duree = new JTextField();
		TextField_distence = new JTextField();
		Efacement = new JButton("Efacement");
		ajouter = new JButton("Ajouter");

		// list=new JComboBox<>();
		// ----->

		button_logo.setBounds(130, 05, 140, 110);
		reter.setBackground(Color.black);
		button_logo.setBackground(Color.black);
		reter.setBounds(20, 55, 80, 30);

		Label_table_chauffour.setForeground(Color.white);
		Label_table_chauffour.setBounds(40, 120, 120, 25);

		// -----------< add table chaufeur
		/*
		 * { public boolean isCellEditable(int data_adress, int ligni) { return false;
		 * 
		 * }
		 */
		table_chauffour = new JTable(data_table_chauffour, Ligner_table_chauffour) {
			public boolean isCellEditable(int data_table_chauffour, int Ligner_table_chauffour) {
				return false;

			}
		};
		Sc_table_chauffour = new JScrollPane(table_chauffour);
		Sc_table_chauffour.setBounds(30, 150, 350, 400);
		// ---------->
		// -------< add table bus
		table_bus = new JTable(data_table_bus, Ligner_table_bus) {
			public boolean isCellEditable(int data_table_bus, int Ligner_table_bus) {
				return false;

			}
		};

		Label_table_bus.setForeground(Color.white);
		Label_table_bus.setBounds(410, -105, 350, 250);
		Sc_table_bus = new JScrollPane(table_bus);
		Sc_table_bus.setBounds(400, 30, 350, 250);
		// -------->

		// ----< add table distination
		table_distination = new JTable(data_table_distination, Ligner_table_distination) {
			public boolean isCellEditable(int data_table_distination, int Ligner_table_distination) {
				return false;

			}
		};
		Label_table_distination.setForeground(Color.white);
		Label_table_distination.setBounds(410, 230, 350, 200);
		Sc_table_distination = new JScrollPane(table_distination);
		Sc_table_distination.setBounds(400, 350, 350, 200);
		// ----->
		// ----< add button
		button_add_chauffour.setBackground(Color.DARK_GRAY);
		button_add_chauffour.setBounds(340, 550, 40, 40);

		button_add_bus.setBackground(Color.DARK_GRAY);
		button_add_bus.setBounds(710, 280, 40, 40);

		button_add_distination.setBackground(Color.DARK_GRAY);
		button_add_distination.setBounds(710, 550, 40, 40);
		// --->
		// -------< add mini panel
		mini_panel.setBackground(Color.DARK_GRAY);
		mini_panel.setBounds(770, 32, 380, 515);
		// --------->
		// ------< add jlabel && JtextFild and button de minipanel
		date_v.setForeground(Color.white);
		duree.setForeground(Color.white);
		distence.setForeground(Color.white);
		bus.setForeground(Color.white);
		chauffeur1.setForeground(Color.white);

		Destination.setForeground(Color.white);

		date_v.setBounds(50, 60, 250, 25);
		duree.setBounds(50, 120, 250, 25);
		distence.setBounds(50, 180, 250, 25);
		bus.setBounds(50, 240, 250, 25);
		chauffeur1.setBounds(50, 300, 450, 25);

		Destination.setBounds(50, 360, 450, 25);

		ComboBox_List_jours.setBounds(120, 60, 70, 25);
		ComboBox_List_mois.setBounds(190, 60, 70, 25);
		ComboBox_List_annee.setBounds(260, 60, 70, 25);

		TextField_duree.setBounds(165, 120, 160, 25);
		TextField_distence.setBounds(165, 180, 160, 25);

		Efacement.setBackground(Color.white);
		ajouter.setBackground(Color.white);

		Efacement.setForeground(Color.black);
		ajouter.setForeground(Color.black);

		Efacement.setBounds(50, 420, 120, 25);
		ajouter.setBounds(203, 420, 120, 25);
		// -------->
		// -------< les paramatre de add_voyage
		setTitle("Ajouter un voyage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(1200, 640);
		setLocation(40, 30);
		setVisible(true);
		setLayout(null);
		panel.setBackground(Color.decode("#1860af"));
		panel.setLayout(null);
		panel.setBounds(0, 0, 1200, 640);
		// ---------->
		// -----< add
		panel.add(Label_table_distination);
		panel.add(Sc_table_bus);
		panel.add(button_logo);
		panel.add(reter);
		panel.add(Sc_table_chauffour);
		panel.add(button_add_chauffour);
		panel.add(button_add_bus);
		panel.add(Sc_table_distination);
		panel.add(button_add_distination);
		panel.add(Label_table_chauffour);
		panel.add(Label_table_bus);

		/*
		 * String[] listString = {"a","b","c"}; list=new JComboBox(listString);
		 * list.setBounds(20, 20, 120, 25); mini_panel.add(list);
		 */

		mini_panel.add(ComboBox_List_mois);
		mini_panel.add(ComboBox_List_jours);
		mini_panel.add(ComboBox_List_annee);
		mini_panel.add(date_v);
		mini_panel.add(duree);
		mini_panel.add(distence);
		mini_panel.add(bus);
		mini_panel.add(chauffeur1);
		mini_panel.add(Efacement);
		mini_panel.add(ajouter);
		mini_panel.add(Destination);
		mini_panel.add(TextField_distence);
		mini_panel.add(TextField_duree);
		panel.add(mini_panel);
		add(panel);
		// --------->

		// ----- add Action <
		/*
		 * ComboBox_List_annee.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * 
		 * if (e.getSource()==ComboBox_List_annee) {
		 * 
		 * System.out.println((String)ComboBox_List_annee.getSelectedItem());
		 * ComboBox_List_annee.setSelectedIndex(0); } } });
		 */
		table_chauffour.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				ttMouseClicked_table_chauffour(evt);
			}
		});
		table_bus.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				ttMouseClicked_table_bus(evt);
			}
		});
		table_distination.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				ttMouseClicked_table_distination(evt);
			}
		});
		Efacement.addActionListener(this);
		button_add_chauffour.addActionListener(this);
		button_add_bus.addActionListener(this);
		button_add_distination.addActionListener(this);
		ajouter.addActionListener(this);
		button_logo.addActionListener(this);
		reter.addActionListener(this);
		// ------->
	}

	private void ttMouseClicked_table_chauffour(java.awt.event.MouseEvent evt) {
		/*
		 * String[] Ligner_table_chauffour = { "N_SECURITE", "NOM", "Nome_vilgle_adress"
		 */

		chauffeur1.setText(
				"chauffeur :" + "                  " + data_table_chauffour[table_chauffour.getSelectedRow()][1] + "/"
						+ data_table_chauffour[table_chauffour.getSelectedRow()][2]);
		setId_chauffour(Integer.valueOf(data_table_chauffour[table_chauffour.getSelectedRow()][0]));

	}

	private void ttMouseClicked_table_bus(java.awt.event.MouseEvent evt) {
		// String[] Ligner_table_bus = { "N_IMMUTRACULATION", "MARQUE",
		// "MODEL","NOMBRE_PLACE" };

		bus.setText("Bus :" + "                           " + data_table_bus[table_bus.getSelectedRow()][0] + " / "
				+ data_table_bus[table_bus.getSelectedRow()][1] + " / N_place :"
				+ data_table_bus[table_bus.getSelectedRow()][3]);
		setId_bus(Integer.valueOf(data_table_bus[table_bus.getSelectedRow()][0]));

	}

	private void ttMouseClicked_table_distination(java.awt.event.MouseEvent evt) {
		// String[] Ligner_table_distination = { "CODE_D", "VILLE_DS"};

		setId_distination(Integer.valueOf(data_table_distination[table_distination.getSelectedRow()][0]));
		Destination
				.setText("Destination :               " + data_table_distination[table_distination.getSelectedRow()][0]
						+ " / " + data_table_distination[table_distination.getSelectedRow()][1]);

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

            new Menu_principale_Administrateur_V(user_name);
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

	            new Menu_principale_Administrateur_V(user_name);
			
		}
		if (e.getSource() == ajouter) {
			try {
				DAO.Add_Voyage_DAO.Create_Voyage(getId_bus(), getId_distination(), getId_chauffour(),
						TextField_duree.getText(), TextField_distence.getText(),
						"" + ComboBox_List_jours.getSelectedItem(), "" + ComboBox_List_mois.getSelectedItem(),
						"" + ComboBox_List_annee.getSelectedItem(), "PM", user_name);
			} catch (NumberFormatException e2) {
				System.out.println(e2.getMessage());
			}

		}
		if (e.getSource() == Efacement) {
			ComboBox_List_mois.setSelectedIndex(0);
			ComboBox_List_jours.setSelectedIndex(0);
			ComboBox_List_annee.setSelectedIndex(0);
			bus.setText("Bus                             selectioner votre bus .");
			chauffeur1.setText("Chauffeur                   selectioner votre chaffeur .");
			Destination.setText("Destination                 selectioner votre Destination .");
			setId_bus(0);
			setId_chauffour(0);
			setId_distination(0);
			TextField_duree.setText("");
			TextField_distence.setText("");

		}
		if (e.getSource() == button_add_bus) {
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
			new Add_voyage(user_name).show_button_add_bus(user_name);
		}
		if (e.getSource() == button_add_chauffour) {
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
			new Add_voyage(user_name).show_button_add_chauffour(user_name);
		}

		if (e.getSource() == button_add_distination) {
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
			new Add_voyage(user_name).show_button_add_distination(user_name);
		}
	}

}
