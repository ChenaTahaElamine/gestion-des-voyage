package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;

import Beans.Adress;

public class Adress_DAO {
	private static final String N_bdd = Class_Connection.getNome_dataBase();

	public static void Create_Adress(String NOM_RUE, String VILLE_AD, String CODE_POSTAL, String NOME_UTILISATEUR_AD) {
		JLabel p1;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = conn.prepareStatement("INSERT INTO " + N_bdd
						+ ".Adress A(A.NEMURO_AD ,A.NOM_RUE,A.VILLE_AD,A.CODE_POSTAL,A.NOME_UTILISATEUR_AD) VALUES(?,?,?,?,?)");) {

			if (NOM_RUE.equals("") || VILLE_AD.equals("") || CODE_POSTAL.equals("")) {
				p1 = new JLabel("<html><font color=red>Remplissez tous les champs ,s'il vous plait</font></html>");
				Operation.JoptionMessageError.message_error(p1.getText());
			} else if (NOM_RUE != "" && VILLE_AD != "" && CODE_POSTAL != "") {
				int test_CODE_POSTAL = (int) Integer.valueOf(CODE_POSTAL);
				p.setInt(1, (int) (get_max_id_Adress() + 1));
				p.setString(2, NOM_RUE);
				p.setString(3, VILLE_AD);
				p.setString(4, "" + test_CODE_POSTAL);
				p.setString(5, NOME_UTILISATEUR_AD);
				p.execute();
				Operation.JoptionMessageError.message_information("Enregistre l'adress avec succes");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			p1 = new JLabel("<html><font color=red>Donner la valeur de code postal integer</font></html>");
			Operation.JoptionMessageError.message_error(p1.getText());
		}
	}

	public static int get_max_id_Adress() {
		int NEMURO_AD = 0;
		try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = (PreparedStatement) conn
						.prepareStatement("SELECT MAX(A.NEMURO_AD) AS MAX_ID FROM " + N_bdd + ".Adress A");) {
			ResultSet r = p.executeQuery();
			while (r.next()) {
				NEMURO_AD = r.getInt("MAX_ID");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return NEMURO_AD;
	}

	public static int delete_and_Order_NEMURO_AD_asc(int NEMURO_AD) {
		int row = 0;
		int max_id = get_max_id_Adress();
		try {
			// ----<
			Connection conn = Class_Connection.conn_oracle_jdbc();
			PreparedStatement p1 = conn.prepareStatement("DELETE " + N_bdd + ".Adress A WHERE A.NEMURO_AD=?");// --->
			PreparedStatement p2 = null;
			p1.setInt(1, NEMURO_AD);
			p1.execute();
			for (int i = NEMURO_AD; i < max_id; i++) {
				p2 = conn.prepareStatement("UPDATE " + N_bdd + ".Adress A SET A.NEMURO_AD=" + (int) i
						+ " WHERE A.NEMURO_AD=" + (int) (i + 1));
				row = p2.executeUpdate();
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return row;
	}

	public static void delete_Adress() {
		try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = (PreparedStatement) conn.prepareStatement("DELETE " + N_bdd + ".Adress");) {
			p.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/* NOM_RUE,VILLE_AD */
	public static Beans.Adress cherch_Adress(String NOM_RUE, String VILLE_AD) {
		Beans.Adress adress = null;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = conn.prepareStatement(
						"SELECT A.* FROM " + N_bdd + ".Adress A WHERE A.NOM_RUE=? AND A.VILLE_AD=?");) {
			p.setString(1, NOM_RUE);
			p.setString(2, VILLE_AD);
			ResultSet r = p.executeQuery();
			while (r.next()) {
				adress = new Adress(r.getInt("NEMURO_AD"), r.getString("NOM_RUE"), r.getString("VILLE_AD"),
						r.getInt("CODE_POSTAL"), r.getString("NOME_UTILISATEUR_AD"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return adress;
	}

	public static String[][] get_tout_les_adress() {
		ArrayList<Beans.Adress> les_adress = new ArrayList<>();
		String[][] data = null;
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = conn
						.prepareStatement("SELECT A.* FROM " + N_bdd + ".Adress A ORDER BY A.NEMURO_AD ASC");) {
			ResultSet r = p.executeQuery();
			while (r.next()) {
				// ,,,,
				les_adress.add(new Adress(r.getInt("NEMURO_AD"), r.getString("NOM_RUE"), r.getString("VILLE_AD"),
						r.getInt("CODE_POSTAL"), r.getString("NOME_UTILISATEUR_AD")));
			}
			data = new String[les_adress.size()][4];
			for (int i = 0; i < les_adress.size(); i++) {
				data[i][0] = "" + les_adress.get(i).getNEMURO_AD();
				data[i][1] = les_adress.get(i).getNOM_RUE();
				data[i][2] = les_adress.get(i).getVILLE_AD();
				data[i][3] = "" + les_adress.get(i).getCODE_POSTAL();
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return data;
	}

}
