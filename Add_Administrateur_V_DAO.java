package DAO;

import java.beans.Beans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;

import Beans.Bus;
import Beans.Voyage;

public class Add_Administrateur_V_DAO {
	private static final String N_bdd = Class_Connection.getNome_dataBase();
	static JLabel p = null;

	// NOME,PRENOM,EMAIL ,PASSWORD
	public static void Insert_Administrateur(String NOME_UTILISATEUR, String NOME, String PRENOM, String EMAIL,
			String PASSWORD) {
		int count = 0;
		if (NOME_UTILISATEUR.equals("") || NOME.equals("") || PRENOM.equals("") || EMAIL.equals("")
				|| PASSWORD.equals("")) {
			p = new JLabel("<html><font color=red>Remplissez tous les champs ,s'il vous plait</font></html>");
			Operation.JoptionMessageError.message_error(p.getText());
		} else if (NOME_UTILISATEUR != "" && NOME != "" && PRENOM != "" && EMAIL != "" && PASSWORD != "") {
			try (Connection conn = Class_Connection.conn_oracle_jdbc();
					PreparedStatement sttmnt_1 = conn
							.prepareStatement("SELECT COUNT(A.NOME_UTILISATEUR) AS N_repetition FROM " + N_bdd
									+ ".administrateur_V A WHERE A.NOME_UTILISATEUR =?"); // create
					PreparedStatement sttmnt_2 = conn.prepareStatement("INSERT INTO " + N_bdd
							+ ".administrateur_V(NOME_UTILISATEUR,NOME,PRENOM,EMAIL ,PASSWORD) VALUES(?,?,?,?,?)");// insert
			) {
				sttmnt_1.setString(1, NOME_UTILISATEUR);
				ResultSet r1 = sttmnt_1.executeQuery();
				while (r1.next()) {
					count = r1.getInt("N_repetition");

				}
				if (count >= 1) {
					p = new JLabel(
							"<html><font color=red>Ce nom a dega ete utilise <br />Veullez utiliser un nouveau nom</font></html>");
					Operation.JoptionMessageError.message_error(p.getText());
				} else if (count == 0) {
					sttmnt_2.setString(1, NOME_UTILISATEUR);
					sttmnt_2.setString(2, NOME);
					sttmnt_2.setString(3, PRENOM);
					sttmnt_2.setString(4, EMAIL);
					sttmnt_2.setString(5, PASSWORD);
					sttmnt_2.execute();
					p = new JLabel(
							"<html>L'administrateur a ete enregistre avec succes .<br /> Votre nom d'utilisateur est <font color=red>"
									+ NOME_UTILISATEUR + "</font></html>");
					Operation.JoptionMessageError.message_information(p.getText());
				}

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

	}

	public static void delete_Administrateur() {
		try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = (PreparedStatement) conn
						.prepareStatement("DELETE " + N_bdd + ".administrateur_V");) {
			p.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static int scan_administrateur_V(String NOME_UTILISATEUR, String PASSWORD) {
		int i = 0;
		if (NOME_UTILISATEUR.equals("") || PASSWORD.equals("")) {
			Operation.Style.style();
			Operation.JoptionMessageError.message_error("Remplire touts les case .");
		}else if (NOME_UTILISATEUR!=("") && PASSWORD!=("")) {
			
			String NOME_UTILISATEUR_AD = null;
			String PASSWORD_AD = null;
			try (Connection conn = Class_Connection.conn_oracle_jdbc();
					PreparedStatement p1 = conn.prepareStatement(
							"SELECT A.NOME_UTILISATEUR FROM " + N_bdd + ".administrateur_V A WHERE A.PASSWORD=?"); // RETURN
																													// NOME_UTILISATEUR
					PreparedStatement p2 = conn.prepareStatement(
							"SELECT A.PASSWORD FROM " + N_bdd + ".administrateur_V A WHERE A.NOME_UTILISATEUR=?");// RETURN
																													// PASSWORD
			) {
				p1.setString(1, PASSWORD);
				ResultSet r1 = p1.executeQuery();
				// _________________
				p2.setString(1, NOME_UTILISATEUR);
				ResultSet r2 = p2.executeQuery();

				while (r1.next()) {
					NOME_UTILISATEUR_AD = r1.getString("NOME_UTILISATEUR");

				}
				while (r2.next()) {
					PASSWORD_AD = r2.getString("PASSWORD");
				}
				// ----------
				if (NOME_UTILISATEUR_AD == null && PASSWORD_AD == null) {
					Operation.JoptionMessageError.message_error("Le nome d'itulisateur est mot de passe est faux");
				} else if (NOME_UTILISATEUR_AD != null && PASSWORD_AD == null) {
					Operation.JoptionMessageError.message_error("Le nome d'itulisateur faux");
				} else if (NOME_UTILISATEUR_AD == null && PASSWORD_AD != null) {
					Operation.JoptionMessageError.message_error("Le mot de passe est faux");
				} else if (NOME_UTILISATEUR_AD != null && PASSWORD_AD != null) {
					Operation.JoptionMessageError.message_information("Les information sont correctes");
					i = 1;
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		return i;
	}
	public static String[][] get_param_voyage() {
		ArrayList<Bus> bus=new ArrayList<>();
		ArrayList<Voyage> voyage=new ArrayList<>();
		String[][] data_voyage_bus=null;
		try (
				Connection conn=Class_Connection.conn_oracle_jdbc();//V.DATE_D
				PreparedStatement p=conn.prepareStatement
						("SELECT V.CODE_V,EXTRACT(YEAR FROM V.DATE_D) year,EXTRACT(MONTH FROM V.DATE_D) month,EXTRACT(DAY FROM V.DATE_D) day,B.MODEL,B.NOMBRE_PLACE FROM "+N_bdd+".voyage V,"+N_bdd+".bus B WHERE V.N_IMMUTRACULATION=B.N_IMMUTRACULATION ORDER BY V.CODE_V ASC");
				){
			ResultSet r=p.executeQuery();
			while (r.next()) {
				bus.add(new Bus
							(
									0,
									N_bdd, 
									r.getString("MODEL"),
									r.getInt("NOMBRE_PLACE"),
									N_bdd
							)
						);
				voyage.add(new Voyage
							(
									r.getInt("CODE_V"),
									r.getString("year")+"/"+r.getString("month")+"/"+r.getString("day"),
									0,
									0, 
									N_bdd)
							);
				
			}
			data_voyage_bus=new String[voyage.size()][5];
			for (int i=0;i<voyage.size();i++) {
				data_voyage_bus[i][0]=""+voyage.get(i).getCODE_V();
				data_voyage_bus[i][1]=voyage.get(i).getDATE_D();
				
				data_voyage_bus[i][2]=bus.get(i).getMODEL();
				data_voyage_bus[i][3]=""+bus.get(i).getNOMBRE_PLACE();
				data_voyage_bus[i][4]=""+DAO.Add_Voyage_DAO.getN_place_vide(voyage.get(i).getCODE_V());
				
			}
			//CODE_V | DATE_D | MODEL | NOMBRE_PLACE | N_place_vide
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return data_voyage_bus;
	}
	

}
