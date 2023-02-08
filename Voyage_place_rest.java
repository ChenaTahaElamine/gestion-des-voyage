package Les_interface;

import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Scrollable;

import Les_Phond_ecron.Fond_ecron_admin;

public class Voyage_place_rest {
	private String user_name;

	public Voyage_place_rest(String user_name) {
		this.user_name = user_name;
		show_Voyage_place_rest();
	}

	public void show_Voyage_place_rest() {
		JFrame frame_Voyage_place_rest = new JFrame();
		Fond_ecron_admin panel = new Fond_ecron_admin();
		ImageIcon icon = new ImageIcon(
				"C:\\Users\\WinTen\\OneDrive\\Bureau\\Applicactio_eclipce_web_dynamic\\workSpace\\miniprogect_AGGON\\src\\Les_photo\\Cap_aggoch.png");
		JButton reter = new JButton(icon);
		String[] row = { "CODE_V", "DATE_D", "MODEL", "NOMBRE PLACE", "N place vide" };
		String[][] data = DAO.Add_Administrateur_V_DAO.get_param_voyage();
		JTable table_v;
		JScrollPane sc;
		JButton add_voyage=new JButton("+");
		// --------< add button
		reter.setBounds(35, 40, 80, 30);
		reter.setBackground(Color.black);
		
		add_voyage.setForeground(Color.black);
		add_voyage.setBackground(Color.white);
		add_voyage.setBounds(75, 300, 40, 40);
		// --------->
		// ------< add table

		table_v = new JTable(data, row) {
			public boolean isCellEditable(int data, int row) {
				return false;

			}
		};

		sc = new JScrollPane(table_v);
		sc.setBounds(120, 40, 470, 300);
		// ---------->
		// ----< les paramatre de interface
		frame_Voyage_place_rest.setTitle("Controle de donner");
		frame_Voyage_place_rest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_Voyage_place_rest.setResizable(false);
		frame_Voyage_place_rest.setSize(700, 440);
		frame_Voyage_place_rest.setLocation(290, 110);
		frame_Voyage_place_rest.setVisible(true);
		frame_Voyage_place_rest.setLayout(null);
		// --------------------->
		panel.setBounds(0, 0, 700, 440);
		panel.add(add_voyage);
		panel.add(sc);
		panel.add(reter);
		frame_Voyage_place_rest.add(panel);
		//------< add action 
		add_voyage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==add_voyage) {
					frame_Voyage_place_rest.dispose();
					Operation.Style.style();
					new Add_voyage(user_name).Show_Add_voyage();
				}
				
			}
		});
		reter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==reter) {
					frame_Voyage_place_rest.dispose();
					Operation.Style.style();
					new Menu_principale_Administrateur_V(user_name);
				}
				
			}
			
		});
		
		//------>
	}

	

}
