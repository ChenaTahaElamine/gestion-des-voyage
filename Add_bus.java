package Les_interface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Les_Phond_ecron.Fond_ecron_admin;

public class Add_bus extends JFrame implements ActionListener {
	Fond_ecron_admin fond_ecron;
	private String NOME_UTILISATEUR_AD;
	JLabel N_IMMUTRACULATION, MARQUE, MODEL, NOMBRE_PLACE;
	JTextField TextField_N_IMMUTRACULATION, TextField_MARQUE, TextField_MODEL, TextField_NOMBRE_PLACE;
	JPanel mini_panel;
	JButton reter, ajouter;

	public Add_bus(String NOME_UTILISATEUR_AD) {
		this.NOME_UTILISATEUR_AD = NOME_UTILISATEUR_AD;
		show_Add_bus();
	}

	public void show_Add_bus() {
		// ------< instontiation
		N_IMMUTRACULATION = new JLabel("Numero matricule");
		MARQUE = new JLabel("La marque");
		MODEL = new JLabel("Le model");
		NOMBRE_PLACE = new JLabel("Nombre de place");
		fond_ecron = new Fond_ecron_admin();
		mini_panel = new JPanel();
		reter = new JButton("<-------");
		ajouter = new JButton("Ajouter");
		TextField_N_IMMUTRACULATION = new JTextField();
		TextField_MARQUE = new JTextField();
		TextField_MODEL = new JTextField();
		TextField_NOMBRE_PLACE = new JTextField();
		// --------->
		// --------->
		// -----< add textFild && label && button
		N_IMMUTRACULATION.setForeground(Color.white);
		MARQUE.setForeground(Color.white);
		MODEL.setForeground(Color.white);
		NOMBRE_PLACE.setForeground(Color.white);

		N_IMMUTRACULATION.setBounds(30, 25, 160, 25);
		MARQUE.setBounds(30, 65, 160, 25);
		MODEL.setBounds(30, 105, 160, 25);
		NOMBRE_PLACE.setBounds(30, 145, 160, 25);

		TextField_N_IMMUTRACULATION.setBounds(160, 25, 120, 25);
		TextField_MARQUE.setBounds(160, 65, 120, 25);
		TextField_MODEL.setBounds(160, 105, 120, 25);
		TextField_NOMBRE_PLACE.setBounds(160, 145, 120, 25);

		reter.setBackground(Color.white);
		ajouter.setBackground(Color.white);

		reter.setForeground(Color.black);
		ajouter.setForeground(Color.black);

		reter.setBounds(30, 185, 120, 25);
		;
		ajouter.setBounds(160, 185, 120, 25);
		;
		// ------->
		setTitle("Ajouter un bus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(700, 440);
		setLocation(300, 80);
		setVisible(true);
		setLayout(null);
		mini_panel.setLayout(null);
		mini_panel.setBackground(Color.DARK_GRAY);
		mini_panel.setBounds(190, 70, 310, 230);
		fond_ecron.setBounds(0, 0, 800, 540);
		// _____
		mini_panel.add(reter);
		mini_panel.add(ajouter);

		mini_panel.add(N_IMMUTRACULATION);
		mini_panel.add(MARQUE);
		mini_panel.add(MODEL);
		mini_panel.add(NOMBRE_PLACE);

		mini_panel.add(TextField_N_IMMUTRACULATION);
		mini_panel.add(TextField_MARQUE);
		mini_panel.add(TextField_MODEL);
		mini_panel.add(TextField_NOMBRE_PLACE);
		fond_ecron.add(mini_panel);
		add(fond_ecron);
		// --------------------->
		// --------< add action listener de reter
		reter.addActionListener(this);
		ajouter.addActionListener(this);
		// -------->
	}

	/*
	 * public static void main(String[] args) { try {
	 * UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); }
	 * catch (ClassNotFoundException e1) { e1.printStackTrace(); } catch
	 * (InstantiationException e1) { e1.printStackTrace(); } catch
	 * (IllegalAccessException e1) { e1.printStackTrace(); } catch
	 * (UnsupportedLookAndFeelException e1) { e1.printStackTrace(); } new
	 * Add_bus("amine123");
	 * 
	 * }
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ajouter) {

			DAO.Add_Bus_DAO.create_Bus(TextField_N_IMMUTRACULATION.getText(), TextField_MARQUE.getText(),
					TextField_MODEL.getText(), TextField_NOMBRE_PLACE.getText(), NOME_UTILISATEUR_AD);
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
			new Menu_principale_Administrateur_V(NOME_UTILISATEUR_AD);
		}

	}

}
