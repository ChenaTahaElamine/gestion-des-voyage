package Les_interface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Beans.Passager;
import Les_Phond_ecron.Phond_ecron_de_User;

public class Page_riserver {

	private Beans.Passager Pass;

	public Page_riserver(Beans.Passager Pass) {
		this.Pass = Pass;

	}

	public static void show_Page_riserver(Beans.Passager Pass) {
		JFrame frame = new JFrame();// #015D09
		JPanel p = new JPanel(null);
		JLabel label = new JLabel(
				"<html><body><i style=\"font-size: 23px;\">Bonjour monsieur :<u style=\"color : #041060 \">" +

						Pass.getNOM_PS() + "</u></i></body></html>");

		JButton reter = new JButton("<------");
		JButton riserver = new JButton("------>");
		// ------<
		p.setBounds(0, 0, 700, 440);
		p.setBackground(Color.decode("#A7B1F0"));
		label.setBounds(150, 130, 400, 30);

		reter.setBounds(150, 100, 90, 25);
		reter.setForeground(Color.black);

		riserver.setBounds(400, 260, 90, 25);
		riserver.setForeground(Color.black);
		// --------->
		// ----< les paramatre de interface
		frame.setTitle("bienvenue");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(700, 440);
		frame.setLocation(290, 110);
		frame.setVisible(true);
		frame.setLayout(null);
		// --------------------->
		p.add(riserver);
		p.add(reter);
		p.add(label);
		frame.add(p);
		// ----< add action
		riserver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == riserver) {
					frame.dispose();
					Operation.Style.style();
					show_Page_riserver2(Pass);
				}

			}
		});
		reter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == reter) {
					frame.dispose();
					Operation.Style.style();
					new User();
				}

			}
		});

		// ------>
	}

	public static void show_Page_riserver2(Beans.Passager Pass) {// NullPointerException
		JFrame fram = new JFrame();
		JPanel panel = new JPanel(null);
		JLabel label = new JLabel("<html><body><i style=\"font-size: 18px;\">Bonjour monsieur : " + Pass.getPRENOM_PS()
				+ "<br />Sélectionnez le voyage que vous souhaitez .</i></body></html>");
		JLabel ligne = new JLabel(
				"<html><body><i style=\"font-size: 50px;\">_______________________________________________________________________________________________________________________</i></body></html>");
		JButton reter = new JButton("<--------");
		JButton compt = new JButton("Compte");
		String[] row = { "CODE_V", "DATE_D", "MODEL", "NOMBRE_PLACE", "N_place_vide", "VILLE_DS" };
		String[][] data = DAO.User_DAO.get_voyageS();
		JTable table;
		JScrollPane sc;
		JButton ajouter_E = new JButton("Ajouter");
		JLabel id_v = new JLabel("0");

		
		panel.setBackground(Color.decode("#A7B1F0"));
		panel.setBounds(0, 0, 800, 540);

		label.setBounds(160, 5, 1000, 100);

		ligne.setBounds(0, 5, 1000, 130);
		ligne.setForeground(Color.white);

		reter.setForeground(Color.black);
		reter.setBounds(45, 35, 90, 35);

		compt.setForeground(Color.black);
		compt.setBounds(650, 35, 90, 35);// NullPointerException

		// -----< add table
		table = new JTable(data, row) {
			public boolean isCellEditable(int data, int row) {
				return false;

			}
		};
		sc = new JScrollPane(table);
		sc.setBounds(45, 170, 695, 250);

		ajouter_E.setForeground(Color.black);
		ajouter_E.setBounds(650, 430, 90, 35);
		// ------->
		// ---------<
		fram.setTitle("Réservation de voyage");
		fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fram.setResizable(false);
		fram.setSize(800, 540);
		fram.setLocation(250, 70);
		fram.setVisible(true);
		fram.setLayout(null);
		// --------------------->
		panel.add(ajouter_E);
		panel.add(sc);
		panel.add(compt);
		panel.add(reter);
		panel.add(ligne);
		panel.add(label);
		fram.add(panel);

		// ----< add action
		compt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==compt) {
					fram.dispose();
					Operation.Style.style();
					compte_pass(Pass);
				}				
			}
		});
		
		ajouter_E.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == ajouter_E) {
					DAO.Effectuer_dao.insert_Effectuer(Pass.getNUM_CL(), Integer.valueOf(id_v.getText()));
					fram.dispose();
					Operation.Style.style();
					show_Page_riserver2(Pass);
				}

			}
		});
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				if (Integer.valueOf(data[table.getSelectedRow()][4]) == 0) {// 4
					Operation.Style.style();
					Operation.JoptionMessageError
							.message_error("Désolé monsieur " + Pass.getNOM_PS() + " . Les places sont terminées");
				} else if (Integer.valueOf(data[table.getSelectedRow()][4]) > 0) {
					id_v.setText("" + data[table.getSelectedRow()][0]);
				}

			}
		});
		reter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fram.dispose();
				Operation.Style.style();
				show_Page_riserver(Pass);

			}
		});

		// -------->
	}
	public static void compte_pass(Beans.Passager Pass) {
		//-------<
		JFrame fram = new JFrame();
		JPanel panel = new JPanel(null);
		JButton modify=new JButton("Modifer");
		JButton reter=new JButton("<------");
		
		JLabel NOM_PS=new JLabel("Nome");
		JLabel PRENOM_PS=new JLabel("Prenom");  
		JLabel NUM_TEL =new JLabel("N telephon");
		JLabel EMAIL_PS =new JLabel("Email");
		JLabel PASSWORD_PS=new JLabel("Password");
		JLabel Confirm_PASSWORD_PS=new JLabel("Confirmation pass");
		
		JTextField TextField_NOM_PS=new JTextField(Pass.getNOM_PS());
		JTextField TextField_PRENOM_PS=new JTextField(Pass.getPRENOM_PS());  
		JTextField TextField_NUM_TEL =new JTextField("0"+Pass.getNUM_TEL());
		JTextField TextField_EMAIL_PS =new JTextField(Pass.getEMAIL_PS());
		JPasswordField TextField_PASSWORD_PS=new JPasswordField(Pass.getPASSWORD_PS());
		JPasswordField TextField_Confirm_PASSWORD_PS=new JPasswordField(Pass.getPASSWORD_PS());
		//---------->
		
		NOM_PS.setBounds(300, 50, 120, 25);
		PRENOM_PS.setBounds(300, 100, 120, 25);  
		NUM_TEL.setBounds(300, 150, 120, 25);
		EMAIL_PS.setBounds(300, 200, 120, 25);
		PASSWORD_PS.setBounds(300, 250, 120, 25);
		Confirm_PASSWORD_PS.setBounds(300, 300, 120, 25);
		
		TextField_NOM_PS.setBounds(420, 50, 120, 25);
		TextField_PRENOM_PS.setBounds(420, 100, 120, 25);  
		TextField_NUM_TEL.setBounds(420, 150, 120, 25);
		TextField_EMAIL_PS.setBounds(420, 200, 120, 25);
		TextField_PASSWORD_PS.setBounds(420, 250, 120, 25);
		TextField_Confirm_PASSWORD_PS.setBounds(420, 300, 120, 25);
		
		reter.setForeground(Color.black);
		reter.setBounds(50, 50, 90, 25);
		
		modify.setForeground(Color.black);
		modify.setBounds(50, 150, 90, 25);
		
		//---------->
		panel.setBackground(Color.decode("#A7B1F0"));
		panel.setBounds(0, 0, 800, 540);
		fram.setTitle("Compte");
		fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fram.setResizable(false);
		fram.setSize(600, 440);
		fram.setLocation(350, 100);
		fram.setVisible(true);
		fram.setLayout(null);
		// --------------------->
		panel.add(TextField_NOM_PS);
		panel.add(TextField_PRENOM_PS);
		panel.add(TextField_NUM_TEL);
		panel.add(TextField_EMAIL_PS);
		panel.add(TextField_PASSWORD_PS);
		panel.add(TextField_Confirm_PASSWORD_PS);
		
		panel.add(NOM_PS);
		panel.add(PRENOM_PS);
		panel.add(NUM_TEL);
		panel.add(EMAIL_PS);
		panel.add(PASSWORD_PS);
		panel.add(Confirm_PASSWORD_PS);
		panel.add(modify);
		panel.add(reter);
		fram.add(panel);
		//---< action 
		/*TextField_NOM_PS=new JTextField(Pass.getNOM_PS());
		 TextField_PRENOM_PS=new JTextField(Pass.getPRENOM_PS());  
		 TextField_NUM_TEL =new JTextField("0"+Pass.getNUM_TEL());
		 TextField_EMAIL_PS =new JTextField(Pass.getEMAIL_PS());
		 TextField_PASSWORD_PS=new JPasswordField(Pass.getPASSWORD_PS());
		 TextField_Confirm_PASSWORD_PS=new JPasswordField(Pass.getPASSWORD_PS());*/
		modify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==modify) {
					DAO.User_DAO.Update_passager
					(
							TextField_NOM_PS.getText(),
							TextField_PRENOM_PS.getText(),
							TextField_NUM_TEL.getText(),
							TextField_EMAIL_PS.getText(),
							TextField_PASSWORD_PS.getText(),
							TextField_Confirm_PASSWORD_PS.getText(),
							Pass.getNUM_CL()
					);
				}
				
			}
		});
		reter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==reter) {
					fram.dispose();
					Operation.Style.style();
					show_Page_riserver2(Pass);
				}
				
			}
		});
		//------->
	}

	

}
