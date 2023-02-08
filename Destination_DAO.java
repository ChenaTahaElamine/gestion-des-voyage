package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import Beans.Destination;

public class Destination_DAO {
	private static final String N_bdd = Class_Connection.getNome_dataBase();

	public static void create_Destination(String VILLE_DS, String NOME_UTILISATEUR_AD) {
		if (VILLE_DS.equals("")) {
			Operation.JoptionMessageError.message_error("Remplire la case de VILLE_DS");
		}else if (VILLE_DS!="") {
			try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
					PreparedStatement p = (PreparedStatement) conn
							.prepareStatement("INSERT INTO " + N_bdd + ".Destination VALUES(?,?,?)");) {
				
				p.setInt(1, (int) (get_max_id_Destination() + 1));
				p.setString(2, VILLE_DS);
				p.setString(3, NOME_UTILISATEUR_AD);
				p.execute();
				Operation.JoptionMessageError.message_information("Destination "+VILLE_DS+" est Enregistrer ");
				
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}

	public static int delete_and_Order_N_CODE_D_asc(int CODE_D) {
		int row = 0;
		int max_id = get_max_id_Destination();
		try {
			// ----<
			Connection conn = Class_Connection.conn_oracle_jdbc();
			PreparedStatement p1 = conn.prepareStatement("DELETE " + N_bdd + ".Destination A WHERE A.CODE_D=?");// --->
			PreparedStatement p2 = null;
			p1.setInt(1, CODE_D);
			p1.execute();
			for (int i = CODE_D; i < max_id; i++) {
				p2 = conn.prepareStatement("UPDATE " + N_bdd + ".Destination A SET A.CODE_D=" + (int) i
						+ " WHERE A.CODE_D=" + (int) (i + 1));
				row = p2.executeUpdate();
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return row;
	}

	public static void delete_Destination() {
		try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = (PreparedStatement) conn.prepareStatement("DELETE " + N_bdd + ".Destination");) {
			p.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static int get_max_id_Destination() {
		int CODE_D = 0;
		try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = (PreparedStatement) conn
						.prepareStatement("SELECT MAX(A.CODE_D) AS MAX_ID FROM " + N_bdd + ".Destination A");) {
			ResultSet r = p.executeQuery();
			while (r.next()) {
				CODE_D = r.getInt("MAX_ID");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return CODE_D;
	}

	public static String[][] get_touts_Destination() {
		String[][] tout_Destination = null;
		ArrayList<Beans.Destination> tout_Destination_array = new ArrayList<>();
		try (Connection conn = (Connection) Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = (PreparedStatement) conn
						.prepareStatement("SELECT A.* FROM " + N_bdd + ".Destination A ORDER BY A.CODE_D ASC");) {
			ResultSet r = p.executeQuery();
			while (r.next()) {

				tout_Destination_array.add(
						new Destination(r.getInt("CODE_D"), r.getString("VILLE_DS"), r.getString("NOME_UTILISATEUR_AD"))

				);
			}
			// CODE_D ,VILLE_DS, NOME_UTILISATEUR_AD
			// 0 , 1, 2
			tout_Destination = new String[tout_Destination_array.size()][3];
			for (int i = 0; i < tout_Destination_array.size(); i++) {
				tout_Destination[i][0] = "" + tout_Destination_array.get(i).getCODE_D();
				tout_Destination[i][1] = tout_Destination_array.get(i).getVILLE_DS();
				tout_Destination[i][2] = tout_Destination_array.get(i).getNOME_UTILISATEUR_AD();
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return tout_Destination;
	}

	public static void Update_Destination(int CODE_D, String VILLE_DS) {
		try (Connection conn = Class_Connection.conn_oracle_jdbc();
				PreparedStatement p = conn
						.prepareStatement("UPDATE " + N_bdd + ".Destination C SET C.VILLE_DS=? WHERE C.CODE_D=?");) {
			p.setString(1, VILLE_DS);
			p.setInt(2, CODE_D);
			p.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
