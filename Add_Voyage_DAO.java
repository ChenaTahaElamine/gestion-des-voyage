package DAO;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Beans.Chauffeur;
import Beans.Conduire;
import Beans.Constituer;
import Beans.Voyage;
import Les_Phond_ecron.Phond_ecron_de_User;

public class Add_Voyage_DAO {
	private static final String N_bdd = Class_Connection.getNome_dataBase();

	public static void Create_Voyage(int id_bus, int id_distination, int id_chauffeur, String duree, String distence,
			String jours, String mois, String annee, String statut_temporel, String NOME_UTILISATEUR_AD) {

		if (id_bus == 0 || id_distination == 0 || id_chauffeur == 0) {
			Operation.JoptionMessageError.message_error("Selectionner tous les tableaux .");
		} else if (id_bus != 0 && id_distination != 0 && id_chauffeur != 0) {

			if (duree.equals("") || distence.equals("") || jours.equals("jours") || mois.equals("mois")
					|| annee.equals("annee")) {
				Operation.JoptionMessageError.message_error("Remplissez tous les champs ,s'il vous plait .");
			} else if (duree != "" && distence != "" && jours != "jours" && mois != "mois" && annee != "annee") {
				
				if (Operation.Gestion_exeption_voyage_duree_distence.scan_duree_distence(duree, distence) == 1) {
					
					if (DAO.Conduire_DAO.scan_id_conduire(id_chauffeur, id_bus)==0) {
						// ---- < remplire les object
						
						Voyage voyage = new Voyage((get_max_CODE_V() + 1),
								(String) new Beans.Times_tamp_sintax_SQL(Integer.valueOf(annee), Integer.valueOf(mois),
										Integer.valueOf(jours), 1, 1, 1).Timstamp_sintax_sql(statut_temporel),
								Double.valueOf(duree), Integer.valueOf(id_bus), NOME_UTILISATEUR_AD);

						Constituer constituer = new Constituer(Double.valueOf(duree), (int) (get_max_CODE_V() + 1),
								id_distination);

						Conduire conduire = new Conduire(Double.valueOf(distence), id_chauffeur, id_bus);
						
						// ---------->
						
						if (Double.valueOf(distence) >= 500) {
							//-------
							//	CODE_V,DATE_D, DUREE, N_IMMUTRACULATION, NOME_UTILISATEUR_AD
							try (Connection conn = Class_Connection.conn_oracle_jdbc();
									PreparedStatement p = conn.prepareStatement("INSERT INTO "+N_bdd+".voyage values(?,"+voyage.getDATE_D()+",?,?,?)");) {
							
								p.setInt(1, voyage.getCODE_V());
								p.setDouble(2, (double)voyage.getDUREE());
								p.setInt(3, voyage.getN_IMMUTRACULATION());
								p.setString(4, NOME_UTILISATEUR_AD);
								p.execute();
							
							} catch (SQLException e) {
								System.out.println(e.getMessage());
							}
							//-------
							
							DAO.Constituer_DAO.create_Constituer(constituer.getDUREE_S(), constituer.getCODE_V(),
									constituer.getCODE_D());
						
							//-------
							Conduire_chauffeur2(NOME_UTILISATEUR_AD,conduire);
						
						} else if (Double.valueOf(distence) < 500) {
							//-------
							//	CODE_V,DATE_D, DUREE, N_IMMUTRACULATION, NOME_UTILISATEUR_AD
							try (Connection conn = Class_Connection.conn_oracle_jdbc();
									PreparedStatement p = conn.prepareStatement("INSERT INTO "+N_bdd+".voyage values(?,"+voyage.getDATE_D()+",?,?,?)");) {
							
								p.setInt(1, voyage.getCODE_V());
								p.setDouble(2, (double)voyage.getDUREE());
								p.setInt(3, voyage.getN_IMMUTRACULATION());
								p.setString(4, NOME_UTILISATEUR_AD);
								p.execute();
							
							} catch (SQLException e) {
								System.out.println(e.getMessage());
							}
							//-------
							
							DAO.Constituer_DAO.create_Constituer(constituer.getDUREE_S(), constituer.getCODE_V(),
									constituer.getCODE_D());
						
							//-------
							DAO.Conduire_DAO.create_Conduire(conduire);
							Operation.JoptionMessageError.message_information("Le Voyage a ete engigistrer .");
							
						}
					}
					

				}
			}
		}

		// int cODE_V, String dATE_D, int dUREE, int n_IMMUTRACULATION, String
		// NOME_UTILISATEUR_AD
	}

	
	
	public static void Conduire_chauffeur2(String user_name,Beans.Conduire conduire) {
		int id_chauffeur1=conduire.getN_SECURITE();
		JButton add_chauffeur=new JButton("+");
		JLabel N_SECURITE2 = new JLabel("0");
		JFrame form = new JFrame();
		JPanel panel = new JPanel(null);
		JTable table_chauffeur2;
		String[] column = { "N_SECURITE", "NOM_CHF", "Ville" };
		String[][] data_table_chauffeur2 = DAO.Chauffeur_DAO.get_touts_Chauffeur();
		JScrollPane sc_table_chauffeur2;
		JLabel text = new JLabel(
				"<html><body>Choisissez le deuxieme chauffeur <br />pour qu'il soit different du<br /> premier chauffeur :<u style=\"color: #2EFF2E\"> "
						+ DAO.Chauffeur_DAO.cherch_chauffeur(id_chauffeur1).getN_SECURITE() + " \\ "
						+ DAO.Chauffeur_DAO.cherch_chauffeur(id_chauffeur1).getNOM_CHF() + " \\ "
						+ DAO.Chauffeur_DAO.cherch_chauffeur(id_chauffeur1).getPRENOM_CHF() + "</u> </body></html>");

		JButton button = new JButton("Ajouter");
		JLabel chauffeur2 = new JLabel();
		/**/

		table_chauffeur2 = new JTable(data_table_chauffeur2, column) {
			public boolean isCellEditable(int data_table_chauffeur2, int column) {
				return false;

			}
		};
		sc_table_chauffeur2 = new JScrollPane(table_chauffeur2);
		sc_table_chauffeur2.setBounds(50, 50, 300, 300);
		add_chauffeur.setBackground(Color.white);
		add_chauffeur.setForeground(Color.black);
		add_chauffeur.setBounds(350, 50, 40, 40);
		
		text.setBounds(380, 20, 300, 300);
		text.setForeground(Color.white);

		button.setBackground(Color.white);
		button.setForeground(Color.black);
		button.setBounds(460, 200, 115, 25);

		chauffeur2.setForeground(Color.white);
		chauffeur2.setBounds(390, 200, 170, 100);
		// ----< les paramatre de interface
		form.setTitle("Ajouter un chauffeur 2");
		form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		form.setResizable(false);
		form.setSize(700, 440);
		form.setLocation(290, 110);
		form.setVisible(true);
		form.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 700, 440);
		// --------------------->
		panel.add(add_chauffeur);
		panel.add(chauffeur2);
		panel.add(text);
		panel.add(sc_table_chauffeur2);
		panel.add(button);
		form.add(panel);

		// ------<
		//add_chauffeur
		add_chauffeur.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==add_chauffeur) {
					form.dispose();
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
					show_add_neuveau_chauffeur(user_name, conduire);
				}
				
			}
		});
		
		table_chauffeur2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				if (id_chauffeur1 == Integer.valueOf(data_table_chauffeur2[table_chauffeur2.getSelectedRow()][0])) {
					Operation.JoptionMessageError.message_error(
							"<html><body><u style=\"color:red\">Erreur</u><br />J'ai choisi le meme chauffeur que le premier .</body></html>");
				} else if (id_chauffeur1 != Integer
						.valueOf(data_table_chauffeur2[table_chauffeur2.getSelectedRow()][0])) {

					N_SECURITE2.setText(data_table_chauffeur2[table_chauffeur2.getSelectedRow()][0]);

					chauffeur2.setText("<html><body>Le deuxieme chauffeur est : <br /> <u style=\"color: #2EFF2E\">"
							+ data_table_chauffeur2[table_chauffeur2.getSelectedRow()][1] + " \\ "
							+ data_table_chauffeur2[table_chauffeur2.getSelectedRow()][2] + "</u> </body></html>");

				}
			}
		});

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (N_SECURITE2.getText().equals("0")) {
					Operation.JoptionMessageError.message_error("Selectioner votre chauffeur 2.");
				} else if ((String) N_SECURITE2.getText() != "0") {
					conduire.setN_SECURITE2(Integer.valueOf(N_SECURITE2.getText()));
					DAO.Conduire_DAO.create_Conduire(conduire);
					Operation.JoptionMessageError.message_information("Le Voyage a ete engigistrer .");
					form.dispose();
				}

			}
		});
		// ------->
		

	}

	public static void show_add_neuveau_chauffeur(String user_name,Beans.Conduire conduire) {
		JFrame fram=new JFrame();
		Phond_ecron_de_User p = new Phond_ecron_de_User();
		JLabel id_adress=new JLabel("0");
		ImageIcon Icon_Logo = new ImageIcon(
				"C:\\Users\\WinTen\\OneDrive\\Bureau\\Applicactio_eclipce_web_dynamic\\workSpace\\miniprogect_AGGON\\src\\Les_photo\\Logo_app11.png");
		JButton button_logo = new JButton(Icon_Logo);
		JButton add_adress = new JButton("+");
		ImageIcon icon_aggoch = new ImageIcon(
				"C:\\Users\\WinTen\\OneDrive\\Bureau\\Applicactio_eclipce_web_dynamic\\workSpace\\miniprogect_AGGON\\src\\Les_photo\\Cap_aggoch.png");
		JButton reter = new JButton(icon_aggoch);
		JPanel mini_panel = new JPanel();
		JLabel nome_ch = new JLabel("Nome");
		JLabel prenom_ch = new JLabel("Prenom");
		JLabel salare_ch = new JLabel("Salare");
		JLabel adress_ch = new JLabel("Adress                    " + "Selectionnez dans le tableau");
		JLabel telephon_ch = new JLabel("N telephon");
		JTextField TextField_nome_ch = new JTextField();
		JTextField TextField_prenom_ch = new JTextField();
		JTextField TextField_salare_ch = new JTextField();
		JTextField TextField_telephon_ch = new JTextField();
		JButton add_chafeur = new JButton("Ajouter ");
		JButton clear = new JButton("Efacment ");
		
		// -------<add table adress
		String[] ligni = { "NEMURO AD", "NOM RUE", "VILLE AD", "CODE POSTAL" };
		String[][] data_adress = (String[][]) DAO.Adress_DAO.get_tout_les_adress();
		JTable table_adress = new JTable(data_adress, ligni) {
			public boolean isCellEditable(int data_adress, int ligni) {
				return false;

			}
		};
		JScrollPane sc_adress = new JScrollPane(table_adress);
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
		fram.setTitle("Ajouter un chauffeur");
		fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fram.setResizable(false);
		fram.setSize(800, 540);
		fram.setLocation(250, 60);
		fram.setVisible(true);
		fram.setLayout(null);
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
		fram.add(p);
		//-----< add action
		add_adress.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fram.dispose();
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
				show_add_adress(user_name, conduire);
				
			}
		});
		reter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==reter) {
					fram.dispose();
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
					Conduire_chauffeur2(user_name, conduire);
					//Conduire_chauffeur2(Beans.Conduire conduire) 
				}
				
			}
		});
		add_chafeur.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==add_chafeur) {
					
					DAO.Chauffeur_DAO.
					Create_Chauffeur
					(
							TextField_nome_ch.getText(),
							TextField_prenom_ch.getText(),
							TextField_salare_ch.getText(),
							id_adress.getText(),
							user_name,
							TextField_telephon_ch.getText()
					);
				}
				
			}
		});
		table_adress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// { "NEMURO AD", "NOM RUE", "VILLE AD", "CODE POSTAL" }
				// { 0 , 1 , 2 , 3 }
				// data_adress
				try {
					adress_ch.setText("Adress :                  " + data_adress[table_adress.getSelectedRow()][1] + "\\"
							+ data_adress[table_adress.getSelectedRow()][2]);
					id_adress.setText(data_adress[table_adress.getSelectedRow()][0]);
					
				} catch (ArrayIndexOutOfBoundsException e3) {
					System.out.println(e3.getMessage());
				}
			}
		});
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==clear) {
					TextField_nome_ch.setText("");
					TextField_prenom_ch.setText("");
					TextField_salare_ch.setText("");
					TextField_telephon_ch.setText("");
					adress_ch.setText("Adress                    " + "Selectionnez dans le tableau");
					id_adress.setText("0");
				}
				
			}
		});
		//----->
	}
	public static void show_add_adress(String user_name,Beans.Conduire conduire) {
		JFrame mini_window_add_adress=new JFrame();
		
		JButton reter1 = new JButton("<----");
		JLabel NOM_RUE = new JLabel("Nome rue");
		JLabel VILLE_AD = new JLabel("Ville");
		JLabel CODE_POSTAL = new JLabel("Code postal");
		JTextField TextField_NOM_RUE = new JTextField();
		JTextField TextField_VILLE_AD = new JTextField();
		JTextField TextField_CODE_POSTAL = new JTextField();
		JButton ajouter_un_adress = new JButton("Ajouter un adress");
		
		JPanel mini_panel1 = new JPanel();
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
		
		
		//-------< add action
		ajouter_un_adress.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==ajouter_un_adress) {
					DAO.Adress_DAO.Create_Adress
					(
							TextField_NOM_RUE.getText(),
							TextField_VILLE_AD.getText(),
							TextField_CODE_POSTAL.getText(),
							user_name
					);
				}
				
			}
		});
		
		reter1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==reter1) {
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
					show_add_neuveau_chauffeur(user_name, conduire);
				}
				
			}
		});
		////--------->
	}
	
	/*public static void main(String[] args) {
		
		Beans.Conduire conduire = new Conduire(600, 2,9);
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
		Conduire_chauffeur2("amine123", conduire);
		//show_add_adress("amine123", conduire);
	}*/
	
	public static int get_max_CODE_V() {
		int CODE_V = 0;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = conn
						.prepareStatement("SELECT MAX(V.CODE_V) AS max_code_v FROM " + N_bdd + ".voyage V");) {
			ResultSet r = p.executeQuery();
			while (r.next()) {
				CODE_V = r.getInt("max_code_v");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return CODE_V;
	}
	public static int get_n_passager_Voyage(int code_v) {
		//return le nombre de passager que reservier
		int i=0;
		try (
				Connection conn=Class_Connection.conn_oracle_jdbc();
				PreparedStatement p=conn.prepareStatement
				("SELECT COUNT(E.NUM_CL) AS n_p FROM "+N_bdd+".EFFECTUER E,"+N_bdd+".VOYAGE V WHERE E.CODE_V=V.CODE_V AND V.CODE_V=?");
				){//"+N_bdd+".
			p.setInt(1, code_v);
			
			ResultSet r=p.executeQuery();
			while (r.next()) {
				i=r.getInt("n_p");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return i;
	}
	public static int getN_place_vide(int code_v) {
		//return nombre de chase vide dans le voyage
		int id=0;
		try (
				Connection conn=Class_Connection.conn_oracle_jdbc();
				PreparedStatement p=conn.prepareStatement("SELECT (B.NOMBRE_PLACE-"+get_n_passager_Voyage(code_v)+") AS n_p_vide FROM "+N_bdd+".Bus B,"+N_bdd+".VOYAGE VO WHERE VO.N_IMMUTRACULATION=B.N_IMMUTRACULATION AND VO.CODE_V=?");
				){
			p.setInt(1, code_v);
			ResultSet r=p.executeQuery();
			while (r.next()) {
				
				id=r.getInt("n_p_vide");	
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;
	}
	
	

}
