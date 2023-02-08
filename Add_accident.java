package Les_interface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import Beans.Accident;
import DAO.Class_Connection;

public class Add_accident {

	private String user_name;
	
	public Add_accident(String user_name) {
		
		this.user_name = user_name;
	}



	public static void show_Add_accident(String user_name) {
		// Declaration est instensiation-----------------<
		JFrame frame_Add_accident = new JFrame();
		JPanel panel=new JPanel(null);
		ImageIcon Icon_Logo=new ImageIcon("C:\\Users\\WinTen\\OneDrive\\Bureau\\Applicactio_eclipce_web_dynamic\\workSpace\\miniprogect_AGGON\\src\\Les_photo\\Logo_app11.png");
		ImageIcon icon_aggoch=new ImageIcon("C:\\Users\\WinTen\\OneDrive\\Bureau\\Applicactio_eclipce_web_dynamic\\workSpace\\miniprogect_AGGON\\src\\Les_photo\\Cap_aggoch.png");
		JButton button_logo=new JButton(Icon_Logo);
		JButton reter=new JButton(icon_aggoch);
		JTable Table_chauffeur;
		JScrollPane sc_chauffeur;
		String[][] data_chauffeur=DAO.Chauffeur_DAO.get_touts_Chauffeur();
		String[] ligner= {"N_SECURITE","NOM_CHF","VILLE_AD"};//N_SECURITE,c.NOM_CHF,a.VILLE_AD
		JLabel annee_accident=new JLabel("Annee");
		JLabel n_accident=new JLabel("Nombre accident ");
		JTextField TextField_annee_accident=new JTextField();
		JTextField TextField_n_accident=new JTextField();
		JButton add_accident=new JButton("Ajouter");
		Beans.Accident accident=new Accident();
		JLabel text_chauffeur_selectioner=new JLabel();
		//------------->
		//------< parametre JPanel
		panel.setLayout(null);
		panel.setBackground(Color.decode("#1860af"));
		panel.setBounds(0, 0, 700, 440);
		//---->
		
		//---< add button
		button_logo.setBounds(520, 20, 140, 110);
		reter.setBackground(Color.black);
		button_logo.setBackground(Color.black);
		reter.setBounds(20, 20, 80, 30);
		
		
		
		add_accident.setBackground(Color.white);
		add_accident.setForeground(Color.black);
		add_accident.setBounds(510, 300, 150, 25);
		//---->
		//--------< add table chauffeur
		Table_chauffeur=new JTable(data_chauffeur, ligner) {
			public boolean isCellEditable(int data_table_distination, int Ligner_table_distination) {
				return false;

			}
		};
		sc_chauffeur=new JScrollPane(Table_chauffeur);
		sc_chauffeur.setBounds(20, 70, 300, 290);
		//--->
		//----< add textFild && lable
		annee_accident.setForeground(Color.white);
		n_accident.setForeground(Color.white);
		text_chauffeur_selectioner.setForeground(Color.black);
		
		annee_accident.setBounds(390,160, 120, 25);
		n_accident.setBounds(390, 190, 120, 25);
		text_chauffeur_selectioner.setBounds(390, 160, 200, 200);
		//___
		TextField_annee_accident.setBounds(510,160, 150, 25);
		TextField_n_accident.setBounds(510, 190, 150, 25);
		//------>
		// ----< les paramatre de interface
		frame_Add_accident.setTitle("Ajouter un accident");
		frame_Add_accident.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_Add_accident.setResizable(false);
		frame_Add_accident.setSize(700, 440);
		frame_Add_accident.setLocation(290, 110);
		frame_Add_accident.setVisible(true);
		frame_Add_accident.setLayout(null);
		// --------------------->
		panel.add(text_chauffeur_selectioner);
		panel.add(add_accident);
		panel.add(TextField_n_accident);
		panel.add(TextField_annee_accident);
		panel.add(n_accident);
		panel.add(annee_accident);
		panel.add(sc_chauffeur);
		panel.add(button_logo);
		panel.add(reter);
		frame_Add_accident.add(panel);
		//----< add action 
		button_logo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==button_logo) {
					frame_Add_accident.dispose();
					Operation.Style.style();
					new Menu_principale_Administrateur_V(user_name);
				}
				
			}
		});
		reter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==reter) {
					frame_Add_accident.dispose();
					Operation.Style.style();
					new Menu_principale_Administrateur_V(user_name);
				}
				
			}
		});
		add_accident.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==add_accident) {
					accident.setANNEE(TextField_annee_accident.getText());
					accident.setN_ACCIDENT(TextField_n_accident.getText());
					DAO.Accident_DAO.create_Accident(accident);
				}
				
			}
		});
		Table_chauffeur.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				//accident.setN_SECURITE();
				//data_chauffeur
				//System.out.println();
				//System.out.println(data_chauffeur[Table_chauffeur.getSelectedRow()][0]);
				accident.setN_SECURITE(Integer.valueOf(data_chauffeur[Table_chauffeur.getSelectedRow()][0]));
				text_chauffeur_selectioner.setText("<html><body><i style=\"color:white\">Malheureusement .<br /> le chauffeur qui a causé l'accident est : "+data_chauffeur[Table_chauffeur.getSelectedRow()][1]+"</i></body></html>");
			}
		});
		//------>
	}
	
}
